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

<table>
    <tr>
        <td><a href="/">Main page</a></td>
        <td>
            <c:if test="${not empty sessionScope}">
                <p><a href="/message/show/${sessionScope.user_id}">Messages</a></p>
            </c:if>
        </td>
        <td>
            <c:if test="${not empty sessionScope}">
                <p><a href="/userprofile/${sessionScope.user_id}">User profile</a></p>
            </c:if>
        </td>
        <td>
            <c:if test="${not empty sessionScope}">
                <p><a href="/logout">Logout</a></p>
            </c:if>
        </td>
    </tr>
</table>

</body>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


</html>
