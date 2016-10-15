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
                    <li><a href="/cards">Карты</a></li>
                    <li class="active"><a href="/fil">Филиалы</a></li>
                    <li><a href="/oper">Операции</a></li>
                </ul>
            </div>
        </nav>
        <div class="jumbotron">
                <h2>Филиалы</h2>
        </div>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Дата</th>
                <th>Улица</th>
                <th>Дом</th>
                <th>Редактирование</th>
            </tr>
            </thead>
                <tbody>
                <c:forEach items="${fill}" var="fil">
                    <tr>
                        <td> ${fil.idFilial}</td>
                        <td> ${fil.region}</td>
                        <td> ${fil.street}</td>
                        <td> ${fil.home}</td>
                        <td>
                            <a href="<c:url value="/delete?option=fil&id=${fil.idFilial}"/>">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    <!--table>
        <tr>
            <td bgcolor="#f5f5dc">Id_клиента</td>
            <td>Фамилия</td>
            <td>Номер паспорта</td>
            <td>Серия паспорта</td>
            <td>Улица</td>
            <td>Дом</td>
            <td>Редактирование</td>
        </tr>
        <c:forEach items="${clients}" var="client">
            <tr>
                <td> ${client.idClient}</td>
                <td> ${client.surname}</td>
                <td> ${client.pasportN}</td>
                <td> ${client.pasportS}</td>
                <td> ${client.street}</td>
                <td> ${client.home}</td>
                <td>
                    <a href="<c:url value="/delete?option=client&id=${client.idClient}"/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </br>
    <!--h3>Таблица "Счета"</h3>
    <table>
        <tr>
            <td bgcolor="#f5f5dc">Id_счета</td>
            <td>Дата открытия</td>
            <td>Дата закрытия</td>
            <td>Редактирование</td>
        </tr>
        <c:forEach items="${accounts}" var="account">
            <tr>
                <td> ${account.idAccount}</td>
                <td> ${account.dateBegin}</td>
                <td> ${account.dateClose}</td>
                <td>
                    <a href="<c:url value="/delete?option=account&id=${account.idAccount}"/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </br>
    <h3>Таблица "Карты"</h3>
    <table>
        <tr>
            <td bgcolor="#f5f5dc">Id_карты</td>
            <td>Номер Карты</td>
            <td>VCC</td>
            <td>Тип карты</td>
            <td>Редактирование</td>

        </tr>
        <c:forEach items="${cards}" var="card">
            <tr>
                <td> ${card.idCard}</td>
                <td> ${card.number_card}</td>
                <td> ${card.vcc}</td>
                <td> ${card.type}</td>
                <td>
                    <a href="<c:url value="/delete?option=cards&id=${card.idCard}"/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </br>
    <h3>Таблица "Филиалы"</h3>
    <table>
        <tr>
            <td bgcolor="#f5f5dc">Id_филиала</td>
            <td>Дата</td>
            <td>Улица</td>
            <td>Дом</td>
            <td>Редактирование</td>

        </tr>
        <c:forEach items="${fil}" var="fil">
            <tr>
                <td> ${fil.idFilial}</td>
                <td> ${fil.region}</td>
                <td> ${fil.street}</td>
                <td> ${fil.home}</td>
                <td>
                    <a href="<c:url value="/delete?option=fil&id=${fil.idFilial}"/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </br>
    <h3>Таблица "Операции"</h3>
    <table>
        <tr>
            <td bgcolor="#f5f5dc">Id_операции</td>
            <td>Дата</td>
            <td>Тип</td>
            <td>Редактирование</td>
        </tr>
        <c:forEach items="${oper}" var="oper">
            <tr>
                <td> ${oper.idOper}</td>
                <td> ${oper.dateOper}</td>
                <td> ${oper.typeOper}</td>
                <td>
                    <a href="<c:url value="/delete?option=oper&id=${oper.idOper}"/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table-->


</div>
    </div>
</body>
</html>
