<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
  <nav class="navbar navbar-expand-md navbar-dark"
       style="background-color: red">
    <div>
      <a href="https://teachmeskills.by" class="navbar-brand"> < TeachMeSkills /> </a>
    </div>

    <ul class="navbar-nav navbar-collapse justify-content-end">

      <c:if test="${sessionScope.author != null}">
        <li><a href="<%= request.getContextPath() %>/stories" class="nav-link">Stories</a></li>
      </c:if>

      <li><a href="<%= request.getContextPath() %>/register" class="nav-link">Signup</a></li>

      <c:if test="${sessionScope.author != null}">
        <li><a href="<%= request.getContextPath() %>/logout" class="nav-link">LogOut</a></li>
      </c:if>

    </ul>
  </nav>
</header>
