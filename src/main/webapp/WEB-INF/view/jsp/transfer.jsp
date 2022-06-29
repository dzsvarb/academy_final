<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Transfer page</title>
</head>
<body>
<div>
    <h2 style="text-align:center">Card number: ${card.cardNumber}</h2>
    <h2 style="text-align:center">Account number: ${card.cardAccount.accountNumber}</h2>
    <h3 style="text-align: center">Balance: ${card.cardAccount.accountBalance}</h3>
</div>

<hr />
<p>Transfer</p>

<hr />

<form action="<c:url value="/main/transferSuccess"/>">
    <p>Enter recipient card <br>
        <label>
            <input type="number" name="recipientCardNumber" size="25" maxlength="15"  autofocus required/>
        </label><br>
    <p>
    <p>Enter amount <br>
        <label>
            <input type="number" name="amount" size="25" maxlength="6" autofocus required />
        </label><br>
    <p>
     <input type="hidden" name="senderCardNumber" value="${card.cardNumber}">
     <input type="submit" name="submit" value="Submit" />
    </p>
</form>
<button type="button" name="back" onclick="history.back()">Back</button>
</body>
</html>