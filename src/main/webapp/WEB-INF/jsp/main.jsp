<%--
  Created by IntelliJ IDEA.
  User: maxct
  Date: 2017/4/15
  Time: 12:50
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
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<nav class="navbar navbar-masthead navbar-default">
    <div class="container-fluid">
        <p class="navbar-text navbar-right">
            <a href="#" class="navbar-link" id="user_info">${user.name}</a>
            <span>&nbsp;</span>
            <a href="logout" class="navbar-link">退出</a>
            <span>&nbsp;</span>
        </p>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <ul class="list-group">
                <li class="list-group-header">课程</li>
                <li class="list-group-item active"><a href="#" id="courseDeclare">选课公告</a></li>
                <li class="list-group-item"><a href="#" id="courseChoose">选课</a></li>
                <li class="list-group-item"><a href="#" id="chosen">已选课程</a></li>
            </ul>
        </div>
        <div class="col-md-9">
            <div id="frame">
            </div>
        </div>
    </div>
</div>
<script src="/student/static/js/jquery-3.2.1.min.js"></script>
<script src="/student/static/js/bootstrap.min.js"></script>
<script>
    $(document)
        .on('click', '#courseDeclare', function () {
            $('#frame').load('/student/User/G');
        })
        .on('click', '#courseChoose', function () {
            $('#frame').load('/student/C/list');
        })
        .on('click', '.list-group-item', function (event) {
            var e = event.currentTarget;
            $($(e).parent().children()).removeClass('active');
            $(e).addClass('active');
        })
        .on('click', '#chosen', function () {
            $('#frame').load('/student/C/chosen')
        })
        .on('click', '#user_info', function () {
            $('.list-group-item').removeClass('active');
            $('#frame').load('/student/User/fillInfo');
        });
    $('#courseDeclare').click();
</script>
</body>
</html>
