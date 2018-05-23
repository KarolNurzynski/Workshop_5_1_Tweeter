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
<jsp:include page="header.jsp"/>

<h1>User id: ${user.id}. Username: @${user.username}</h1>

<h2>Edit user data: </h2>
<form:form modelAttribute="user" method="post" cssClass="jumbotron">

    <form:input path="email" placeHolder="Email" cssClass="form-conrol"/>Change email<br>
    <form:errors path="email"/><br>

    <form:hidden path="id"/>
    <form:hidden path="username"/>
    <form:hidden path="password"/>
    <form:hidden path="enabled"/>

    <input type="submit" value="changeEmail" name="submit" class="btn btn-success"/>

</form:form>

<form:form modelAttribute="user" method="post" cssClass="jumbotron">

    <form:input path="password" type="password" cssClass="form-conrol"/>Change password<br>
    <form:errors path="password"/><br>

    <form:hidden path="id"/>
    <form:hidden path="username"/>
    <form:hidden path="email"/>
    <form:hidden path="enabled"/>

    <input type="submit" value="changePassword" name="submit" class="btn btn-success"/>

</form:form>

<p><a href="/user/delete/${user.id}">Delete user</a></p>

</body>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


</html>
