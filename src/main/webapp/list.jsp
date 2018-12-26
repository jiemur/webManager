<%--
  Created by IntelliJ IDEA.
  User: wzn
  Date: 2018/12/22
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>首页</title>
    <link rel="stylesheet" href="css/page.css" />
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
    <script type="text/javascript" src="js/index.js" ></script>
</head>

<body>

<div class="left">
    <div class="bigTitle">后台管理系统</div>
    <div class="lines">
        <a href="brandList"><div onclick="pageClick(this)" class="active"><img src="img/icon-1.png" />品牌管理</div></a>
        <a href="productList"><div onclick="pageClick(this)"><img src="img/icon-2.png" />商品管理</div></a>
        <a href="selef.jsp"><div onclick="pageClick(this)"><img src="img/icon-3.png" />个人信息管理</div></a>
        <div onclick="pageClick(this)"><img src="img/icon-4.png" />收货地址管理</div>
        <div onclick="pageClick(this)"><img src="img/icon-5.png" />在售门店管理</div>
    </div>
</div>
<div class="top">
    <%--<div class="leftTiyle" id="flTitle">业务人员管理</div>--%>
    <div class="thisUser"><a href="exit">退出</a></div>
</div>
    <table class="table table-hover"></table>
</body>
</html>
