<%--
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
    <title>СберБанк</title>
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
                    <li><a href="/clients">Клиенты</a></li>
                    <li><a href="/fil">Филиалы</a></li>
                    <li><a href="/acc">Счета</a></li>
                    <li><a href="/cards">Карты</a></li>
                    <li class="active"><a href="/oper">Операции</a></li>
                </ul>
            </div>
        </nav>
        <div class="jumbotron">
                <h2>Изменение данных операции</h2>
        </div>

        <form:form method="POST" action="/oper/update"  modelAttribute="oper" cssClass="form-horizontal">
            <form:hidden path="id" />
            <form:hidden path="accountsEntity" />
            <div class="row">
                <div class="form-group col-md-9">
                    <label class="col-md-3 control-lable" for="dateOper">Дата операции</label>
                    <div class="col-md-7">
                        <form:input type="date" path="dateOper" id="dateOper" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="dateOper" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-9">
                    <label class="col-md-3 control-lable" for="typeOper">Тип операции</label>
                    <div class="col-md-7">
                        <form:input type="text" path="typeOper" id="typeOper" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="typeOper" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-actions">
                <button type="submit" class="btn btn-success">Подтвердить</button>
                <a class="btn btn-default" role="button" href="/oper">Отмена</a>
            </div>
        </form:form>

    </div>
</body>
</html>
