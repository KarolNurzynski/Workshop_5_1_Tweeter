<%--
  Created by IntelliJ IDEA.
  User: karnur
  Date: 11.05.18
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>User id: ${user.id}. Username: @${user.username}</h1>
<h2>List of tweets: </h2>

    <%--Here I had problems with accessing tweets and comments from global user @ModelAttribute parameter--%>
    <%--I solved this by passing a list of tweets(by user id) separately to the model--%>

<ul>
    <c:forEach items="${tweets}" var = "tweet">
        <li>
            <h3>Tweet id: ${tweet.id}. Created on: ${tweet.created}</h3>
            <p><em>${tweet.text}</em></p>
            <p>Comments: ${fn:length(tweet.comments)}</p>
        </li>
    </c:forEach>
</ul>

<c:if test="${sessionScope.user_id!=user.id}">
    <a href="/message/add/${sessionScope.user_id}/${user.id}">Send message to this user</a>
</c:if>

</body>
</html>
