<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Transfer</title>
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
            <div class="bg-light border">Transfer</div>
            <div class="bg-light border">${principal.username}, select recipient card and amount</div>
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
            </tr>
            </thead>
            <tbody>
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
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>
    <div class="shadow-lg p-3 mb-5 "><div class="p-2 bo">
        <form action="<c:url value="/main/transferSuccess"/>">
            <fieldset>
                <legend>Fill out the transfer form</legend>
                <div class="mb-3">
                    <label class="form-label">Enter recipient card
                        <input type="number" name="recipientCardNumber" class="form-control" placeholder="Number recipient card" size="25" maxlength="15"  autofocus required>
                    </label>
                </div>
                <div class="mb-3">
                    <label class="form-label">Enter amount
                        <input type="number" name="amount" class="form-control" placeholder="Amount" size="25" maxlength="6" autofocus required >
                    </label>
                </div>
                <input type="hidden" name="senderCardNumber" value="${card.cardNumber}">
                <div class="hstack gap-2">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <button type="reset"  class="btn btn-outline-secondary">Reset</button>
                </div>
            </fieldset>
        </form>
    </div></div>


    <div class="p-2"><button type="button" class="btn btn-primary" name="back" onclick="history.back()">Back</button></div>
</div>





<%--<div class="d-flex p-2">
    <div class="vstack gap-1">
    <div class="bg-light border">Transfer</div>
    <div class="bg-light border">${principal.username}, select recipient card and amount</div>
    </div>
</div>--%>


<%--<table class="table">
    <thead>
    <tr>
        <th scope="col">Your cards number</th>
        <th scope="col">Card payment system</th>
        <th scope="col">Your accounts number</th>
        <th scope="col">Status account</th>
        <th scope="col">Request for activate account</th>
        <th scope="col">Balance</th>
    </tr>
    </thead>
    <tbody>
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
            </tr>
        </c:if>
    </tbody>
</table>--%>
<%--<div class="d-flex p-2 bo">
<form action="<c:url value="/main/transferSuccess"/>">
    <fieldset>
        <legend>Fill out the transfer form</legend>
            <div class="mb-3">
                <label class="form-label">Enter recipient card
                <input type="number" name="recipientCardNumber" class="form-control" placeholder="Number recipient card" size="25" maxlength="15"  autofocus required>
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">Enter amount
                <input type="number" name="amount" class="form-control" placeholder="Amount" size="25" maxlength="6" autofocus required >
                </label>
            </div>
        <input type="hidden" name="senderCardNumber" value="${card.cardNumber}">
        <div class="hstack gap-2">
            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="reset"  class="btn btn-outline-secondary">Reset</button>
        </div>
    </fieldset>
</form>
</div>--%>


<%--<button type="button" class="btn btn-primary" name="back" onclick="history.back()">Back</button>--%>
</body>
</html>