<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Choose a card</title>

</head>
<body>
<div>
    <h2 style="text-align:center">${username}, Choose a card for Block </h2>
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
            <a href="/main/blockedConfirm?cardNumber=${card.cardNumber}"  />
            ${card.cardNumber} - ${card.cardPaySystem}
            </a><br>
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


<button type="button" name="back" onclick="history.back()">Back</button>
</body>
</html>