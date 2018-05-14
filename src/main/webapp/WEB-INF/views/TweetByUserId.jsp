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

<html>
<head>
    <title>Title</title>
</head>
<body>

<ul>
    <c:forEach items="${tweets}" var="tweet">
        <li>
            <h2>${tweet.id}. ${tweet.title}</h2>
            <p>Text: ${tweet.tweetText}</p>
            <p>Created: ${tweet.created}</p>
            <p>User id: ${tweet.user.id}</p>
        </li>
    </c:forEach>
</ul>

</body>
</html>
