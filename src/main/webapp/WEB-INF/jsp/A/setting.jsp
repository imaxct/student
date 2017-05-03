<%--
  Created by IntelliJ IDEA.
  User: imaxct
  Date: 17-5-2
  Time: 下午2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="row">
<form class="form-inline">
    <div class="form-group">
        <label for="open">当前状态: ${opening eq '1' ? '开启' : '关闭'}</label>
        <select id="open" class="form-control">
            <option value="1">开启</option>
            <option value="0">关闭</option>
        </select>
        <a href="#" class="btn btn-primary" id="sub_open">提交</a>
    </div>
</form>
</div>
<div class="row">
<form class="form-inline">
    <div class="form-group">
        <label for="dec">编辑公告</label>
        <textarea class="form-control" id="dec">${declare}</textarea>
        <a href="#" class="btn btn-primary" id="sub_declare">提交</a>
    </div>
</form>
</div>
<script>
    $('#sub_open').click(function () {
        $.post('setting', {key: 'opening', value: $('#open').val()}, 'json')
            .done(function (res) {
                if (res.code === 0){
                    alert('更新成功, 刷新页面可查看.')
                }else{
                    alert(res.msg)
                }
            });
    });
    $('#sub_declare').click(function () {
        $.post('setting', {key: 'declare', value: $('#dec').val()}, 'json')
            .done(function (res) {
                if (res.code === 0){
                    alert('更新成功, 刷新页面可查看.')
                }else{
                    alert(res.msg)
                }
            });
    });
</script>