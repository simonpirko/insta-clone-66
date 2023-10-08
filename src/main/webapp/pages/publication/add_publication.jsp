<%@ page import="java.util.Base64" %>
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
<jsp:include page="../../header/_header.jsp"></jsp:include>

<div class="container col-md-3 col-md-offset-3" style="overflow: auto">
    <h2>Add Publication Form ${author.username}</h2>
    <style>
        img {
            border: 1px solid #ddd;
            border-radius: 4px;
            padding: 5px;
            width: 350px;
            display: block;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
    <%--<img src="data:image/jpeg;base64,${dataAvatar}" alt="User Avatar">--%>
    <img src="data:image/jpeg;base64,${author.avatar}" alt="User Avatar">

    <form action="${pageContext.request.contextPath}/add_publication" method="post" enctype="multipart/form-data">

        <div class="mb-3">
            <label for="formFile" class="form-label">Choose a photo to publish:</label>
            <input class="form-control" type="file" id="formFile" name="content">
        </div>
        <div class="form-group">
            <label for="description">Description:</label> <input type="text"
                                                                 class="form-control" id="description"
                                                                 placeholder="Description"
                                                                 name="description" required>
        </div>
        <button type="submit" class="btn btn-primary">Publish a publication</button>

    </form>
</div>
<jsp:include page="../../footer/_footer.jsp"></jsp:include>
</body>
</html>
