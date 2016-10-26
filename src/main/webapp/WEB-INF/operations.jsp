<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 30.09.2016
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                    <li><a href="/fil">Филиалы</a></li>
                    <li><a href="/acc">Счета</a></li>
                    <li><a href="/cards">Карты</a></li>
                    <li class="active"><a href="/oper">Операции</a></li>
                </ul>
            </div>
        </nav>
        <div class="jumbotron">
            <h2>Операции</h2>
        </div>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Дата</th>
                <th>Тип</th>
                <th>Редактирование</th>
            </tr>
            </thead>
                <tbody>
                <c:forEach items="${oper}" var="oper">
                    <tr>
                        <td> ${oper.idOper}</td>
                        <td> <fmt:formatDate value="${oper.dateOper}" pattern="dd-MM-yyyy"/></td>
                        <td> ${oper.typeOper}</td>
                        <td>
                            <div class="btn-group">
                                <a class="btn btn-default" role="button" href="<c:url value="/oper/updateForm?id=${oper.idOper}"/>">Изменить</a>
                                <a class="btn btn-default" role="button" href="<c:url value="/oper/delete?id=${oper.idOper}"/>">Удалить</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="/oper/addForm" class="btn btn-success" role="button">Добавить запись</a>
</div>
    </div>
</body>
</html>
