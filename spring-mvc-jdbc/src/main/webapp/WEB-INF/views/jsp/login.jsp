<%--
  Created by IntelliJ IDEA.
  User: Mr.PanYang
  Date: 2018/5/28
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/home/login" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"/></td>
        </tr>
    </table>
</form>
</body>
</html>
