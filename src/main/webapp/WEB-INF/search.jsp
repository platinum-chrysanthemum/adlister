<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="partials/head.jsp">
    <jsp:param name="search" value="Register For Our Site!" />
</jsp:include>
<body>
<jsp:include page="partials/navbar.jsp" />
<div class="container">
<h1>Search An Ad Here</h1>

<c:forEach var="ad" items="${ads}">
    <div class="col-md-6">
        <h2>${ad.title}</h2>
        <p>${ad.description}</p>
    </div>
</c:forEach>
</div>
</body>
</html>
