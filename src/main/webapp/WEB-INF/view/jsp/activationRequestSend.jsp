<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<head>
    <title>Activation</title>
</head>

<p><h2>Application sent!</h2></p>
<p>${username}, You have successfully sent a request to activate the card ${card.cardNumber}
    (account ${card.cardAccount.accountNumber}).<br>
    After reviewing the application by the administrator, your account will be unblocked.<br>Please wait.
</p>
<form action="<c:url value="/main"/>"><input type="submit" value="Next" /></form>

</body>
</html>