<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>有效职位</title>
    <link rel="stylesheet" href="/static/css/basic/reset.css"/>
    <link rel="stylesheet" href="/static/css/page/server/job/downlineJob.css"/>
    <script type="text/javascript">
           var YL = {};
           YL.BOOTSTAMP = new Date().getTime();
           YL.STATIC_ROOT = "/static";
           YL.DOMAIN="http://124.192.148.3:8080";
    </script>
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
            <h1>已下线职位</h1>
            <div class="job-counts">(共&nbsp;<span>2</span>&nbsp;个)</div>
        </div>
        <ul class="job-lists">
            <li class="job-item odd">
                <ul class="job-details">
                    <li class="details1">
                        <h1 class="job-name">实习JAVA工程师<span>[北京]</span></h1>
                        <div class="job-numbers">应聘简历&nbsp;<span>(&nbsp;42&nbsp;)</span>&nbsp;</div>
                    </li>
                    <li class="details2">
                        <span class="type">实习</span>
                        <span class="salary">4K-6K</span>
                        <span class="experiences">学历不限</span>
                    </li>
                    <li class="details3">
                        <span class="refresh-time">刷新时间：2015-01-04</span>
                        <div class="operate">
                            <a class="opeate-item" href="javascript:;"><span class="icon-ale-refresh"></span>已刷新</a>
                            <a class="opeate-item" href="javascript:;"><span class="icon-editor"></span>编辑</a>
                            <a class="opeate-item" href="javascript:;"><span class="icon-downline"></span>下线</a>
                            <a class="opeate-item" href="javascript:;"><span class="icon-delete"></span>删除</a>
                        </div>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<script type="text/javascript" data-main="/static/js/server/job/effectJob" src="/static/js/lib/r.js"></script>
</body>
</html>