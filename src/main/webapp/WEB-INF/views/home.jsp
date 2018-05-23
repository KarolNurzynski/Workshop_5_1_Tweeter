<%--
  Created by IntelliJ IDEA.
  User: karnur
  Date: 11.05.18
  Time: 09:51
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

<p><a href="/logout">Logout</a></p>
<h1>Twitter home page </h1>

<form:form modelAttribute="tweet" method="post" cssClass="jumbotron">

    <form:textarea rows="7" cols="50" path="text" placeHolder="text" cssClass="form-conrol"/>text<br>
    <form:errors path="text"/><br>

    <input type="submit" value="Submit" class="btn btn-success"/>

</form:form>

<h2>All tweets: </h2>

<ul>
    <c:forEach items="${tweets}" var="element">
        <li>
            <h2>${element.text}</h2>
            <p>Tweet no: ${element.id}. Created: ${element.created}</p>
            <ul>
                <h3>Comments: </h3>
                <p><a href="/comment/add/${element.id}">Add comment</a></p>

                <c:forEach items="${element.comments}" varStatus="status">
                    <li>
                        <p>
                            @(${element.comments[fn:length(element.comments)-status.count].user.username}):
                                ${element.comments[fn:length(element.comments)-status.count].text}
                        </p>

                    </li>
                </c:forEach>
            </ul>
        </li>
    </c:forEach>
</ul>

</body>
</html>
