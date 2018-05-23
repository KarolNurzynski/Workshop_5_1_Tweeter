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
<jsp:include page="header.jsp"/>

<ul>
    <c:forEach items="${users}" var="user">
        <li>
        <h2>${user.id}. ${user.email}</h2>
            <ul>
                <c:forEach items="${user.tweets}" var = "tweet">
                    <li>
                        <p>${tweet.id}. ${tweet.text}</p>
                    </li>
                </c:forEach>
            </ul>
        </li>
    </c:forEach>
</ul>

</body>
</html>
