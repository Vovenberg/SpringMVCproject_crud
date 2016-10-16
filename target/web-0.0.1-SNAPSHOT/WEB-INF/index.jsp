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
                    <li class="active"><a href="/clients/results">Клиенты</a></li>
                    <li><a href="/acc">Счета</a></li>
                    <li><a href="/cards">Карты</a></li>
                    <li><a href="/fil">Филиалы</a></li>
                    <li><a href="/oper">Операции</a></li>
                </ul>
            </div>
        </nav>
        <div class="jumbotron">
                <h1>База данных СберБанка</h1>
                <p>работа выполнена студентом группы 6133М Кильдюшевым Владимиром</p>
        </div>


        <div class="list-group">
            <a href="/clients/results" class="list-group-item">Клиенты</a>
            <a href="/acc" class="list-group-item">Счета</a>
            <a href="/cards" class="list-group-item">Карты</a>
            <a href="/fil" class="list-group-item">Филиалы</a>
            <a href="/oper" class="list-group-item">Операции</a>
        </div>

    </div>
</body>

</html>
