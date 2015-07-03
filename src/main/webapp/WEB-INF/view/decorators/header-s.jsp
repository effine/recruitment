<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="cn.effine.utils.Constants"%>
<c:set var="ftp" value="<%=Constants.FTP_DOMAIN %>"></c:set>
<div id="hd" class="pr hd" data-platform="yl_s">
	<a href="/lms"  target="_self" class="pa logo1" ><img <c:if test="${index =='index'}"> src="/static/images/logo/logo01.png" </c:if> <c:if test="${empty index}"> src="/static/images/logo/logo01-2.png"  </c:if>  alt="爱云路" /></a>
		 <c:if test="${not empty user}">
  			  <ul class="fr pr logonav notindex">
  			 	<li> 
					<a href="/lms/course/list" class="J_allCourse hd-a" target="_self"> 
					   全部课程
					</a> 
				</li> 
				<li>
				    <a href="/jobAction/jobList" class="J_allJob hd-a" target="_self">
						实习岗位
					</a>
				</li>
				<li> 
				    <a href="/lms/learningCenter/individualCenter"  target="_self" id="J_study_center" class="J_stuCenter hd-a"> 
				  	   学习中心
				    </a> 
				</li> 
				<li class="login-out pr"> 
				    <a href="/cmn/user/toStudentProfile" class="pr nav-pimg hd-a" target="_self"  id="J_login3"> 
			           <img  src="<c:if test="${myavatar!=null }">${ftp}${myavatar }</c:if> <c:if test="${myavatar==null }">/static/images/defaultphoto.jpg</c:if>" width="50" height="50" class="pa rd" alt="" />
				    </a> 
			        <div class="logdiv-item hide">
			           <a href="javascript:;"    class="logitem btn-logout"  lang="btn-logout" out-type="student" ></a>
			        </div>
				</li>  
   			 </ul>
		</c:if>     
		
		<c:if test="${empty user}">
		     <ul class="fr pr logonav">
				<li> 
					<a href="/lms/course/list" class="J_allCourse hd-a"  target="_self"> 
					   全部课程
					</a> 
				</li> 
				<li>
				    <a href="/jobAction/jobList" class="J_allJob hd-a" target="_self">
						实习岗位
					</a>
				</li>
				<li><a href="javascript:;" id="J_login"  class="hd-a">登陆</a></li>
				<li><a href="/cmn/user/toRegStu" target="_blank" class="J_regg hd-a">注册</a></li>
    		</ul>
		</c:if>
</div>
<input type="hidden" id="J-login-type" value="student"/> 




