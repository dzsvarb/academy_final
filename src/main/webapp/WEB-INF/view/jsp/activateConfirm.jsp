<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Activate</title>
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
        <div class="d-flex flex-column mb-3">
            <div class="p-2">
                <div class="vstack gap-1">
                    <div class="bg-light border">Information</div>
                    <div class="bg-success p-2" style="--bs-bg-opacity: .5;">Account activated!<br>${card.cardNumber} and ${card.cardAccount.accountNumber}, successfully activate.<br></div>
                </div>
            </div>
            <div class="p-2">
                <form><button type="submit" class="btn btn-primary" formaction="<c:url value="/admin"/>">Back</button></form>
            </div>
        </div>
    </body>
</html>