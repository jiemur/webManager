<%--
  Created by IntelliJ IDEA.
  User: wzn
  Date: 2018/12/25
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>首页</title>
    <link rel="stylesheet" href="css/page.css" />
    <script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
    <script type="text/javascript" src="js/index.js" ></script>
</head>

<body>

<div class="left">
    <div class="bigTitle">后台管理系统</div>
    <div class="lines">
      <a href="brandList">  <div onclick="pageClick(this)"  class="active"><img src="img/icon-1.png" />品牌管理</div></a>
        <a href="productList"><div onclick="pageClick(this)"><img src="img/icon-2.png" />商品管理</div></a>
        <a href="selef.jsp"><div onclick="pageClick(this)"><img src="img/icon-3.png" />个人信息管理</div></a>
        <div onclick="pageClick(this)"><img src="img/icon-4.png" />收货地址管理</div>
        <div onclick="pageClick(this)"><img src="img/icon-5.png" />在售门店管理</div>
    </div>
</div>
<div class="top">
    <%--<div class="leftTiyle" id="flTitle">业务人员管理</div>--%>
    <div class="thisUser"><a href="login.jsp">退出</a></div>
</div>
<div class="content" style="color: #0091e6">
    <table >
        <a href="add.jsp">添加</a>
        <caption>商品信息</caption>
        <thead>
        <tr>
            <th>商品编号</th>
            <th>商品名称</th>
            <th>商品价格</th>
            <th>商品图片</th>
            <th>商品描述</th>
            <th>商品库存</th>
            <th>品牌编号</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lists}" var="pro">
            <tr>
                <td>${pro.id}</td>
                <td>${pro.name}</td>
                <td>${pro.price}</td>
                <td>${pro.url}</td>
                <td>${pro.des}</td>
                <td>${pro.inv}</td>
                <td>${pro.brandId}</td>
                <td><a href="delete?id=${pro.id}">删除</a>&nbsp|&nbsp<a href="update?id=${pro.id}">修改</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

