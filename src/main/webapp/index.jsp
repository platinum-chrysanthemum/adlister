<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Greetings from the Adlister!"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <h1>Welcome to the Adlister!</h1>

    <c:forEach var="ad" items="{ads}">
        <form class="bg-info" style="border: 1px aquamarine" action="ads/view">
            <h2><c:out value="{ad.title}"/></h2>
            <h2><c:out value="{ad.description}"/></h2>

<%--            <input type="hidden" name="id" value="${ad.id}">--%>
            <input class="btn btn-md btn-info" type="submit" value="Display Ad">
        </form>
    </c:forEach>
</div>
</body>
</html>
