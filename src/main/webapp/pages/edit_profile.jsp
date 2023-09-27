<%--
  Created by IntelliJ IDEA.
  User: simonpirko
  Date: 18.09.23
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>
<form name="/edit_profile" method="post">
    <label>Username<input name="username" type="text"></label><br>
    <label>Password<input name="password" type="password"></label><br>
    <label>Email address<input name="email" type="email"></label><br>
    <label>Profile photo<input name="avatar" type="text"></label><br>
    <label>Bio<input name="bio" type="text"></label><br>
</form>
</body>
</html>
