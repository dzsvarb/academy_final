
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Personal bank manager</title>
</head>
<body>
<div>
    <h2 style="text-align:center">Welcome dear, ${username} </h2>
</div>

<hr />
<p>Information</p>
<hr />

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

<hr />
<p>Actions</p>
<hr />
<p>

<form action="<c:url value="/transferChooseCard"/>">
    <input type="hidden" name="username" value="${username}">
    <input type="submit" value="Transfer">
</form>

<form action="<c:url value="/paymentServiceList"/>">
    <input type="hidden" name="username" value="${username}">
    <input type="submit" value="Payment" />
</form>
        <%--<form action="<c:url value="/lastTransaction"/>"><input type="submit" value="Last Transactions" /></form>--%>

<form action="<c:url value="/blockedChooseCard"/>">
    <input type="hidden" name="username" value="${username}">
    <input type="submit" value="Block card and account" />
</form>
<form action="<c:url value="/activationCardList"/>">
    <input name="Account activation request" type="submit" value="Account activation request" />
    <input type="hidden" name="username" value="${username}">
</form>
</p>
</body>
</html>