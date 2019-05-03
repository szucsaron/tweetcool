package com.codecool.web.servlet;



import com.codecool.web.model.Tweet;
import com.codecool.web.model.TweetContainer;
import com.codecool.web.service.TweetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/new-tweet")
public class NewTweetServlet extends AbstractServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            TweetContainer tw = TweetContainer.getInstance();
            TweetService tweetService = new TweetService(TweetContainer.getInstance());

            List<Tweet> tweets = tweetService.getAllTweets();

            req.setAttribute("tweets", tweets);

            req.getRequestDispatcher("new-tweet.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            TweetContainer tw = TweetContainer.getInstance();
            TweetService tweetService = new TweetService(TweetContainer.getInstance());

            String name = req.getParameter("poster");
            String text = req.getParameter("textcontent");

            tweetService.addTweet(name, text);

            doGet(req, resp);
        } catch (Exception e) {
            handleError(req, resp, e);
        }

    }
}
