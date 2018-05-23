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


<h3>Tweet no: ${tweet.id}</h3>
<p>Tweet text: </p>
<p>${tweet.text}</p>
<p>Created on: ${tweet.created}</p>
<p>Added by user: ${tweet.user.email}</p>

</body>
</html>
