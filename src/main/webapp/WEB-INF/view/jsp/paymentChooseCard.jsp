<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Choose a card</title>
</head>
<body>
<div>
    <h2 style="text-align:center">${username}, Choose a card for Payment </h2>
</div>

<hr />
<p>Cards</p>
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
            <a href="/paymentConfirm?cardNumber=${card.cardNumber}&serviceNumber=${serviceNumber}"  />
            ${card.cardNumber} - ${card.cardPaySystem}</a><br>
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


<form action="<c:url value="/paymentServiceList"/>"><input type="submit" value="Back" /></form>
</body>
</html>