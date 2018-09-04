<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
<table>
    <tr>
        <th colspan="2">数据库spring的数据</th>
    </tr>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>储蓄金</td>
    </tr>
    <c:forEach var="item" items="${accounts}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.money}</td>
        </tr>
    </c:forEach>
    </tr>
</table>
</body>
</html>
