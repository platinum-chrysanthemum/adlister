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

</body>
</html>
