<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>注册-创建公司名</title>
    <link href="/static/css/basic/reset.css" rel="stylesheet">
    <link href="/static/css/page/server/corporation/buildCorporation.css" rel="stylesheet">
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
        	    <div class="reg-com-box">
	        		<div class="reg-com-name">
	        			<p class="reg-com-ipt"><label>公司全称:</label><input type="text" name="" class="ipt" placeholder="请输入公司全称"/></p>
	        			<p class="com-name-tip">（请输入与公司营业执照一致的公司全称，审核通过后不可更改）</p>
	        			<button class="btn-next">下一步</button>
	        		</div>
        		</div>
        	</div>
        </div>
    </div>
</body>
<script type="text/javascript" src="/static/js/lib/r.js" data-main="/static/js/page/server/corporation/buildCorporation.js"></script>
</html>

