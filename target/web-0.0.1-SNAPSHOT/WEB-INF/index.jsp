<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 30.09.2016
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Банки</title>
    <style><%@include file="styles.css" %></style>
</head>
<body>
<div class="tables">
    <h3>Таблица "Клиенты"</h3>
    <table>
        <tr>
            <td bgcolor="#f5f5dc">Id_клиента</td>
            <td>Фамилия</td>
            <td>Номер паспорта</td>
            <td>Серия паспорта</td>
            <td>Улица</td>
            <td>Дом</td>
        </tr>
        <c:forEach items="${clients}" var="client">
            <tr>
                <td> ${client.idClient}</td>
                <td> ${client.surname}</td>
                <td> ${client.pasportN}</td>
                <td> ${client.pasportS}</td>
                <td> ${client.street}</td>
                <td> ${client.home}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
