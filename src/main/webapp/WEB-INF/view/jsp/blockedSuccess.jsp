<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<head>
    <title>Blocked</title>

</head>

<p><h2>Your card blocked!</h2></p>
<p>Card number <strong>${card.cardNumber}</strong> and account number <strong>${card.cardAccount.accountNumber}</strong> has been blocked</p>
<form action="<c:url value="/main"/>">
    <input type="submit" value="Next" />
</form>

</body>
</html>