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


<h3>Message no: ${message.id}</h3>
<p>Message text: </p>
<p>${message.text}</p>
<p>Created on: ${message.created}</p>
<p>Sent by: @${message.sender.username}</p>
<p>Received by: @${message.receiver.username}</p>

</body>
</html>
