<%--
  Created by IntelliJ IDEA.
  User: 10255
  Date: 2020/12/17
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-L-admin1.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-nav">

      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>

    <a class="layui-btn layui-btn-primary layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:38px">ဂ</i>
    </a>

</div>


<div class="x-body">
    <div class="layui-row">

        <form class="layui-form layui-col-md12 x-so" method="post" action="${pageContext.request.contextPath}/getNews">
            <div class="layui-input-inline">
                <select name="type">
                    <option value="">类别</option>
                    <c:forEach items="${sessionScope.newTypeList}" var="news">
                        <option value="${news.type}">${news.type}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="text" name="name"  placeholder="请输入标题"  class="layui-input">
            <button class="layui-btn"  lay-submit="" type="submit"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>

    <xblock>
        <a href="${pageContext.request.contextPath}/toAddNewsPage">
            <button class="layui-btn" type="button"><i class="layui-icon"></i>添加</button>
        </a>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>标题</th>
            <th>类别</th>
            <th>内容</th>
            <th >操作</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="news" items="${newsList}" varStatus="i">
        <tr>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
            </td>


            <td>${i.count}</td>
            <td>${news.name}</td>
            <td>${news.type}</td>
            <td>${news.content}</td>
            <td class="td-manage">
                    <a href="${pageContext.request.contextPath}/delNews/${news.id}">
                        <button  class="layui-btn-danger layui-btn layui-btn-xs"type="submit" >
                            删除
                        </button>
                    </a>
                    <a href="${pageContext.request.contextPath}/toUpdateNewsPage/${news.id}">
                        <button  class="layui-btn layui-btn layui-btn-xs" type="submit" >
                            修改
                        </button>
                    </a>
            </td>
        </tr>
        </c:forEach>
    </table>

</div>

</body>

</html>
