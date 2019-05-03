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

@WebServlet("/index")
public class IndexServlet extends AbstractServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
        String limit = req.getParameter("limit");
        String offset = req.getParameter("offset");
        String poster = req.getParameter("poster");
        String date = req.getParameter("from_date");
        String time = req.getParameter("from_time");

        TweetContainer tw = TweetContainer.getInstance();
        TweetService tweetService = new TweetService(TweetContainer.getInstance());


        List<Tweet> tweets = tweetService.getFilteredTweets(limit, offset, poster, date, time);

        req.setAttribute("tweets", tweets);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    } catch (Exception e) {
        handleError(req, resp, e);
    }

    }
}
