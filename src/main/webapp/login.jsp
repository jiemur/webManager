<%--
  Created by IntelliJ IDEA.
  User: wzn
  Date: 2018/12/21
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/style.css" rel='stylesheet' type='text/css' />
</head>
<body>
<div class="main">
    <div class="login">
        <h1>管理系统</h1>
        <div class="inset">
            <!--start-main-->
            <form id="fm">
                <div>
                    <h2>管理员登录</h2>
                    <span><label>用户名</label></span>
                    <span><input type="text" class="textbox" name="uname"></span>
                </div>
                <div>
                    <span><label>密码</label></span>
                    <span><input type="password" class="password" name="pwd"></span>
                </div>
                <div class="sign">
                    <input type="button" value="登录" class="submit" id="btn"/>
                    <div style="width: 88.8px;height: 35.2px;background-color: #0091e6;margin-left: 84px;border-radius: .3em;line-height: 35.2px;cursor: pointer;margin-top: 10px;font-weight: 600;"><a href="register.jsp" style="color: white">注册</a></div>
                    <div class="pt"><a href="register.jsp">忘记密码</a></div>
                </div>
            </form>

            <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
            <script type="text/javascript">
                $(function () {
                    $("#btn").click(function () {
                        console.log(1);
                       var fm=$("#fm").serialize();
                       $.ajax({
                           url:"doLogin",
                           type:"get",
                           data:fm,
                           success:function (data) {  //回调函数
                               if(data=="1"){
                                   alert("登录成功")
                                   window.location.href="list"
                               }
                               if(data=="2"){
                                   alert("密码错误")
                                    window.location.href="login"
                               }
                               if(data=="3"){
                                   alert("没有此用户,请注册")
                                   window.location.href="register"
                               }
                           }
                       })
                    })
                })
            </script>
        </div>
    </div>
    <!--//end-main-->
</div>
</body>
</html>
