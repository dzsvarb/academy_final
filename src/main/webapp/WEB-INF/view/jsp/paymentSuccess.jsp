<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Done</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<nav class="navbar" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <a class="navbar-brand">Personal Bank Manager</a>
        <span class="navbar-text">
    <sec:authentication var="principal" property="principal" />
    <c:if test="${principal.roles == '[ROLE_ADMIN]'}">
        Administrator
    </c:if>
    <c:if test="${principal.roles == '[ROLE_CUSTOMER]'}">
        User
    </c:if>
                 |  ${principal.username}
        </span>
        <form class="d-flex" action="<c:url value="/logout"/>">
            <button class="btn btn-outline-success" type="submit">Log out</button>
        </form>
    </div>
</nav>
<div class="vstack gap-1">
    <div class="bg-light border">Information</div>
    <div class="bg-success p-2" style="--bs-bg-opacity: .5;">Success!<br> Service <strong>${serviceDescription}</strong> paid successfully</div>
</div>

<form action="<c:url value="/main"/>"><button type="submit" class="btn btn-primary">Next</button></form>

</body>
</html>

