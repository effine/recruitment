<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>注册-邮箱发送后页面</title>
    <link href="/static/css/basic/reset.css" rel="stylesheet">
    <link href="/static/css/page/server/corporation/maintainCorporation.css" rel="stylesheet">
    <script type="text/javascript">
    var YL = {};
    YL.BOOTSTAMP = new Date().getTime();
    YL.STATIC_ROOT = "static";
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
                         <li><a href="javascript:;" class="guid-item guid-tag" ></a></li>
                         <li><span class="guid-line " ></span></li>
                         <li><a href="javascript:;" class="guid-item guid-intro" ></a></li>
                     </ul>
                 </div>
                 <div class="form-box">
                     <h3 class="form-tip">基本信息为必填项，是求职者加速了解公司的窗口，认真填写吧~</h3>
                     <form class="form-base" action="">
                         <div class="form-con">
                             <p class="form-item"><label>公司全称　：</label><span class="com-name">爱云路</span></p>
                             <p class="form-item"><label>公司简称　：</label><input type="text" name=""  class="ipt"  placeholder="请输入公司简称"  sucmsg="" datatype="*1-16" nullmsg="请输入公司简称！" errormsg="公司简称小于16个字符！"/><span class="tips"></span></p>
                             <div class="form-item upload-pic clearfix">
                                     <label>公司LOGO：</label>
                                     <div class="upload-pic-box">
                                         <input type="file" type="file" name="file" id="J-pic-ipt" style="display:none;" />
                                         <img src="/static/images/logo/com-default.png"  id="J-pic-face"/>
                                         <a  href="javascript:;" class="btn-upload-pic"  data-file="J-pic-ipt" data-preview="J-pic-face" id="J-btn-upload-pic">上传公司Logo文件</a>
                                     </div>
                                     <span class="tips"></span>
                             </div>
                             <p class="form-item"><label>公司网址　：</label><input type="text" name=""  class="ipt" placeholder="请输入公司网址" sucmsg="" datatype="*1-16" nullmsg="请输入公司网址，如：www.effine.cn" errormsg="请输入公司网址，如：www.effine.cn"/><span class="tips"></span></p>
                             <p class="form-item"><label>所在城市　：</label><input type="text" name=""  class="ipt" placeholder="请输入所在地" sucmsg="" datatype="*1-16" nullmsg="请输入公司所在城市，如：北京" errormsg="公司简称小于16个字符！"/><span class="tips"></span></p>
                             <p class="form-item"><label>行业领域　：</label><input type="text" name=""  class="ipt" placeholder="请输入公司业务领域" sucmsg="" datatype="*1-16" nullmsg="请输入公司业务领域，如：系统集成" errormsg="公司简称小于16个字符！"/><span class="tips"></span></p>
                             <p class="form-item">
                                <label>公司规模　：</label>
                                <select name="" >
                                    <option value="0">15人一下</option>
                                    <option value="1">15人一下</option>
                                    <option value="2">15人一下</option>
                                    <option value="3">15人一下</option>
                                </select>
                             </p>
                             <p class="form-item"><label>一句话介绍：</label><input type="text" name=""  class="ipt" placeholder="一句话描述公司优势，核心价值，50字以内" sucmsg="" datatype="*1-16" nullmsg="请输入5-50字的一句话介绍" errormsg="公司简称小于16个字符！" /><span class="tips"></span></p>
                         </div>
                         <button class="btn-next">下一步</button>
                      </form>
                 </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript" src="/static/js/lib/r.js" data-main="/static/js/page/server/corporation/maintainCorporation.js"></script>
</html>

