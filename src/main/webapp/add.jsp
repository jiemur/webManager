<%--
  Created by IntelliJ IDEA.
  User: wzn
  Date: 2018/12/24
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>添加商品</p><br>
    <a href="add.jsp">添加</a>
    <form action="doAdd" method="post" enctype="multipart/form-data">
        商品名称:<input type="text" name="name"><br>
        商品价格:<input type="text" name="price"><br>
        商品图片:<input type="file" name="file" onchange="imgChange(this)"> <img id="img"><br>
        商品描述:<input type="text" name="des"><br>
        商品库存:<input type="text" name="inv"><br>
        <input type="submit" value="添加">
    </form>
    <script type="text/javascript">
      function imgChange(obj) {
          console.log(obj.files[0]);
          var reader=new FileReader();
          reader.onload=function (ev) {
              var img=document.getElementById("img")
              img.src=ev.target.result;
          };
          reader.readAsDataURL(obj.files[0]);
      }

    </script>

</body>
</html>
