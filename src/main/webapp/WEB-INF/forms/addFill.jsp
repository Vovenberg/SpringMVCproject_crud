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
    <title>Банки</title>
    <%--<style>
        <%@include file="styles.css" %>
    </style>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <!-- Include Date Range Picker -->
    <script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
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
                    <li class="active"><a href="/clients">Клиенты</a></li>
                    <li><a href="/acc">Счета</a></li>
                    <li><a href="/cards">Карты</a></li>
                    <li><a href="/fil">Филиалы</a></li>
                    <li><a href="/oper">Операции</a></li>
                </ul>
            </div>
        </nav>
        <div class="jumbotron">
                <h2>Добавление филиала</h2>
        </div>

        <form:form method="POST" action="/fil/add" modelAttribute="fil" cssClass="form-horizontal">
            <div class="row">
                <div class="form-group col-md-9">
                    <label class="col-md-3 control-lable" >Дата</label>
                    <div class="col-md-7">
                        <input type="text" name="birthdate" value="10/24/1984" />
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-9">
                    <label class="col-md-3 control-lable" for="street">Улица</label>
                    <div class="col-md-7">
                        <form:input type="text" path="street" id="street" class="form-control input-sm"/>

                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-9">
                    <label class="col-md-3 control-lable" for="home">Дом</label>
                    <div class="col-md-7">
                        <form:input type="text" path="home" id="home" class="form-control input-sm"/>

                    </div>
                </div>
            </div>
            <div class="form-actions">
                <button type="submit" class="btn btn-success">Подтвердить</button>
                <a class="btn btn-default" role="button" href="/fil">Отмена</a>
            </div>
        </form:form>

    </div>

    <script type="text/javascript">
        $(function() {
            $('input[name="region"]').daterangepicker({
                        singleDatePicker: true,
                        showDropdowns: true
                    },
                    function(start, end, label) {
                        var years = moment().diff(start, 'years');
                        alert("You are " + years + " years old.");
                    });
        });
    </script>
</body>
</html>