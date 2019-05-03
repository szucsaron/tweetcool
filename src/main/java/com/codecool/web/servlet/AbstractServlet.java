package com.codecool.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AbstractServlet extends HttpServlet {

    protected void handleError(HttpServletRequest req, HttpServletResponse resp, Exception e)  throws ServletException, IOException {
        String msg = e.getLocalizedMessage();
        req.setAttribute("error_msg", msg);
        req.getRequestDispatcher("error.jsp").forward(req, resp);
    }
}
