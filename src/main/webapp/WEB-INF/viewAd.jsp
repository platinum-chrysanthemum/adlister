<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: yishhenderson
  Date: 9/14/21
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Single Ad View</title>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Single Ad View"/>
    </jsp:include>
</head>

<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<form class="container bg-info">
    <div class="col-md-12">
        <h1><c:out value="${ad.title}"/></h1>
        <p><c:out value="${ad.description}"/></p>
    </div>
</form>
</body>
</html>
