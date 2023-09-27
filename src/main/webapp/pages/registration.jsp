<%--
  Created by IntelliJ IDEA.
  User: Notebook
  Date: 30.08.2023
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Register Form</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<%--<jsp:include page="../../header/header.jsp"></jsp:include>--%>
<%--<c:if test="${sessionScope.author != null}">--%>

<%--</c:if>--%>
<div class="container col-md-3 col-md-offset-3" style="overflow: auto">
    <h2>User Register Form</h2>
    <div class="alert alert-success center" role="alert">
        <p>${message}</p>
        <p>${existsEmail}</p>
    </div>
    <form action="<%=request.getContextPath()%>/registration" method="post">

        <div class="form-group">
            <label for="userName">User Name:</label> <label for="userName"></label><input type="text"
                                                                                          class="form-control" id="userName" placeholder="User Name"
                                                                                          name="userName" required>
        </div>

        <div class="form-group">
            <label for="email">Email:</label> <input type="email"
                                                     class="form-control" id="email" placeholder="Email"
                                                     name="email" required>
        </div>

        <div class="form-group">
            <label for="password">Password:</label> <input type="password"
                                                           class="form-control" id="password" placeholder="Password"
                                                           name="password" required>
        </div>

<%--        <div class="mb-3">--%>
<%--            <label for="formFile" class="form-label">Choose a profile photo:</label>--%>
<%--            <input class="form-control" type="file" id="formFile" name="avatar">--%>
<%--        </div>--%>

<%--        <div class="form-group">--%>
<%--            <label for="bio">Bio:</label> <input type="text"--%>
<%--                                                 class="form-control" id="bio" placeholder="Bio"--%>
<%--                                                 name="bio" required>--%>
<%--        </div>--%>

        <button type="submit" class="btn btn-primary">Register</button>

    </form>
</div>

<%--<jsp:include page="../../footer/footer.jsp"></jsp:include>--%>
</body>
</html>
