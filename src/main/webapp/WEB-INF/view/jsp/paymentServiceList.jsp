<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Choose a Service</title>
</head>
<body>
<div>
    <h2 style="text-align:center">${username}, Choose a Service for Payment </h2>
</div>

<hr />
<p>Services</p>
<hr />

<table style="width:1000px">
    <tbody>
    <tr>
        <td>Service number</td>
        <td>Service description</td>
        <td>Service Price</td>
        <td>Organisation</td>

    </tr>
    <tr>
        <td>
            <c:forEach items="${allServices}" var="service">
            <a href="/paymentChooseCard?serviceNumber=${service.serviceNumber}"/>${service.serviceNumber} </a><br>
            </c:forEach>
        </td>
        <td>
            <c:forEach items="${allServices}" var="service">
            ${service.serviceDescription}<br>
            </c:forEach></td>
        <td>
            <c:forEach items="${allServices}" var="service">
            ${service.servicePrice}<br>
            </c:forEach>
        </td>
        <td>
            <c:forEach items="${allServices}" var="service">
            ${service.organisation.organisationName}<br>
            </c:forEach></td>
        </td>

    </tr>
    </tbody>
</table>


<button type="button" name="back" onclick="history.back()">Back</button>
</body>
</html>