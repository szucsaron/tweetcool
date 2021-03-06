<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codecool.web.model.Tweet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html class="bg-1" lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tweetcool</title>

</head>


<body>
<p id="tweets">
    <h2>Tweets</h2>
    <c:forEach items="${tweets}" var="tweet">
        <p class="tweet">
            ${tweet.name}<br>
            ${tweet.date}<br>
            ${tweet.text}<br>
        </p>
    </c:forEach>
</p>
<p>
    <h2>Filter</h2>
    <form name="filter" method="GET" action="index">
        Limit: <input type="text" name="limit"/><br>
        Offset: <input type="text" name="offset"/><br>
        Poster: <input type="text" name="poster"/><br>
        After<br>
        Date (yyyy-mm-dd): <input type="text" name="from_date"/><br>
        Time (hh:mm): <input type="text" name="from_time"/><br>
        <input type="submit" value="Filter tweets">
    </form>
</p>
<a href="new-tweet">Add Tweet</a>
</body>

</html>
