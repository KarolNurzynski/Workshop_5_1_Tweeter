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

<h1>Tweet info:</h1>
<p>Tweet no: ${tweet.id}. Created on: ${tweet.created}</p>
<p>Added by user: ${tweet.user.email}</p>
<h2><em>${tweet.text}</em></h2>

<h1>Add new comment:</h1>
<form:form modelAttribute="comment" method="post" cssClass="jumbotron">

    <form:textarea rows="4" cols="50" path="text" placeHolder="text" cssClass="form-conrol"/>text<br>
    <form:errors path="text"/><br>

    <input type="submit" value="Submit" class="btn btn-success"/>

</form:form>

<h1>All comments: </h1>
<ul>
    <c:forEach items="${tweet.comments}" var="comment" varStatus="status">
        <li>
            <p>
                <a href="/user/show/${tweet.comments[fn:length(tweet.comments)-status.count].user.id}">
                    @${tweet.comments[fn:length(tweet.comments)-status.count].user.username}:
                </a>
                    ${tweet.comments[fn:length(tweet.comments)-status.count].text}
            </p>

        </li>
    </c:forEach>
</ul>

</body>
</html>
