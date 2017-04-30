<%--
  Created by IntelliJ IDEA.
  User: maxct
  Date: 2017/4/15
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>提示信息</title>
</head>
<body>
<h1>${msg}</h1>
<p>2S后跳转, <a href="/student/admin.jsp">点此跳转</a></p>
<script>
    function go() {
        window.location.href='/student/admin.jsp';
    }
    setTimeout(go, 2000);
</script>
</body>
</html>
