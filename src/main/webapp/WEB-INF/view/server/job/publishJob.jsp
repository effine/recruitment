<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 	<title>发布新职位</title>
 	
     <c:set value='server/job/publishJob' var="cssUrl" scope="request"></c:set>
	 <c:set value='server/job/publishJob' var="jsUrl" scope="request"></c:set> 
</head>
<body>
	<div id="wrapper">
    <!--导航-->
    <div class="left-nav">
        <div class="btn-publish">
            <span class="icon"></span>
            <a href="javascript:;">发布新职位</a>
        </div>
        <ul class="nav-list">
            <li class="nav-title">
                <span>我收到的简历</span>
            </li>
            <li class="nav-item nav-item-current"><a href="javascript:;">待处理简历</a></li>
            <li class="nav-item"><a href="javascript:;">已安排面试</a></li>
            <li class="nav-item"><a href="javascript:;">不合适简历</a></li>
            <li class="nav-title">
                <span>我发布的职位</span>
            </li>
            <li class="nav-item"><a href="javascript:;">有效职位</a></li>
            <li class="nav-item"><a href="javascript:;">已下线职位</a></li>
        </ul>
    </div>
    <!--内容-->
    <div class="content">
        <div class="publish-header">
            <h1>发布新职位</h1>
            <div class="header-msg">
                <span class="leave-jobs">还可以发布<span>5</span>个职位</span>
                <span class="has-published">今日已发布<span>0</span>个职位</span>
            </div>
        </div>
        <!--part1-->
        <ul class="part">
            <li class="part-item">
                <span class="need">*</span><span class="title">职位类别</span>
                <select name="job" class="input-section">
                    <option value="0">请选择职位</option>
                </select>
            </li>
            <li class="part-item">
                <span class="need">*</span><span class="title">职位名称</span>
                <input name="job" class="input-section" placeholder="请输入职位名称 如产品经理">
            </li>
            <li class="part-item">
                <span class="need">&nbsp;</span><span class="title">所属部门</span>
                <input name="job" class="input-section" placeholder="请输入所属部门">
            </li>
        </ul>
        <!--part2-->
        <ul class="part">
            <li class="part-item">
                <span class="need">*</span><span class="title">工作性质</span>
                <a class="work-type" href="javascript:;">
                    <input type="hidden"/>
                    全职
                </a>
                <a class="work-type part-time-job" href="javascript:;">
                    <input type="hidden"/>
                    实习
                </a>
            </li>
            <li class="part-item">
                <span class="need">*</span><span class="title">月薪范围</span>
                <input name="job" class="input-salary input-section" placeholder="最低月薪">
                <span class="separate"></span>
                <input name="job" class="input-salary input-high-salary input-section" placeholder="最高月薪">
            </li>
            <li class="part-item">
                <span class="need">*</span><span class="title">工作城市</span>
                <input name="job" class="input-section input-salary" placeholder="北京">
            </li>
        </ul>
        <!--part3-->
        <ul class="part">
            <li class="part-item">
                <span class="need">*</span><span class="title">学历要求</span>
                <select name="job" class="input-section">
                    <option value="0">请选择学历要求</option>
                </select>
            </li>
        </ul>
        <!--part4-->
        <ul class="part">
            <li class="part-item">
                <span class="need">*</span><span class="title">职位诱惑</span>
                <input name="job" class="input-section job-describe" placeholder="20字描述改职位的吸引力 如：福利待遇，发展前景">
            </li>
            <li class="part-item">
                <span class="need">*</span><span class="title">职位描述</span>
                <span>（建议分条描述工作职责等。请勿输入公司邮箱、电话以及其他外链，否则将自动删除）</span>
            </li>
            <li class="part-item">
                <span class="need">&nbsp;</span>
                <span class="title">&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <div class="editor">
                </div>
                <input name="job" class="input-section job-describe" placeholder="北京市安定路12号">
            </li>
             <li class="part-item">
                <span class="need">*</span><span class="title">工作地址</span>
                <input name="job" class="input-section job-describe" placeholder="北京市安定路12号">
            </li>
        </ul>
        <div class="submit-buttons">
            <a href="javascript:;">预览</a>
            <a href="javascript:;">发布</a>
        </div>
    </div>
</div>
<script type="text/javascript" data-main="/static/js/server/job/publishJob" src="/static/js/lib/r.js"></script>
</body>
</html>