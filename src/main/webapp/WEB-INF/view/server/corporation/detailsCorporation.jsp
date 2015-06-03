<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>注册-邮箱发送后页面</title>
    <link href="/static/css/basic/reset.css" rel="stylesheet">
    <link href="/static/css/page/server/corporation/detailsCorporation.css" rel="stylesheet">
    <script type="text/javascript">
    var YL = {};
    YL.BOOTSTAMP = new Date().getTime();
    YL.STATIC_ROOT = "/static";
    </script>
</head>

<body>
    <div id="bd">
        <div class="warp1200 cominfo-content " >
            <div class="cominfo-head">
                <h3>填写公司信息</h3> 
            </div>
            <div class="cominfo-body">
                 <div class="cominfo-guid clearfix">
                     <ul>
                         <li><a href="javascript:;" class="guid-item guid-base active" ></a></li>
                         <li><span class="guid-line active" ></span></li>
                         <li><a href="javascript:;" class="guid-item guid-tag active" ></a></li>
                         <li><span class="guid-line active" ></span></li>
                         <li><a href="javascript:;" class="guid-item guid-intro" ></a></li>
                     </ul>
                 </div>
                 <div class="form-box">
                     <h3 class="form-tip">北京深、规模大、发展快、氛围好。。。用优势吸引求职者吧！</h3>
                     <div class="form-con">
                        <div class="form-item">
                                <p class="form-tit">公司介绍　：</p>
                                <div class="form-ipt editor-container fixck">
                                    <script type="text/javascript" id="com-intro" style="width:100%;height:300px" ></script>
                                </div>
                        </div>
                        <p class="editor-tips">还可以输入<span>1000</span>字</p>
                        <button class="btn-next" id="J-intro-save">保存，完成</button>
                     </div>
                 </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript" src="/static/js/lib/r.js" data-main="/static/js/page/server/corporation/detailsCorporation.js"></script>
</html>

