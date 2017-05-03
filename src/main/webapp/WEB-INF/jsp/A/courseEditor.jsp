<%--
  Created by IntelliJ IDEA.
  User: imaxct
  Date: 17-5-3
  Time: 下午4:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<form id="cForm">
    <div class="form-group">
        <label for="name">课程名</label>
        <input id="name" class="form-control" name="name" placeholder="课程名(最好标注可报名学生身份)">
    </div>
    <div class="form-group">
        <label for="location">上课地点(校区)</label>
        <input class="form-control" list="location" name="location">
        <datalist id="location">
            <option>中心校区</option>
            <option>兴隆山校区</option>
            <option>洪家楼校区</option>
            <option>软件园校区</option>
            <option>趵突泉校区</option>
            <option>千佛山校区</option>
            <option>青岛校区</option>
        </datalist>
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
        <input class="form-control" name="courseTime" id="courseTime" placeholder="第几周 下午 晚上等信息...">
    </div>
    <div class="form-group">
        <label for="capacity">课程容量</label>
        <input name="capacity" id="capacity" type="number" class="form-control">
    </div>
    <div class="form-group">
        <label for="gradeLimit">年级限制</label>
        <input id="gradeLimit" name="gradeLimit" type="text" placeholder="如2015, 若有多个年级,用空格隔开">
    </div>
    <div class="form-group">
        <label for="endDate">报名截止时间</label>
        <input id="endDate" name="endDate" class="form-control" type="datetime">
        <p class="help-block">超过这个时间后无法选择或退选当前课程</p>
    </div>
</form>
<script>
    var flag = ${empty course ? 'false' : 'true'};
    if (flag){

    }
</script>
