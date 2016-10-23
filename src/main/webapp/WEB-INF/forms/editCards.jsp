editClients.jsp<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 30.09.2016
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
                <h2>Изменение данных карты</h2>
        </div>

        <form:form method="POST" action="/cards/update"  modelAttribute="card" cssClass="form-horizontal">
            <form:hidden path="idCard" />
            <div class="row">
                <div class="form-group col-md-9">
                    <label class="col-md-3 control-lable" for="numberCard">Номер карты</label>
                    <div class="col-md-7">
                        <form:input type="text" path="numberCard" id="numberCard" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="numberCard" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-9">
                    <label class="col-md-3 control-lable" for="vcc">Номер VCC</label>
                    <div class="col-md-7">
                        <form:input type="text" path="vcc" id="vcc" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="vcc" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-9">
                    <label class="col-md-3 control-lable" for="type">Тип карты</label>
                    <div class="col-md-7">
                        <form:input type="text" path="type" id="type" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="type" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-actions">
                <button type="submit" class="btn btn-success">Подтвердить</button>
                <a class="btn btn-default" role="button" href="/cards">Отмена</a>
            </div>
        </form:form>

    </div>
</body>
</html>
