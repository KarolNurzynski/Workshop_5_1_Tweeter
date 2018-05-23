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
    <c:forEach items="${tweets}" var="tweet">
        <li>
            <h2>${tweet.text}</h2>
            <p>Tweet no: ${tweet.id}. Created: ${tweet.created}</p>
        </li>
    </c:forEach>
</ul>

</body>
</html>
