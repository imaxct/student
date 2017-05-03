<%@ page import="java.util.UUID" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: imaxct
  Date: 17-5-2
  Time: 下午3:29
  To change this template use File | Settings | File Templates.
  msexcel
--%>
<%@ page contentType="application/msexcel;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%
    response.setHeader("Content-Disposition", "attachment;filename=" + UUID.randomUUID().toString() + ".xls");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="ProgId" content="Excel.Sheet"/>
    <meta name="Generator" content="WPS Office ET"/>
    <!--[if gte mso 9]>
 <xml>
  <o:DocumentProperties>
   <o:Created>2017-05-04T00:46:02</o:Created>
   <o:LastSaved>2017-05-04T00:46:19</o:LastSaved>
  </o:DocumentProperties>
  <o:CustomDocumentProperties>
   <o:KSOProductBuildVer dt:dt="string">2052-10.1.0.5672</o:KSOProductBuildVer>
  </o:CustomDocumentProperties>
 </xml>
<![endif]-->
</head>
<body>
    <table border="1">
        <tr>
            <th>姓名</th><th>性别</th><th>身份证</th><th>学号</th><th>年级</th><th>校区</th><th>手机</th>
            <th>QQ</th><th>email</th>
        </tr>
        <c:forEach var="x" items="${list}">
            <tr>
                <td>${x.id.user.name}</td><td>${x.id.user.sex}</td><td x:str>${x.id.user.idNo}</td><td x:str>${x.id.user.stuNo}</td>
                <td>${x.id.user.grade}</td><td>${x.id.user.campus}</td><td x:str>${x.id.user.phone}</td><td x:str>${x.id.user.qq}</td>
                <td>${x.id.user.email}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
