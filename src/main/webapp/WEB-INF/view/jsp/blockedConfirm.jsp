<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<head>
    <title>Block Card</title>
</head>

<p><h2>Confirm blocking!</h2></p>
<p>The card number <strong>${card.cardNumber}</strong> and account number <strong>${card.cardAccount.accountNumber}</strong> will be blocked. <br>Attention! To unlock, you will need to leave a request to the administrator.</p>
    <form action="<c:url value="/blockedSuccess"/>"><input type="submit" value="Blocked" />
    <input type="hidden" name="cardNumber" value="${card.cardNumber}">
    </form>

<form action="<c:url value="/blockedChooseCard"/>"><input type="submit" value="Back" /></form>
</body>
</html>