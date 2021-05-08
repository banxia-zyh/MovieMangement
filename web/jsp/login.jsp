<%--
  Created by IntelliJ IDEA.
  User: 半夏
  Date: 2020/12/15/0015
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>登录</title>
    <link href="${pageContext.request.contextPath}/statics/css/login.css" rel="stylesheet" type="text/css" />
</head>

<body><br><br><br>
<div class="login_box">
    <div class="login_l_img"><img src="${pageContext.request.contextPath}/statics/images/login-img.png"/></div>
    <div class="login">
        <div class="login_logo"><img src="${pageContext.request.contextPath}/statics/images/login_logo.png" /></div>
        <div class="login_name">
            <p>电影后台管理系统</p>
        </div>
        <form action="${pageContext.request.contextPath}/login.html" method="post">
            <input required name="username" type="text"  placeholder="用户名">

            <input required name="password" type="password" id="password" placeholder="密码"/>
            <span style="color: red">${error}</span>
            <input value="登录" style="width:100%;" type="submit">
        </form>
    </div>

</div>
<div style="text-align:center;">
</div>
</body>
</html>

