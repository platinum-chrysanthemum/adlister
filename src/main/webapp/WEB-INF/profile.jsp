<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/userNav.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>

        <h3>My Ads</h3>
            <div class="col-md-12">
                <h1><c:out value="${ad.title}"/></h1>
                <p><c:out value="${ad.description}"/></p>
            </div>
    </div>
<%--<div class="block-list">--%>
<%--    <c:forEach var="ad" items="${sessionScope.user.id}">--%>
<%--        <div class="card">--%>
<%--            <h2>${ad.title}</h2>--%>
<%--            <p>--%>
<%--                ${ad.description}--%>
<%--            </p>--%>
<%--            <c:forEach var="category" items="${ad.categories}">--%>
<%--                <span class="pill">${category}</span>--%>
<%--            </c:forEach>--%>
<%--            <a href="/">View more</a>--%>
<%--            <a href="/WEB-INF/ads/edit-ads.jsp"--%>
<%--    </c:forEach>--%>
</div>
</body>
</html>
