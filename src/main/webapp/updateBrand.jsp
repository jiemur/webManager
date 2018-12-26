<%--
  Created by IntelliJ IDEA.
  User: wzn
  Date: 2018/12/26
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="doUpdateB" method="post">
    <input type="text" name="id" value="${brand.id}" hidden="hidden">
    品牌名称:<input type="text" name="name" value="${brand.name}">
    品牌描述:<input type="text" name="des" value="${brand.des}">
    <input type="submit" value="修改">
</form>
</body>
</html>
