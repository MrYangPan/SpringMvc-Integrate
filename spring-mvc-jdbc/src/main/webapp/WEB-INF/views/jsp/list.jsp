<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  Account: Mr.PanYang
  Date: 2018/5/28
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<head>
    <title>Jsp 语法训练</title>
</head>
<body>
<table>
    <tr>
        <th>数据库spring的数据</th>
    </tr>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>储蓄金</td>
    </tr>
    <c:forEach var="item" items="${list}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.money}</td>
        </tr>
    </c:forEach>
    <tr>
        <th>数据库spring2的数据</th>
    </tr>
    <c:forEach var="item" items="${list2}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.money}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
