<%@ page import="java.util.Base64" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Profile</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<jsp:include page="../header/header.jsp"></jsp:include>
<c:if test="${sessionScope.author == null}">
    <div class="container col-md-3 col-md-offset-3" style="overflow: auto">
        <h2>Log In To View This Page</h2>
    </div>
</c:if>
<c:if test="${sessionScope.author != null}">
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <c:if test="${sessionScope.author != null}">
                <form action="<%=request.getContextPath()%>/edit_profile" method="post" enctype="multipart/form-data">
                    </c:if>
                        <c:if test="${sessionScope.author != null}">
                            <%--                            <%--%>
                            <%--                                byte[] photoData = (byte[]) request.getAttribute("dataAvatar");--%>
                            <%--                            %>--%>
                            <img src="data:image/jpeg;base64,${dataAvatar}" alt="User Avatar">
                            <%--                            <input type="hidden" name="id" value="<c:out value='${author.userName}' />"/>--%>
                        </c:if>
                            <%--                            <fieldset class="form-group">
                                                            <label>Username</label> <input type="text"
                                                        </fieldset>--%>
                        <fieldset class="form-group">
                            <label>Username</label> <input type="text"
                                                        value="<c:out value='${author.userName}' />" class="form-control"
                                                        name="username" required="required" minlength="2">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Email</label> <input type="text"
                                                        value="<c:out value='${author.email}' />" class="form-control"
                                                        name="email" required="required" minlength="2">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Password</label> <input type="password"
                                                        class="form-control"
                                                        name="password" required="required" minlength="2">
                        </fieldset>

                        <div class="mb-3">
                            <label for="formFile" class="form-label">Choose a profile photo:</label>
                            <input class="form-control" type="file" id="formFile" name="avatar">
                        </div>

                        <fieldset class="form-group">
                            <label>Bio</label> <input type="text"
                                                                    value="<c:out value='${author.bio}' />"
                                                                    class="form-control"
                                                                    name="bio" minlength="2">
                        </fieldset>
                        <button type="submit" class="btn btn-success">Save</button>
                    </form>
            </div>
        </div>
    </div>
</c:if>
<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
</html>
