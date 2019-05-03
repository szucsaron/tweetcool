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
Tweets
<div id="tweets">
    <c:forEach items="${tweets}" var="tweet">
        <p class="tweet">
            ${tweet.name}<br>
            ${tweet.date}<br>
            ${tweet.text}<br>
        </p>
    </c:forEach>
</div>
<form name="new_tweet" method="GET" action="index">
    Limit: <input type="text" name="limit"/><br>
    Offset: <input type="text" name="offset"/><br>
    Poster: <input type="text" name="poster"/><br>
    Date from: <input type="text" name="from"/><br>
    <input type="submit">
</body>

</html>
