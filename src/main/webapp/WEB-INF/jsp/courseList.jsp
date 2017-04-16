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
        <th>课程号</th><th>课程名</th><th>学分</th><th>课程属性</th><th>任课教师</th>
        <th>上课周次</th><th>上课星期</th><th>上课节次</th><th>选课情况</th><th>上课地点</th>
        <th>选课</th>
    </tr>
    </thead>
    <tbody>
<c:forEach var="item" items="${list}">
    <tr>
        <td>${item.cid}</td><td>${item.name}</td><td>${item.credit}</td>
        <td>${item.property}</td><td>${item.teacher.name}</td><td>${item.week}</td><td>${item.dayOrder}</td>
        <td>${item.courseOrder}</td><td>${item.total}/${item.capacity}</td><td>${item.location}</td>
        <td><a href="#" class="btn btn-primary btn-xs chooseClass" data-toggle="${item.id}">选课</a></td>
    </tr>
</c:forEach>
    </tbody>
</table>