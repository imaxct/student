<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: imaxct
  Date: 17-5-2
  Time: 下午3:29
  To change this template use File | Settings | File Templates.
  msexcel
--%>
<%@ page contentType="application/vnd.ms-excel;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>导出信息</title>
</head>
<body>
    <table>
        <tr>
            <th>姓名</th><th>性别</th><th>身份证</th><th>学号</th><th>年级</th><th>校区</th><th>手机</th>
            <th>QQ</th><th>email</th>
        </tr>
        <c:forEach var="x" items="${list}">
            <tr>
                <td>x.id.user.name</td><td>x.id.user.sex</td><td>x.id.user.idNo</td><td>x.id.user.stuNo</td>
                <td>x.id.user.grade</td><td>x.id.user.campus</td><td>x.id.user.phone</td><td>x.id.user.qq</td>
                <td>x.id.user.email</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
