<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Дмитрий
  Date: 20.10.2021
  Time: 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hi!!!!!</title>
</head>
<body>
<h1>TEstttttt!!!!!!!</h1>
<p>
    <spring:form modelAttribute="userFromServer" method="post" action="/check">
        <spring:input path="id"/>
        <spring:button>Button</spring:button>
    </spring:form>
</p>
</body>
</html>
