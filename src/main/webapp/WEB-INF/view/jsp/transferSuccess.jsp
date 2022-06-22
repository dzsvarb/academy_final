<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<head>
    <title>Done</title>
</head>

<p><h2>Success!</h2></p>
<p><strong>${amount}</strong> was transferred from card number <strong>${cardNumber}</strong> to card number <strong>${recipientCard}</strong></p>
<form action="<c:url value="/main"/>"><input type="submit" value="Next" /></form>

</body>
</html>