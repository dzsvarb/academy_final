<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Select card</title>
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
            <div class="bg-light border">${principal.username} , select the card for transaction</div>
        </div>
            </div>
            <div class="p-2">
                <table class="table">
            <thead>
            <tr>
                <th scope="col">Your cards number</th>
                <th scope="col">Card payment system</th>
                <th scope="col">Your accounts number</th>
                <th scope="col">Status account</th>
                <th scope="col">Request for activate account</th>
                <th scope="col">Balance</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${cards}" var="card">
                <c:if test="${card.cardAccount.accountStatus.statusName == 'ACTIVE'}">
                    <tr>
                        <td> ${card.cardNumber}</td>
                        <td> ${card.cardPaySystem}</td>
                        <td> ${card.cardAccount.accountNumber}</td>
                        <td> ${card.cardAccount.accountStatus.statusName}</td>
                        <td>
                            <c:if test="${card.cardAccount.accountStatusRequest.statusRequestName == 'FALSE'}"> </c:if>
                            <c:if test="${card.cardAccount.accountStatusRequest.statusRequestName == 'TRUE'}">
                                Request has been sent. Wait.
                            </c:if></td>
                        <td> ${card.cardAccount.accountBalance}</td>
                        <td><form action="<c:url value="/main/transfer"/>">
                            <button type="submit" class="btn btn-outline-danger">Select</button>
                            <input type="hidden" name="cardNumber" value="${card.cardNumber}">
                        </form>
                        </td>
                    </tr>
                </c:if>
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


