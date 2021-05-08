<%--
  Created by IntelliJ IDEA.
  User: 10255
  Date: 2020/12/17
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>电影后台管理系统</title>
  <meta name="renderer" content="webkit|ie-comp|ie-stand">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
  <meta http-equiv="Cache-Control" content="no-siteapp" />

  <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
  <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
  <script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>

</head>
<body>
<!-- 顶部开始 -->
<div class="container">
  <div class="logo"><a href="index.jsp">电影后台管理系统</a></div>
  <div class="left_open">
    <i title="展开左侧栏" class="iconfont">&#xe699;</i>
  </div>
  <ul class="layui-nav right" lay-filter="">
    <li class="layui-nav-item">
      <a href="javascript:;">${sessionScope.userSession.username}</a>
      <dl class="layui-nav-child"> <!-- 二级菜单 -->
        <dd><a href="${pageContext.request.contextPath}/logout" >退出</a></dd>
      </dl>
    </li>
  </ul>
</div>

<div class="left-nav">
  <div id="side-nav">
    <ul id="nav">

      <li >
        <a href="javascript:;">
          <i class="iconfont">&#xe6eb;</i>
          <cite>主页</cite>
          <i class="iconfont nav_right">&#xe6a7;</i>
        </a>
        <ul class="sub-menu">
          <li><a _href="${pageContext.request.contextPath}/welcome"><i class="iconfont">&#xe6a7;</i><cite>控制台</cite></a></li >
        </ul>
      </li>

      <li >
        <a href="javascript:;">
          <i class="iconfont">&#xe6e4;</i>
          <cite>电影管理</cite>
          <i class="iconfont nav_right">&#xe6a7;</i>
        </a>
        <ul class="sub-menu">
          <li><a _href="${pageContext.request.contextPath}/movieList.html"><i class="iconfont">&#xe6a7;</i><cite>电影信息管理</cite></a></li >
          <li><a _href="${pageContext.request.contextPath}/movieTypeList"><i class="iconfont">&#xe6a7;</i><cite>电影类别管理</cite></a></li >
          <li><a _href="jsp/uploadMovie.jsp"><i class="iconfont">&#xe6a7;</i><cite>上传电影</cite></a></li >
        </ul>
      </li>

      <li>
        <a href="javascript:;">
          <i class="iconfont">&#xe69e;</i>
          <cite>新闻管理</cite>
          <i class="iconfont nav_right">&#xe6a7;</i>
        </a>
        <ul class="sub-menu">
          <li><a _href="${pageContext.request.contextPath}/newsList.html"><i class="iconfont">&#xe6a7;</i><cite>新闻信息管理</cite></a></li >
          <li><a _href="${pageContext.request.contextPath}/newTypeList"><i class="iconfont">&#xe6a7;</i><cite>新闻类别管理</cite></a></li >
        </ul>
      </li>
      <li>
        <a href="javascript:;">
          <i class="iconfont">&#xe6b8;</i>
          <cite>用户管理</cite>
          <i class="iconfont nav_right">&#xe6a7;</i>
        </a>
        <ul class="sub-menu">
          <li><a _href="${pageContext.request.contextPath}/toUpdatePwd"><i class="iconfont">&#xe6a7;</i><cite>修改密码</cite></a></li >
        </ul>
      </li>
    </ul>
  </div>
</div>
<div class="page-content">
  <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
    <ul class="layui-tab-title">
      <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
    </ul>
    <div class="layui-tab-content">
      <div class="layui-tab-item layui-show">
        <iframe src='welcome' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
      </div>
    </div>
  </div>
</div>
<div class="page-content-bg"></div>

</body>
</html>
