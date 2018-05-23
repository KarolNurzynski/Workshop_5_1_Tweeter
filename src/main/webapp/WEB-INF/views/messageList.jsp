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

<h2>List of messages: </h2>

<ul>
    <c:forEach items="${messages}" var="message">
        <li>
            <p>
                Message id: ${message.id}. Created: ${tweet.created}
            </p>
            <p>
                Sent by: @${message.sender.username}.
                Received by: @${message.receiver.username}
            </p>
            <h3>${message.text}</h3>
        </li>
    </c:forEach>
</ul>

</body>
</html>
