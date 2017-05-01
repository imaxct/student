<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: imaxct
  Date: 17-4-30
  Time: 下午10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<form id="b">
    <div class="form-group">
        <label for="stuNo">学号</label>
        <select id="stuNo" name="stuNo" class="form-control"></select>
    </div>
    <div class="form-group">
        <label for="sex">性别</label>
        <select id="sex" name="sex" class="form-control"></select>
    </div>
    <div class="form-group">
        <label for="name">姓名</label>
        <select id="name" name="name" class="form-control"></select>
    </div>
    <div class="form-group">
        <label for="idNo">身份证</label>
        <select id="idNo" name="idNo" class="form-control"></select>
    </div>
    <div class="form-group">
        <label for="grade">年级</label>
        <select id="grade" name="grade" class="form-control"></select>
    </div>
    <button class="btn btn-primary" id="submit">开始导入</button>
</form>
<div id="progress" class="progress" style="display: none; width: 100%">
    <div class="progress-bar progress-bar-success"></div>
</div>
<script>
    var ops = '<c:forEach var="item" items="${list}"><option value="${item.key}">${item.value}</option></c:forEach>';
    $('select').html(ops);
    $('#submit').click(function () {
        $('#submit').attr('disabled', 'disabled');
        $('#progress').show().addClass('active');
        $.post('doIn', $('#b').serialize(), 'json')
            .done(function (res) {
                $('#submit').removeAttr('disabled');
                $('#progress').removeClass('active').hide();
                if (res.code === 0){
                    alert('导入成功.')
                }else {
                    alert('导入失败.');
                }
            });
    });
</script>