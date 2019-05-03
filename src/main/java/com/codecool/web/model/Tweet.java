package com.codecool.web.model;

import java.util.Date;

public class Tweet {
    private Date date;
    private String name;
    private String text;

    public Tweet(Date date, String poster, String text) {
        this.date = date;
        this.name = poster;
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
