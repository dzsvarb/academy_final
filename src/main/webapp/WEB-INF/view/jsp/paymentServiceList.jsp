<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Personal bank manager</title>
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
            <div class="bg-light border">Services</div>
            <div class="bg-light border">${principal.username} , choose a Service for payment</div>
                    <c:if test="${error!=null}">
                        <div class="bg-danger p-2" style="--bs-bg-opacity: .5;">${error}</div>
                    </c:if>
        </div>
            </div>
            <div class="p-2">
                <table class="table">
            <thead>
            <tr>
                <th scope="col">Service number</th>
                <th scope="col">Service description</th>
                <th scope="col">Service Price</th>
                <th scope="col">Organisation</th>

                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${allServices}" var="service">
                <tr>
                    <td> ${service.serviceNumber}</td>
                    <td> ${service.serviceDescription}</td>
                    <td> ${service.servicePrice}</td>
                    <td> ${service.organisation.organisationName}</td>
                    <td><form action="<c:url value="/main/paymentChooseCard"/>">
                        <button type="submit" class="btn btn-outline-danger">Select</button>
                        <input type="hidden" name="serviceNumber" value="${service.serviceNumber}">
                    </form></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
            </div>
            <div class="p-2">
                <form><button type="submit" class="btn btn-primary" formaction="<c:url value="/main"/>">Back</button></form>
            </div>
        </div>
    </body>
</html>