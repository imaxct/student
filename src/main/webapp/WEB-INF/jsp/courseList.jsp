<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maxct
  Date: 2017/4/15
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<table class="table table-hover">
    <thead>
    <tr>
        <th>课程ID</th><th>课程名</th><th>上课时间</th><th>上课地点</th><th>选课情况</th><th>选课</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty list}">
    <c:forEach var="item" items="${list}">
    <tr>
        <td>${item.id}</td><td>${item.name}</td><td>${item.courseTime}</td>
        <td>${item.location}</td><td>${item.occupied}/${item.capacity}</td>
        <td><a href="#" class="btn btn-primary btn-xs chooseClass" onclick="choose(${item.id})">选课</a></td>
    </tr>
    </c:forEach>
    </c:if>
    </tbody>
</table>
<script>
    function choose(id) {

    }
</script>