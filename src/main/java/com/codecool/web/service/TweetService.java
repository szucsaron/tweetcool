package com.codecool.web.service;

import com.codecool.web.model.Tweet;
import com.codecool.web.model.TweetContainer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TweetService {
    private static int DEFAULT_LIMIT = 20;
    private TweetContainer tweetContainer;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");


    public TweetService(TweetContainer tweetContainer) {
        this.tweetContainer = tweetContainer;
    }

    public List<Tweet> getFilteredTweets(String limit, String offset, String poster, String fromDate, String fromTime) {
        try {
            poster = convertStr(poster);

            List<Tweet> tweets = tweetContainer.getTweets();
            Date fromVal = parseDate(fromDate, fromTime);
            int limitVal = getInt(limit);
            if (limitVal == 0) {
                limitVal = DEFAULT_LIMIT;
            }
            int startIndex = getInt(offset);
            int endIndex = limitVal + startIndex;

            int size = tweets.size();
            if (endIndex > size) {
                endIndex = size;
            }
            return getTweets(tweets, startIndex, endIndex, poster, fromVal);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Wrong input given!");
        }
    }

    public List<Tweet> getAllTweets() {
        return tweetContainer.getTweets();
    }

    public void addTweet(String name, String text) {
        if (name == null) {
            throw new IllegalArgumentException("Name must have value");
        } else if (text == null) {
            throw new IllegalArgumentException("Text must have value");
        }
        Date date = new Date(System.currentTimeMillis());
        tweetContainer.add(new Tweet(date, name, text));
    }

    private List<Tweet> getTweets(List<Tweet> tweets, int startIndex, int endIndex, String poster, Date fromVal) {
        List<Tweet> filtered = new ArrayList<>();

        for (int i = startIndex; i < endIndex; i++) {
            Tweet tweet = tweets.get(i);
            if (isTweetPassable(tweet, poster, fromVal)) {
                filtered.add(tweet);
            }
        }
        return filtered;
    }

    private boolean isTweetPassable(Tweet tweet, String poster, Date from) {
        if (poster != null && !poster.equals(tweet.getName())) {
            return false;
        } else if (from != null && from.after(tweet.getDate())) {
            return false;
        }
        return true;
    }

    private Date parseDate(String fromDate, String fromTime) throws ParseException {
        if (fromDate == null) {

            return null;
        }
        if (fromTime == null | fromTime.equals("")) {
            fromTime = "T00:00";
        } else {
            fromTime = "T" + fromTime;
        }

        return dateFormat.parse(fromDate + fromTime);

    }

    private int getInt(String offset) {
        if (offset == null) {
            return 0;
        }
        if (offset.equals("")) {
            return 0;
        } else {
            return Integer.parseInt(offset);
        }
    }

    private String convertStr(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("")) {
            return null;
        } else {
            return str;
        }
    }
}
