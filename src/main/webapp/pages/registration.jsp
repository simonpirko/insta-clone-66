<%--
  Created by IntelliJ IDEA.
  User: Notebook
  Date: 30.08.2023
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registration" method="post">
    <input type="text" name="userName" placeholder="userName">
    <input type="text" name="email" placeholder="email">
    <input type="password" name="password" placeholder="Password">
    <button>Submit</button>
</form>
<p>${message}</p>
</body>
</html>
