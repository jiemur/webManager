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
    <link href="css/h.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="main">
    <div class="login">
        <h1>管理系统</h1>
        <div class="inset">
            <!--start-main-->
            <form action="doregister" method="post">
                <div>
                    <h2>用户注册</h2>
                    <span><label>用户名</label></span>
                    <span><input type="text" class="password" name="uname" id="unames" ><span id="message" style="color: red;position: absolute;top: 164px;right: 61px"></span></span></span>
                </div>
                <div>
                    <span><label>密码</label></span>
                    <span><input type="password" class="password" name="pwd" id="pwd"></span>
                </div>
                <div>
                    <span><label>确认密码</label></span>
                    <span><input type="password" class="password"  name="pwds" id="pwds" ><span id="pmes" ></span></span>
                </div>
                <div class="sign">
                    <input type="button" value="注册" class="submit1" disabled="disabled"   id="btn"/>
                    <div class="pt"><a href="login.jsp">用户登录</a></div>
                </div>
            </form>
            <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
            <script type="text/javascript">
                $(function () {
                    /*使用ajax*/
                    var un;
                    var pwd;
                    var pwds;
                    var tele;

                    $(".password").blur(function () {  //获取标签对象，绑定事件
                        un = $("#unames").val(); //通过id获取这个标签对象,再获取这个对象的值
                        pwd = $("#pwd").val();
                        pwds = $("#pwds").val();

                        $.ajax({
                            url:"doregister",
                            type:"post",
                            data:{"unames":un, "pwd":pwd, "pwds":pwds},   //把值传入java代码中
                            success:function (result) {  //回调函数，这里接受传出的数据
                                if (result == "1"){
                                    $("#message").text("可以注册");
                                }
                                if(result == "13"){
                                    $("#message").text("可以注册");
                                    $("#pmes").text("√");
                                    $("#btn").removeAttr("disabled");
                                }
                                if(result == "14"){
                                    $("#message").text("可以注册");
                                    $("#pmes").text("密码不一致");
                                }
                                if(result == "15"){
                                    $("#message").text("可以注册");
                                    $("#pmes").text("密码不能为空");
                                }
                                if (result == "2"){
                                    $("#message").text("用户名已存在");
                                }
                            }
                        });
                    });
                    $("#btn").click(function () {
                         $.ajax({
                         url:"doIt",
                         type:"post",
                         data:{"unames":un, "pwd":pwd, "pwds":pwds,"tele":tele},   //把值传入java代码中
                            success:function (data) {if (data=="1"){
                                    alert("注册成功");
                                    window.location.href="login";  //跳转登录界面
                                 }
                             }
                         });
                     });
                })
            </script>
        </div>
    </div>
    <!--//end-main-->
</div>
</body>
</html>
