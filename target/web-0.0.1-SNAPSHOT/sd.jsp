<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Банки</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style><%@include file="WEB-INF/styles.css" %></style>
</head>
<body>
<h1>Банковские счета</h1>
<h4>by Кильдюшев В. гр. 6133М</h4>
    <hr>
    <aside>

        <a href="add.jsp">Добавить</a>
        </br></br>

    </aside>
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
                </tr>
            </c:forEach>
            <%--<tr>
                <td style="font-size: 26px" bgcolor="#f5f5dc"><%=d.getId_driver()%></td>
                <td style="font-size: 26px"><%=d.getName_driver()%></td>
                <td style="font-size: 26px"><%=d.getSurname_driver()%></td>
                <td style="font-size: 26px"><%=d.getVod_udost()%></td>
                <td><a href="edit.jsp?type=1&id=<%=d.getId_driver()%>"> Изменить</a></br><a href="/delete?type=1&id=<%=d.getId_driver()%>">Удалить</a></td>
            </tr>--%>
        </table>


    </div>


</body>
</html>
