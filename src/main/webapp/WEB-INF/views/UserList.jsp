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
    <c:forEach items="${users}" var="user">
        <li>
        <h2>${user.id}. ${user.firstName} ${user.lastName}; Email: ${user.email}</h2>
        <p><a href="/user/edit/${user.id}">Edit user  </a><a href="/user/delete/${user.id}">Delete user</a></p>
        <p><a href="/user/${user.id}/tweets">User tweets  </a><a href="/user/delete/${user.id}">Delete user</a></p>
        </li>
    </c:forEach>
</ul>

</body>
</html>
