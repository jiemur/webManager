<%--
  Created by IntelliJ IDEA.
  User: wzn
  Date: 2018/12/25
  Time: 10:58
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

        <div class="inset">
            <!--start-main-->
            <form id="fm">
                <div>
                    <h2>修改密码</h2>
                    <span><label>用户名</label></span>
                    <span><input type="text" class="textbox" name="uname"></span>
                </div>
                <div>
                    <span><label>旧密码</label></span>
                    <span><input type="password" class="password" name="pwd"></span>
                </div>
                <div>
                    <span><label>新密码</label></span>
                    <span><input type="password" class="password" name="npwd"></span>
                </div>
                <div class="sign">
                    <input type="button" value="修改" class="submit" id="btn" />
                </div>
                <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
                <script type="text/javascript">
                    $(function () {
                        $("#btn").click(function () {
                            var fm=$("#fm").serialize();
                        })
                    })
                </script>
            </form>
        </div>
    </div>
</div>
</body>

</html>
