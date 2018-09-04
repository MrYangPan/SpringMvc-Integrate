<%--
  Created by IntelliJ IDEA.
  User: Mr.PanYang
  Date: 2018/6/1
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
    <title>List与数组直接绑定自定义数据类型与AJAX</title>
    <script src="../../resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<button type="button" onclick="query.addPdts1();">向服务器发送json</button>
<button type="button" onclick="query.addPdts2();">接收服务器返回的json</button>
<p id="msg"></p>

<script type="text/javascript">
    var query = {};
    query.products = new Array();
    query.products.push({
        id: 1,
        name: "iPhone 6 Plus",
        price: 4987.5
    });
    query.products.push({
        id: 2,
        name: "iPhone 7 Plus",
        price: 5987.5
    });
    query.products.push({
        id: 3,
        name: "iPhone 8 Plus",
        price: 6987.5
    });
    query.addPdts1 = function () {
        $.ajax({
            type: "POST",
            //请求谓词类型
            url: "action5",
            data: JSON.stringify(query.products), //将products对象转换成json字符串
            contentType: "application/json;charset=UTF-8",
            //发送信息至服务器时内容编码类型，(默认: "application/x-www-form-urlencoded")
            dataType: "text", //预期服务器返回的数据类型
            success: function (result) {
                $("#msg").html(result);
            }
        });
    };
    query.addPdts2 = function () {
        $.ajax({
            type: "POST",
            //请求谓词类型
            url: "action22",
            data: JSON.stringify(query.products), //将products对象转换成json字符串
            contentType: "application/json;charset=UTF-8",
            //发送信息至服务器时内容编码类型，(默认: "application/x-www-form-urlencoded")
            dataType: "json", //预期服务器返回的数据类型
            success: function (result) {
                var str = "";
                $.each(result, function (i, obj) {
                    str += "编号：" + obj.id + ",名称：" + obj.name + ",价格：" + obj.price + "<br/>";
                });
                $("#msg").html(str);
            }
        });
    };

</script>
</body>
</html>
