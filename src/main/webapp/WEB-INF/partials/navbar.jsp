<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/WEB-INF/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/login">Login</a></li>
            <c:if test="${sessionScope.user != null}">
            <li><a href="/register">Logout</a></li>
            </c:if>
            <c:if test="${sessionScope.user == null}">
                <li><a href=/register">Register</a></li>
            </c:if>
            <c:if test="${sessionScope.user != null}">
                <li><a href="/ads/create">Create</a></li>
            </c:if>
                <li><a href="${pageContext.request.contextPath}/WEB-INF/ads">View Listings</a></li>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
