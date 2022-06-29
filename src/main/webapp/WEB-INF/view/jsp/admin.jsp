
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <title>Personal Bank Manager</title>

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
                <div class="vstack gap-3">
                    <div class="bg-light border">User information</div>
                </div>
            </div>
            <div class="p-2">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Username</th>
                        <th scope="col">Role</th>
                        <th scope="col">Cards</th>
                        <th scope="col">Account</th>
                        <th scope="col">Account status</th>
                        <th scope="col">Request activate status</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cards}" var="card">
                        <tr>
                            <td> ${card.user.id}</td>
                            <td> ${card.user.username}</td>
                            <td>
                                <c:if test="${card.user.roles == '[ROLE_ADMIN]'}">
                                    Administrator
                                </c:if>
                                <c:if test="${card.user.roles == '[ROLE_CUSTOMER]'}">
                                    Customer
                                </c:if></td>
                            <td> ${card.cardNumber}</td>
                            <td> ${card.cardAccount.accountNumber}</td>
                            <td> ${card.cardAccount.accountStatus.statusName}</td>
                            <td> ${card.cardAccount.accountStatusRequest.statusRequestName}</td>
                            <td><form action="<c:url value="/admin/edit"/>">
                                <button type="submit" class="btn btn-outline-danger">Edit</button>
                                <input type="hidden" name="cardNumber" value="${card.cardNumber}">
                                </form></td>
                        </tr>
                    </c:forEach>
                    </tbody>

                    <button type="button" class="btn btn-primary position-relative">
                        Mails <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-secondary">+99 <span class="visually-hidden">unread messages</span></span>
                    </button>
    </table>
            </div>
        </div>
    </body>
</html>

