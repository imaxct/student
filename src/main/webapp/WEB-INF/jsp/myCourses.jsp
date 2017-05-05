<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: imaxct
  Date: 17-4-30
  Time: 上午10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<table class="table table-hover">
    <thead>
    <tr>
        <th>课程ID</th><th>课程名</th><th>上课时间</th><th>上课地点</th><th>选课情况</th>
        <th>选课时间</th><th>详情</th><th>退课</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty list}">
        <c:forEach var="item" items="${list}">
            <tr>
                <td>${item.id.course.id}</td><td>${item.id.course.name}</td><td>${item.id.course.courseTime}</td>
                <td>${item.id.course.location}</td><td>${item.id.course.occupied}/${item.id.course.capacity}</td>
                <td>${item.selectDate}</td>
                <td><a class="popover_url" href="#" data-container="body" data-toggle="popover" data-placement="bottom"
                       title="详情 - 震惊,所有选课的人都看了!" data-content="${item.id.course.description}">详情,必看!</a></td>
                <td><a href="#" class="btn btn-primary btn-xs chooseClass" onclick="preSelect(${item.id.course.id})">退课</a></td>
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
            <div class="modal-body"><p>确认删除本课?</p></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" id="chooseBtn2" class="btn btn-primary">确认</button>
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
        .on('click', '#chooseBtn2', function () {
            $('#chooseBtn2').attr('disabled', 'disabled');
            $.post('/student/C/delete', {id: classId}, 'json')
                .always(function () {
                    $('#chooseBtn2').removeAttr('disabled');
                    $('#myModal').modal('hide');
                })
                .done(function (res) {
                    if (!res) { return;}
                    if (res.code !== 0){
                        myAlert(res.msg);
                    }else {
                        myAlert(res.msg);
                    }
                })
                .fail(function () {
                    myAlert('网络错误');
                });
        });
</script>