package com.codecool.web.service;

import com.codecool.web.model.Tweet;
import com.codecool.web.model.TweetContainer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TweetService {
    private static int DEFAULT_LIMIT = 20;
    private TweetContainer tweetContainer;


    public TweetService(TweetContainer tweetContainer) {
        this.tweetContainer = tweetContainer;
    }

    public List<Tweet> getFilteredTweets(String limit, String offset, String poster, String from) {
        try {
            poster = convertStr(poster);
            from = convertStr(from);
            List<Tweet> tweets = tweetContainer.getTweets();
            Date fromVal = parseDate(from);
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

    public List<Tweet> getPosterTweets(String poster) {
        return getFilteredTweets(null, null, poster, null);
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

    private Date parseDate(String from) throws ParseException {
        if (from == null) {
            return null;
        }
        if (from.equals("")) {
            return null;
        } else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
            return df.parse(from);
        }
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
