<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>注册-邮箱发送后页面</title>
    <link href="/static/css/basic/reset.css" rel="stylesheet">
    <link href="/static/css/page/server/corporation/labelCorporation.css" rel="stylesheet">
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
                         <li><span class="guid-line " ></span></li>
                         <li><a href="javascript:;" class="guid-item guid-intro" ></a></li>
                     </ul>
                 </div>
                 <div class="form-box">
                     <h3 class="form-tip">基本信息为必填项，是求职者加速了解公司的窗口，认真填写吧~</h3>
                     <div class="form-con">
                         <div class="form-item com-tags clearfix">
                              <p class="com-tags-own">已添加公司便签</p>
                              <div class="tags-ul com-tags-ul">
                                  <p class="com-tags-tips">请填写自定义标签或者点选系统标签构建公司标签</p>
                                  <ul></ul>
                              </div>
                         </div>
                         <p class="form-item"><label>自定义标签　：</label><input type="text" name=""  class="ipt" id="J-tag-paste" placeholder="请输入自定义标签（6字内）"  autofocus="autofocus"/><a href="javascript:;" class="btn-paste">粘上</a><span class="tips"></span></p>
                         <div class="form-item sys-tags clearfix">
                            <label>系统标签　　：</label>
                            <div class="tags-ul sys-tags-ul">
                                  <ul>
                                      <li><a class="tag"><span class="tag-tit">毕业转正1</span><em></em></a></li>
                                      <li><a class="tag"><span class="tag-tit">毕业转正2</span><em></em></a></li>
                                      <li><a class="tag"><span class="tag-tit">毕业转正3</span><em></em></a></li>
                                      <li><a class="tag"><span class="tag-tit">毕业转正4</span><em></em></a></li>
                                      <li><a class="tag"><span class="tag-tit">毕业转正5</span><em></em></a></li>
                                      <li><a class="tag"><span class="tag-tit">毕业转正6</span><em></em></a></li>
                                      <li><a class="tag"><span class="tag-tit">毕业转正7</span><em></em></a></li>
                                      <li><a class="tag"><span class="tag-tit">毕业转正8</span><em></em></a></li>
                                      <li><a class="tag"><span class="tag-tit">毕业转正9</span><em></em></a></li>
                                      <li><a class="tag"><span class="tag-tit">毕业转正10</span><em></em></a></li>
                                      <li><a class="tag"><span class="tag-tit">毕业转正11</span><em></em></a></li>
                                      <li><a class="tag"><span class="tag-tit">毕业转正12</span><em></em></a></li>
                                  </ul>
                              </div>
                         </div>

                     </div>
                     <div class="btn-next-box"><button class="btn-next">下一步</button><a href="###" >跳过，下一步</a></div>
                 </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript" src="/static/js/lib/r.js" data-main="/static/js/page/server/corporation/labelCorporation.js"></script>
</html>

