<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<head>
    <title>Confirm</title>

</head>

<p><h2>Confirm pay!</h2></p>

<p>  Do you want to pay for service <strong>${service.serviceDescription}</strong> costing
     <strong>${service.servicePrice}</strong> with card number <strong>${cardNumber}</strong>
</p>
<form action="<c:url value="/main/paymentSuccess"/>"><input type="submit" value="Pay" />
    <input type="hidden" name="senderCardNumber" value="${cardNumber}">
    <input type="hidden" name="serviceNumber" value="${service.serviceNumber}">
</form>

<button type="button" name="back" onclick="history.back()">Back</button>
</body>
</html>