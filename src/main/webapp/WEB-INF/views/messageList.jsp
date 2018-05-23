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

<h2>List of sent messages: </h2>



<ul>
    <c:forEach items="${sentMessages}" var="message">
        <li>
            <p>
                Message id: ${message.id}. Created: ${tweet.created}
            </p>
            <p>
                Sent to: @${message.receiver.username}
            </p>

            <p><em><a href="/message/showMessage/${message.id}">
                    ${fn:substring(message.text, 0, 30)}
                <c:if test="${not empty fn:substring(message.text, 30,31)}">...</c:if>
            </em></p></a>

        </li>
    </c:forEach>
</ul>

<h2>List of received messages: </h2>

<ul>
    <c:forEach items="${receivedMessages}" var="message">
        <li>
            <p>
                Message id: ${message.id}. Created: ${tweet.created}
            </p>
            <p>
                Sent by: @${message.sender.username}.
                Received by: @${message.receiver.username}
            </p>
            <c:if test="${message.readStatus==0}">
                <h2><em><a href="/message/showMessage/${message.id}">
                        ${fn:substring(message.text, 0, 30)}
                    <c:if test="${not empty fn:substring(message.text, 30,31)}">...</c:if>
                </em></h2></a>
            </c:if>
            <c:if test="${message.readStatus==1}">
                <p><em><a href="/message/showMessage/${message.id}">
                        ${fn:substring(message.text, 0, 30)}
                    <c:if test="${not empty fn:substring(message.text, 30,31)}">...</c:if>
                </em></p></a>
            </c:if>
        </li>
    </c:forEach>
</ul>

</body>
</html>
