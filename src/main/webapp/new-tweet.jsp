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

<form id="new_tweet" method="POST" action="new-tweet">
    <h2>New Tweet</h2>
    Name: <input type="text" name="poster"/><br>
    Text: <textarea form="new_tweet" name="textcontent" rows="5" cols="50"></textarea><br>

    <input type="submit" value="Send">
</form>

<div id="tweets">
    <c:forEach items="${tweets}" var="tweet">
        <p class="tweet">
            ${tweet.name}<br>
            ${tweet.date}<br>
            ${tweet.text}<br>
        </p>
    </c:forEach>
</div>
<a href="index">Back to main feed</a>
</body>

</html>
