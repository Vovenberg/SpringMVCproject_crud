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
    <%--<style>
        <%@include file="styles.css" %>
    </style>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
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
                    <li><a href="/clients">Клиенты</a></li>
                    <li><a href="/acc">Счета</a></li>
                    <li class="active"><a href="/cards">Карты</a></li>
                    <li><a href="/fil">Филиалы</a></li>
                    <li><a href="/oper">Операции</a></li>
                </ul>
            </div>
        </nav>
        <div class="jumbotron">
                <h2>Карты</h2>
        </div>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Номер Карты</th>
                <th>VCC</th>
                <th>Тип карты</th>
                <th>Редактирование</th>
            </tr>
            </thead>
                <tbody>
                <c:forEach items="${cards}" var="card">
                    <tr>
                        <td> ${card.idCard}</td>
                        <td> ${card.number_card}</td>
                        <td> ${card.vcc}</td>
                        <td> ${card.type}</td>
                        <td>
                            <div class="btn-group">
                                <button type="button" class="btn btn-default">Изменить</button>
                                <button type="button" class="btn btn-default" href="<c:url value="/delete?option=cards&id=${card.idCard}"/>">Удалить</button>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-success">Добавить запись</button>
    </div>

</body>
</html>
