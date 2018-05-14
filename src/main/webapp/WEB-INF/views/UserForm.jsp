<%--
  Created by IntelliJ IDEA.
  User: karnur
  Date: 08.05.18
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>



<form:form modelAttribute="user" method="post" cssClass="jumbotron">

    <form:input path="firstName" placeHolder="First Name" cssClass="form-conrol"/>First Name<br>
    <form:errors path="firstName"/><br>

    <form:input path="lastName" placeHolder="Last Name" cssClass="form-conrol"/>Last Name<br>
    <form:errors path="lastName"/><br>

    <form:input path="email" placeHolder="Email" cssClass="form-conrol"/>Email<br>
    <form:errors path="email"/><br>

    <input type="submit" value="Submit" class="btn btn-success"/>

</form:form>

</body>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


</html>