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
<div class="vstack gap-3">
    <div class="bg-light border">Information</div>
</div>

<table style="width:1000px">
    <tbody>
    <tr>
        <td>Your cards number</td>
        <td>Your accounts number</td>
        <td>Status account</td>
        <td>Balance</td>
    </tr>
    <tr>
        <td><c:forEach items="${cards}" var="card">
            ${card.cardNumber} - ${card.cardPaySystem}<br>
        </c:forEach>
        </td>
        <td><c:forEach items="${cards}" var="card">
            ${card.cardAccount.accountNumber}<br>
        </c:forEach></td>
        <td><c:forEach items="${cards}" var="card">
            ${card.cardAccount.accountStatus.statusName}<br>
        </c:forEach>
        </td>
        <td><c:forEach items="${cards}" var="card">
            ${card.cardAccount.accountBalance}<br>
        </c:forEach> </td>
    </tr>
    </tbody>
</table>

<div class="vstack gap-3">
    <div class="bg-light border">   Actions</div>
</div>

<div class="btn-group" role="group" aria-label="Basic example">
    <form>
        <div class="hstack gap-3">
        <button type="submit" class="btn btn-primary"  formaction="<c:url value="/main/transferChooseCard"/>">Transfer</button>
        <button type="submit" class="btn btn-primary"  formaction="<c:url value="/main/paymentServiceList"/>">Payment</button>
        <button type="submit" class="btn btn-primary"  formaction="<c:url value="/main/blockedChooseCard"/>">Block card and account</button>
        <button type="submit" class="btn btn-primary"  formaction="<c:url value="/main/activationCardList"/>">Account activation request</button>
        </div>
    </form>
</div>
<%--
<p>

<form action="<c:url value="/main/transferChooseCard"/>">
    <input type="submit" value="Transfer">
</form>

<form action="<c:url value="/main/paymentServiceList"/>">
    <input type="submit" value="Payment" />
</form>

        &lt;%&ndash;<form action="<c:url value="/lastTransaction"/>"><input type="submit" value="Last Transactions" /></form>&ndash;%&gt;

<form action="<c:url value="/main/blockedChooseCard"/>">
    <input type="submit" value="Block card and account" />
</form>

<form action="<c:url value="/main/activationCardList"/>">
    <input name="Account activation request" type="submit" value="Account activation request" />
</form>
</p>
--%>
</body>
</html>