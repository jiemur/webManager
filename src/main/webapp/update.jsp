<%--
  Created by IntelliJ IDEA.
  User: wzn
  Date: 2018/12/23
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="doUpdate" method="post" enctype="multipart/form-data"><%--设置地址栏不显示私有数据--%>
    <input type="text" name="id" hidden="hidden" value="${p.id}">
    商品名称：<input type="text" name="name" value="${p.name}"><br>
    商品价格：<input type="text" name="price" value="${p.price}"><br>
    商品图片：<input type="file" name="file" value="${p.url}"><br>
    商品描述：<input type="text" name="des" value="${p.des}"><br>
    商品库存: <input type="text" name="inv" value="${p.inv}"><br>
    品牌编号: <input type="text" name="brandId" value="${p.brandId}">
    <input type="submit" value="修改">
</form>
</body>
</html>
