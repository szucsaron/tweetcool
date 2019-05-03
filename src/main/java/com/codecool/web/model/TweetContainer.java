package com.codecool.web.model;

import java.util.List;

public class TweetContainer {
    private static TweetContainer tweetContainer = new TweetContainer();
    private List<Tweet> tweets;


    public static TweetContainer getInstance() {
        return tweetContainer;
    }

    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    public List<Tweet> getTweets() {
        return tweets;
    }
}
