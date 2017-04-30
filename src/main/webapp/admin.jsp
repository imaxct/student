<%--
  Created by IntelliJ IDEA.
  User: imaxct
  Date: 17-4-30
  Time: 上午11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>
        登陆页 - 选课系统
    </title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/todc-bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-1">
            <label>&nbsp;</label>
        </div>
    </div>
    <div class="row">
        <div class="col-md-1">
            <label>&nbsp;</label>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
        </div>
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading"><h3>登陆</h3></div>
                <div class="panel-body">
                    <form action="A/login" method="post">
                        <div class="form-group">
                            <label for="stuNo">用户名</label>
                            <input class="form-control" name="u" id="stuNo" placeholder="账号" type="text" required>
                        </div>
                        <div class="form-group">
                            <label for="idNo">密码</label>
                            <input class="form-control" name="p" id="idNo" placeholder="密码" type="password" required>
                        </div>
                        <button class="btn btn-primary btn-lg btn-block">登陆</button>
                        <input type="reset" class="btn btn-default btn-lg btn-block" value="清空">
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
<script type="text/javascript" src="static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>
