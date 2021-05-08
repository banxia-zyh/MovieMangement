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

        <form class="layui-form layui-col-md12 x-so" action="${pageContext.request.contextPath}/getMovie" method="post">
            <div class="layui-input-inline">
                <select name="type">
                    <option value="">类别</option>
                    <c:forEach items="${sessionScope.movieTypeList}" var="movieType">
                        <option value="${movieType.type}">${movieType.type}</option>
                    </c:forEach>
                </select>
            </div>
            <label>
                <input type="text" name="name"  placeholder="请输入电影名" autocomplete="off" class="layui-input">
            </label>
            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>

    </div>


    <table class="layui-table" style="text-align: center">
        <thead>
        <tr>
            <th style="text-align: center">
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th style="text-align: center">ID</th>
            <th style="text-align: center">封面</th>
            <th style="text-align: center">电影名</th>
            <th style="text-align: center">类别</th>
            <th style="text-align: center">内容</th>
            <th style="text-align: center">video</th>
            <th style="text-align: center">操作</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="movie" items="${movieList}" varStatus="i">
        <tr>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
            </td>


                <td>${i.count}</td>
                <td><img src="${movie.img}"/></td>
                <td>${movie.name}</td>
                <td>${movie.type}</td>
                <td>${movie.synopsis}</td>
                <td>
                    <video width="320px" height="160px" controls>
                        <source src="${movie.video}" type="video/mp4">
                    </video>
                </td>
                <td class="td-manage">
                    <%--<form action="${pageContext.request.contextPath}/delMovie" id="del" method="post">--%>
                    <%--    <input value="${movie.id}" type="hidden" name="id">--%>
                    <%--</form>--%>
                    <%--<form action="${pageContext.request.contextPath}/toUpdateMoviePage" id="update" method="post">--%>
                    <%--    <input value="${movie.id}" type="hidden" name="id">--%>
                    <%--</form>--%>
                        <a href="${pageContext.request.contextPath}/delMovie/${movie.id}" >
                            <button  class="layui-btn-danger layui-btn layui-btn-xs" type="submit" >
                                删除
                            </button>
                        </a>
                        <a href="${pageContext.request.contextPath}/toUpdateMoviePage/${movie.id}">
                            <button  class="layui-btn layui-btn layui-btn-xs"  type="submit" >
                                修改
                            </button>
                        </a>

                </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

    /*用户-停用*/
    function member_stop(obj,id){
        layer.confirm('确认要停用吗？',function(index){

            if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

            }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
            }

        });
    }

    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }



    function delAll (argument) {

        var data = tableCheck.getData();

        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
    }
</script>
</body>

</html>
