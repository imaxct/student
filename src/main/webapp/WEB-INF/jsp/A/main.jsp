<%--
  Created by IntelliJ IDEA.
  User: imaxct
  Date: 17-4-30
  Time: 下午12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="Content-Security-Policy" content="upgrade-insecure-requests">
    <title>
        个人页 - 教务系统
    </title>
    <link href="/student/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/student/static/css/todc-bootstrap.min.css" rel="stylesheet">
    <link href="/student/static/css/wangEditor.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<nav class="navbar navbar-masthead navbar-default">
    <div class="container-fluid">
        <p class="navbar-text navbar-right">
            <a href="#" class="navbar-link">${admin.username}</a>
            <span>&nbsp;</span>
            <a href="logout" class="navbar-link">退出</a>
            <span>&nbsp;</span>
        </p>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            <ul class="list-group">
                <li class="list-group-header">课程</li>
                <li class="list-group-item"><a href="#" id="courses">课程信息</a></li>
                <li class="list-group-item"><a href="#" id="import">导入信息</a></li>
                <li class="list-group-item"><a href="#" id="addCourse">添加课程</a></li>
                <li class="list-group-item"><a href="#" id="setting">系统设置</a></li>
            </ul>
        </div>
        <div class="col-md-10">
            <div id="frame">
            </div>
        </div>
    </div>
</div>
<script src="/student/static/js/jquery-3.2.1.min.js"></script>
<script src="/student/static/js/bootstrap.min.js"></script>
<script src="/student/static/js/wangEditor.min.js"></script>
<script>
    $(document)
        .on('click', '#courses', function () {
            $('#frame').load('/student/A/list');
        })
        .on('click', '#import', function () {
            $('#frame').load('/student/A/upload');
        })
        .on('click', '.list-group-item', function (event) {
            var e = event.currentTarget;
            $($(e).parent().children()).removeClass('active');
            $(e).addClass('active');
        })
        .on('click', '#addCourse', function () {
            $('#frame').load('/student/A/editor')
        })
        .on('click', '#setting', function () {
            $('#frame').load('/student/A/setting');
        });
</script>
</body>
</html>
