<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: imaxct
  Date: 17-5-3
  Time: 下午4:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="col-md-8">
<form id="cForm">
    <div class="form-group">
        <label for="name">课程名</label>
        <input id="name" class="form-control" name="name" placeholder="">
        <p class="help-block">课程名(最好标注可报名学生身份)</p>
    </div>
    <div class="form-group">
        <label for="location">上课地点(校区)</label>
        <input class="form-control" list="location" name="location" id="loc">
        <datalist id="location">
            <option>中心校区</option>
            <option>兴隆山校区</option>
            <option>洪家楼校区</option>
            <option>软件园校区</option>
            <option>趵突泉校区</option>
            <option>千佛山校区</option>
            <option>青岛校区</option>
        </datalist>
        <p class="help-block">可选择已有选项, 若有多个校区可手动填写.</p>
    </div>
    <div class="form-group">
        <label for="restrict">学生身份限制</label>
        <select name="restrict" id="restrict" class="form-control">
            <option value="0">无限制</option>
            <option value="1">仅贫困生</option>
            <option value="-1">仅非贫困生</option>
        </select>
    </div>
    <div class="form-group">
        <label for="courseTime">上课时间</label>
        <input class="form-control" name="courseTime" id="courseTime" placeholder="">
        <p class="help-block">第几周 下午 晚上等信息...</p>
    </div>
    <div class="form-group">
        <label for="capacity">课程容量</label>
        <input name="capacity" id="capacity" type="number" class="form-control">
    </div>
    <div class="form-group">
        <label for="gradeLimit">年级限制</label>
        <input id="gradeLimit" class="form-control" name="gradeLimit" type="text" placeholder="年级限制, 填写数字">
        <p class="help-block">单个年级只填一个即可,如<code>2015</code>. 若有多个年级,用空格隔开,如<code>2013 2014 2015</code></p>
    </div>
    <div class="form-group">
        <label for="endDate">报名截止时间</label>
        <input id="endDate" name="endDate" class="form-control" type="datetime-local">
        <p class="help-block">超过这个时间后无法选择或退选当前课程</p>
        <p class="alert-danger">火狐浏览器 IE12及之前版本的浏览器不支持日期选择插件,请使用谷歌浏览器或谷歌内核的浏览器.</p>
    </div>
    <div class="form-group">
        <label for="intro">课程介绍</label>
        <textarea id="intro" rows="10" name="description"></textarea>
    </div>
    <a id="sub" class="btn btn-primary form-control" href="#">提交</a>
</form>
</div>
<script>
    <c:if test="${not empty course}">
    var name = '${course.name}',
        lo = '${course.location}',
        restrict = '${course.restrict}',
        courseTime = '${course.courseTime}',
        capacity = '${course.capacity}',
        gradeLimit = '${course.gradeLimit}',
        endDate = '${course.endDate}';
    var id = ${course.id};
    $('#name').val(name);
    $('#loc').val(lo);
    $('#restrict').val(restrict);
    $('#courseTime').val(courseTime);
    $('#capacity').val(capacity);
    $('#gradeLimit').val(gradeLimit);
    $('#endDate').val(endDate);
    $('#intro').val('${course.description}');
    </c:if>
    $('#sub').click(function () {
        var data = {
            name: $('#name').val(),
            location: $('#loc').val(),
            restrict: $('#restrict').val(),
            courseTime: $('#courseTime').val(),
            capacity: $('#capacity').val(),
            gradeLimit: $('#gradeLimit').val(),
            endDate: $('#endDate').val(),
            description: $('#intro').val()
        };
        if (id){
            data.id = id;
        }
        $.post('editor', data , 'json')
            .done(function (res) {
                if (res.code === 0){
                    alert('添加成功.');
                    window.location.reload();
                }else alert(res.msg);
            });
    });
</script>
