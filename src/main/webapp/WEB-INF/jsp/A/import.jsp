<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: imaxct
  Date: 17-4-30
  Time: 下午10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<select>

</select>

<script>
    var ops = '<c:forEach var="item" items="${list}"><option value="${item.key}">${item.value}</option></c:forEach>';
    $('select').html(ops);
</script>