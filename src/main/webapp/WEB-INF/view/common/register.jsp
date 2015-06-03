<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>注册-学生</title>
<link href="/static/css/basic/reset.css" rel="stylesheet">
<link href="/static/css/page/common/register.css" rel="stylesheet">
<script type="text/javascript">
         var YL = {};
         YL.BOOTSTAMP = new Date().getTime();
         YL.STATIC_ROOT = "/static";
</script>
</head>
<body>
     <div id="bd">
        <div class="warp1200 reg-content">
        	<div class="reg-head">
        	 	<h3>欢迎注册云路<span class="reg-tip">注册之后可以访问现有和将来所有免费课程</span></h3>	
        	</div>
			<div class="reg-body">
				<div class="reg-tabs">
					<ul>
						<li><a href="javascript:;" class="stu active" data-form="stu">学生账号</a></li>
						<li><a href="javascript:;" class="tea" data-form="tea">教师账号</a></li>
						<li><a href="javascript:;" class="com" data-form="com">企业账号</a></li>
					</ul>
				</div>
				<div class="reg-forms ">
				  <div class="reg-form-item clearfix" id="reg-stu">
				  	   <div class="reg-l" >
				  	   	   <form class="reg-form" action="">
				  	   	   	   <p class="form-item"><label for="email">电子邮件<i>*</i></label><input class="ipt" type="text" name="" sucmsg="" datatype="e" nullmsg="请输入邮箱！" errormsg="请入正确的邮箱！"/></p>
				  	   	   	   <p class="tips"></p>
				  	   	   	   <p class="form-item"><label for="pasw">密码　　<i>*</i></label><input class="ipt" type="password" name="password"   sucmsg="" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！"/></p>
				  	   	   	   <p class="tips"></p>
				  	   	   	   <p class="form-item"><label for="repasw">确认密码<i>*</i></label><input class="ipt" type="password" name="repassword"  sucmsg="" datatype="*6-16"  recheck="password" nullmsg="请再输入一次密码！" errormsg="您两次输入的密码不一致！"/></p>
				  	   	   	   <p class="tips"></p>
				  	   	   	   <div class="reg-arg-box">
				  	   	   	   		<i class="reg-radio active"></i><span class="reg-arg">同意</span><a href="register-tk.html" target="_blank" class="reg-tk">服务条款</a>
				  	   	   	   		<p class="isagr"></p>
				  	   	   	   	</div>
				  	   	   	   <button class="btn-reg">注册我的云路账号</button>
				  	   	   </form>
				  	   </div>
				  	   <div class="reg-r">
				  	   	  <dl>
				  	   	    <dt></dt>
				  	   	  	<dd>加入 云路 的过程中，您将会收到一封激活邮件。您必须点击激活链接才能完成注册过程。如果没有看见邮件请检查垃圾邮件夹并把来自云路的邮件标记为"非垃圾文件"。在云路，我们主要通过电子邮件联系。</dd>
				  	   	  </dl>
				  	   	  <div class="reg-login">
				  	   	       <p class="reg-sure">已注册?</p>
				  	   	  	   <button  class="btn-login">登录</button>
				  	   	  </div>
				  	   </div>
				  </div>
				  <div class="reg-form-item clearfix hide" id="reg-tea">
				  	<div class="reg-l" >
				  	   	   <form  class="reg-form" action="">
				  	   	   	   <p class="form-item"><label for="email">电子邮件<i>*</i></label><input class="ipt" type="text" name=""  sucmsg="" datatype="e" nullmsg="请输入邮箱！" errormsg="请入正确的邮箱！"/></p>
				  	   	   	   <p class="tips "></p>
				  	   	   	   <p class="form-item"><label for="pasw">密码　　<i>*</i></label><input class="ipt" type="password" name=""   sucmsg="" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！"/></p>
				  	   	   	   <p class="tips"></p>
				  	   	   	   <p class="form-item"><label for="repasw">确认密码<i>*</i></label><input class="ipt" type="repassword" name=""  sucmsg="" datatype="*6-16"  recheck="password" nullmsg="请再输入一次密码！" errormsg="您两次输入的密码不一致！"/></p>
				  	   	   	   <p class="tips"></p>
				  	   	   	   <p class="form-item"><label for="repasw">真实姓名<i>*</i></label><input class="ipt" type="text" name="" sucmsg="" datatype="*6-16" nullmsg="请输入您的真实姓名！" errormsg="姓名在6~16位之间！"/></p>
				  	   	   	   <p class="tips"></p>
				  	   	   	   <p class="form-item"><label for="repasw">联系方式<i>*</i></label><input class="ipt" type="text" name="" sucmsg="" datatype="m-t" nullmsg="请输入联系方式！" errormsg="请输入正确的联系方式"/></p>
				  	   	   	   <p class="tips"></p>
				  	   	   	   <p class="form-item"><label for="repasw">工作单位<i>*</i></label><input class="ipt" type="text" name="" sucmsg="" datatype="*2-20" nullmsg="请输入您所在单位！" errormsg="最多20个字符！"/></p>
				  	   	   	   <p class="tips"></p>
				  	   	   	   <div class="reg-arg-box">
				  	   	   	  		 <i class="reg-radio active"></i><span class="reg-arg">同意</span><a href="register-tk.html" target="_blank" class="reg-tk">服务条款</a>
				  	   	   	  		 <p class="isagr"></p>
				  	   	   	   </div>
				  	   	   	   <button class="btn-reg">注册我的云路账号</button>
				  	   	   </form>
				  	   </div>
				  	   <div class="reg-r">
				  	   	  <dl>
				  	   	    <dt></dt>
				  	   	  	<dd>加入 云路 的过程中，您将会收到一封激活邮件。您必须点击激活链接才能完成注册过程。如果没有看见邮件请检查垃圾邮件夹并把来自云路的邮件标记为"非垃圾文件"。在云路，我们主要通过电子邮件联系。</dd>
				  	   	  </dl>
				  	   	  <div class="reg-login">
				  	   	       <p class="reg-sure">已注册?</p>
				  	   	  	   <button  class="btn-login">登录</button>
				  	   	  </div>
				  	   </div>

				  </div>
				  <div class="reg-form-item clearfix hide" id="reg-com">
				  	<div class="reg-l" >
				  	   	   <form class="reg-form" action="">
				  	   	   	   <p class="form-item"><label for="email">联系电话<i>*</i></label><input class="ipt" type="text" name="" sucmsg="" datatype="m-t" nullmsg="请输入联系方式！" errormsg="请输入正确的联系方式"/></p>
				  	   	   	   <p class="tips"></p>
				  	   	   	   <p class="form-item"><label for="pasw">邮件地址<i>*</i></label><input class="ipt" type="text" name="" sucmsg="" datatype="e" nullmsg="请输入邮箱！" errormsg="请入正确的邮箱！"/></p>
				  	   	   	   <p class="tips"></p>
				  	   	   	   <p class="form-item"><label for="repasw">密码  <i>*</i></label><input class="ipt" type="password" name="" sucmsg="" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！"/></p>
				  	   	   	   <p class="tips"></p>
				  	   	   	   <p class="form-item"><label for="repasw">确认密码<i>*</i></label><input class="ipt" type="repassword" name="" sucmsg="" datatype="*6-16"  recheck="password" nullmsg="请再输入一次密码！" errormsg="您两次输入的密码不一致！"/></p>
				  	   	   	   <p class="tips"></p>
				  	   	   	   <div class="reg-arg-box">
				  	   	   	   		<i class="reg-radio active"></i><span class="reg-arg">同意</span><a href="register-tk.html" target="_blank" class="reg-tk">服务条款</a>
									<p class="isagr"></p>
				  	   	   	   	</div>
				  	   	   	   <button class="btn-reg">注册我的云路账号</button>
				  	   	   </form>
				  	   </div>
				  	   <div class="reg-r">
				  	   	  <dl> 
				  	   	    <dt>常见问题</dt>
				  	   	  	<dd>
				  	   	  		<p class="normal-ques">问：填写个人邮箱可以么？</p>
				  	   	  		<p class="ques-answer">不可以。为了保证每个职位的真实性，拉勾网严格要
									求招聘方必须提供公司邮箱。（公司邮箱是指以你的公司
									网址为后缀的免费公司邮箱，例如拉勾网的公司邮箱后缀
									是@lagou.com）即使是初创公司也必须提供公司邮箱才允
									许开通招聘。
								</p>

				  	   	  	</dd>
				  	   	  	<dd>
				  	   	  		<p class="normal-ques">问：没有企业邮箱怎么办？</p>
				  	   	  		<p class="ques-answer">答：目前主流企业邮箱服务商都提供免费版产品，你可以
									选择常用的腾讯企业邮、网易企业邮、263企业邮等。在官
									网上登记资料后，很快有服务人员联系。
								</p>

				  	   	  	</dd>
				  	   	  </dl>
				  	   	  <div class="reg-login">
				  	   	       <p class="reg-sure">已注册?</p>
				  	   	  	   <button  class="btn-login">登录</button>
				  	   	  </div>
				  	   </div>

				  </div>
				</div>
			</div>
        </div>
     </div>
</body>
<script type="text/javascript" src="/static/js/lib/r.js" data-main="/static/js/page/common/register.js"></script>
</html>