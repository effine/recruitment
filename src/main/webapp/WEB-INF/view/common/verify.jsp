<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>注册-邮箱发送后页面</title>
    <link href="/static/css/basic/reset.css" rel="stylesheet">
    <link href="/static/css/page/common/verify.css" rel="stylesheet">
    <script type="text/javascript">
    var YL = {};
    YL.BOOTSTAMP = new Date().getTime();
    YL.STATIC_ROOT = "/static";
    </script>
</head>

<body>
    <div id="bd">
        <div class="warp1200 reg-content " >
        	<div class="reg-head">
        	 	<h3 class="warp-comtag">注册公司<span class="reg-tip">注册成功后可发布招聘信息，面向全国大学生招聘优秀人才。</span></h3>	
        	</div>
        	<div class="reg-body">
        	    <div class="reg-tip-box">
	        		<div class="tip-head">
	        		   <p class="tip-con">验证邮件已发送至：effine@163.com</p>
                       <p class="tip-sub">请登录邮箱点击邮件内部的链接，验证后即可发布职位。</p>
	        		</div>
                    <div class="reg-tip-ques">
                        <dl>
                            <dt>没有收到确认邮件，怎么办？</dt>
                            <dd>1.邮箱地址填写错误？重新填写邮箱地址</dd>
                            <dd>2.看看是否在邮箱的垃圾邮件、广告邮件目录中</dd>
                            <dd>3.稍等几分钟，若还未收到验证邮件，重新发送验证邮件</dd>
                            <dd>4.还未收到验证邮件，请联系vivi@lagou.com，注明“未收到验证邮件”，我们会为你重新发送</dd>
                        </dl>
                    </div>
        		</div>
        	</div>
        </div>
    </div>
</body>
<script type="text/javascript" src="/static/js/lib/r.js" data-main="/static/js/page/server/common/verify.js"></script>
</html>

