<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="row">
    <div class="col-md-8">
        <p class="alert alert-danger">请先补全身份信息, 带*号为必填项.</p>
        <form id="info_form">
            <div class="form-group">
                <label for="name">姓名<span class="text-muted">*</span></label>
                <c:choose>
                    <c:when test="${empty USER.name}">
                        <input type="text" name="name" id="name" placeholder="姓名" class="form-control">
                    </c:when>
                    <c:otherwise>
                        <input type="text" id="name" value="${USER.name}" readonly class="form-control">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="form-group">
                <label for="sex">性别<span class="text-muted">*</span></label>
                <c:choose>
                    <c:when test="${empty USER.sex}">
                        <<select name="sex" id="sex" class="form-control">
                        <option>男</option>
                        <option>女</option>
                        </select>
                    </c:when>
                    <c:otherwise>
                        <input type="text" id="sex" value="${USER.sex}" readonly class="form-control">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="form-group">
                <label for="idCard">身份证<span class="text-muted">*</span></label>
                <c:choose>
                    <c:when test="${empty USER.idNo}">
                        <input type="number" name="idNo" id="idCard" class="form-control">
                    </c:when>
                    <c:otherwise>
                        <input type="number" id="idCard" value="${USER.idNo}" readonly class="form-control">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="form-group">
                <label for="stuNumber">学号<span class="text-muted">*</span></label>
                <c:choose>
                    <c:when test="${empty USER.stuNo}">
                        <input type="number" name="stuNo" id="stuNumber" class="form-control">
                    </c:when>
                    <c:otherwise>
                        <input type="number" id="stuNumber" value="${USER.stuNo}" readonly class="form-control">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="form-group">
                <label for="grade">年级<span class="text-muted">*</span></label>
                <c:choose>
                    <c:when test="${empty USER.grade}">
                        <select name="grade" id="grade" class="form-control">
                            <option>2016</option>
                            <option>2015</option>
                            <option>2014</option>
                            <option>2013</option>
                            <option>2012</option>
                            <option>2017</option>
                            <option>2018</option>
                        </select>
                    </c:when>
                    <c:otherwise>
                        <input id="grade" value="${USER.grade}" readonly class="form-control">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="form-group">
                <label for="campus">校区<span class="text-muted">*</span></label>
                <c:choose>
                    <c:when test="${empty USER.campus}">
                        <select name="campus" id="campus" class="form-control">
                        <option>中心校区</option>
                        <option>兴隆山校区</option>
                        <option>趵突泉校区</option>
                        <option>千佛山校区</option>
                        <option>洪家楼校区</option>
                        <option>软件园校区</option>
                        <option>青岛校区</option>
                        </select>
                    </c:when>
                    <c:otherwise>
                        <input type="text" id="campus" value="${USER.campus}" readonly class="form-control">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="form-group">
                <label for="phoneNumber">手机<span class="text-muted">*</span></label>
                <c:choose>
                    <c:when test="${empty USER.phone}">
                        <input type="tel" name="phone" id="phoneNumber" class="form-control">
                    </c:when>
                    <c:otherwise>
                        <input type="tel" id="phoneNumber" value="${USER.phone}" readonly class="form-control">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="form-group">
                <label for="qqNumber">QQ</label>
                <c:choose>
                    <c:when test="${empty USER.qq}">
                        <input type="tel" name="qq" id="qqNumber" class="form-control">
                    </c:when>
                    <c:otherwise>
                        <input type="tel" id="qqNumber" value="${USER.qq}" readonly class="form-control">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="form-group">
                <label for="email">email</label>
                <c:choose>
                    <c:when test="${empty USER.email}">
                        <input type="email" name="email" id="email" class="form-control">
                    </c:when>
                    <c:otherwise>
                        <input type="email" id="email" value="${USER.email}" readonly class="form-control">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="row">
                <div class="col-md-2">
                </div>
                <div class="col-md-8">
                    <button class="btn btn-primary btn-lg btn-block">提交</button>
                    <input type="reset" class="btn btn-default btn-lg btn-block" value="重置">
                </div>
                <div class="col-md-2">
                </div>
            </div>
        </form>
    </div>
    <div class="col-md-4"></div>
</div>
