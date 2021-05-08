<%--
  Created by IntelliJ IDEA.
  User: 半夏
  Date: 2020/12/17/0017
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-L-admin1.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="../css/font.css">
    <link rel="stylesheet" href="../css/xadmin.css">
    <script src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-body">
    <form class="layui-form" action="${pageContext.request.contextPath}/updatePwd" method="post">
        <input type="hidden" value="${sessionScope.userSession.username}" name="username">
        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label">
                <span class="x-red">*</span>旧密码
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_username" name="oldPwd" required lay-verify="nikename"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_pass" class="layui-form-label">
                <span class="x-red">*</span>密码
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_pass" name="pass" required lay-verify="pass"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                6到16个字符
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
                <span class="x-red">*</span>确认密码
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_repass" name="repass" required lay-verify="repass" autocomplete="off" class="layui-input" onkeyup="validate()"><span id="tishi"></span>
                <span id="msg">${msg}</span>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
            </label>
            <button  class="layui-btn" type="submit" id="button" onclick="xxxx()">
                修改
            </button>
        </div>
    </form>
</div>
<script>
    function xxxx() {
        var su1 = ${sessionScope.userSession.password};
        var su2 = document.getElementById("L_username").value;

      if(su1 == su2 ){
          alert("修改成功，返回登录")
          parent.location.href="${pageContext.request.contextPath}/jsp/login.jsp";
      }
    }
    function validate() {
        var pwd1 = document.getElementById("L_pass").value;
        var pwd2 = document.getElementById("L_repass").value;

        <!-- 对比两次输入的密码 -->
        if(pwd1 == pwd2)
        {
            document.getElementById("tishi").innerHTML="<font color='green'></font>";
            document.getElementById("button").disabled = false;
        }
        else {
            document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
            document.getElementById("button").disabled = true;
        }
    }
</script>
</body>

</html>
