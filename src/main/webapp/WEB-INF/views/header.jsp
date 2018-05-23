<%--
  Created by IntelliJ IDEA.
  User: karnur
  Date: 10.05.18
  Time: 04:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p><a href="/">Main page</a></p>

<c:if test="${not empty sessionScope}">
    <p><a href="/logout">Logout</a></p>
    <p><a href="/userprofile/${sessionScope.user_id}">User profile</a></p>
</c:if>


</body>
</html>
