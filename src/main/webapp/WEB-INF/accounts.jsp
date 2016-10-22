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
                    <li class="active"><a href="/acc">Счета</a></li>
                    <li><a href="/cards">Карты</a></li>
                    <li><a href="/fil">Филиалы</a></li>
                    <li><a href="/oper">Операции</a></li>
                </ul>
            </div>
        </nav>
        <div class="jumbotron">
                <h2>Счета</h2>
        </div>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>Id_счета</th>
                <th>Дата открытия</th>
                <th>Дата закрытия</th>
                <th>Редактирование</th>
            </tr>
            </thead>
                <tbody>
                <c:forEach items="${acc}" var="account">
                    <tr>
                        <td> ${account.idAccount}</td>
                        <td> ${account.dateBegin}</td>
                        <td> ${account.dateClose}</td>
                        <td>
                            <div class="btn-group">
                                <a class="btn btn-default" role="button" href="<c:url value="/acc/updateForm?id=${account.idAccount}"/>">Изменить</a>
                                <a class="btn btn-default" role="button" href="<c:url value="/acc/delete?id=${account.idAccount}"/>">Удалить</a>
                             </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="/acc/addForm" class="btn btn-success" role="button">Добавить запись</a>
    </div>
</body>
</html>
