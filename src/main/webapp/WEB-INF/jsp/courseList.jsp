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
        <th>课程ID</th><th>课程名</th><th>年级限制</th><th>上课时间</th><th>上课地点</th><th>选课情况</th>
        <th>报名截止时间</th><th>详情</th><th>选课</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty list}">
    <c:forEach var="item" items="${list}">
    <tr>
        <td>${item.id}</td><td>${item.name}</td><td>${empty item.gradeLimit ? '无' : item.gradeLimit}</td><td>${item.courseTime}</td>
        <td>${item.location}</td><td>${item.occupied}/${item.capacity}</td><td>${empty item.endDate ? '无' : item.endDate}</td>
        <td><a class="popover_url" href="#" data-container="body" data-toggle="popover"
               data-placement="bottom" title="详情 - 震惊,所有选课的人都看了!" data-content="${item.description}">详情,必看!</a></td>
        <td><a href="#" class="btn btn-primary btn-xs chooseClass" onclick="preSelect(${item.id})">选课</a></td>
    </tr>
    </c:forEach>
    </c:if>
    </tbody>
</table>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="m1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h5 class="modal-title" id="m1">提示</h5>
            </div>
            <div class="modal-body"><p>确认选择本课?</p></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" id="chooseBtn" class="btn btn-primary">确认</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="alertModal" tabindex="-1" role="dialog" aria-labelledby="label2">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h5 class="modal-title" id="label2">提示</h5>
            </div>
            <div class="modal-body"><p id="alert-msg"></p></div>
            <div class="modal-footer"><button type="button" class="btn btn-primary" data-dismiss="modal">确认</button></div>
        </div>
    </div>
</div>
<script>
    var classId = -1;
    $('.popover_url').popover();
    function preSelect(id) {
        classId = id;
        $('#myModal').modal();
    }
    function myAlert(msg) {
        $('#alert-msg').html(msg);
        $('#alertModal').modal();
    }
    $('#myModal').on('hide.bs.modal', function () {
        classId = -1;
    });
    $(document)
        .on('click', '#chooseBtn', function () {
            $('#chooseBtn').attr('disabled', 'disabled');
            $.post('/student/C/choose', {id: classId}, 'json')
                .always(function () {
                    $('#chooseBtn').removeAttr('disabled');
                    $('#myModal').modal('hide');
                })
                .done(function (res) {
                    if (!res) { return;}
                    if (res.code !== 0){
                        myAlert(res.msg);
                    }else {
                        myAlert('选课成功');
                    }
                })
                .fail(function () {
                    myAlert('网络错误');
                });
        });
</script>