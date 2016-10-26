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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">СберБанк</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="/clients">Клиенты</a></li>
                <li><a href="/fil">Филиалы</a></li>
                <li><a href="/acc">Счета</a></li>
                <li><a href="/cards">Карты</a></li>
                <li><a href="/oper">Операции</a></li>
            </ul>
        </div>
    </nav>
    <div class="jumbotron">
        <h2>Клиенты</h2>
    </div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Фамилия</th>
            <th>Номер паспорта</th>
            <th>Серия паспорта</th>
            <th>Улица</th>
            <th>Дом</th>
            <th>Редактирование</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${clients}" var="client">
            <tr>
                <td> ${client.idClient}</td>
                <td> ${client.surname}</td>
                <td> ${client.pasportN}</td>
                <td> ${client.pasportS}</td>
                <td> ${client.street}</td>
                <td> ${client.home}</td>
                <td>
                    <div class="btn-group">

                        <a class="btn btn-default" role="button"
                           href="<c:url value="/clients/updateForm?id=${client.idClient}"/>">Изменить</a>
                        <a class="btn btn-default" <c:if test="${not empty client.accountsEntityList}">disabled="true"
                           </c:if>role="button"
                           href="<c:url value="/clients/delete?id=${client.idClient}"/>">Удалить</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/clients/addForm" class="btn btn-success" role="button">Добавить запись</a>

</div>
</body>
</html>
