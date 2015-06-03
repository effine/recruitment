<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="cn.effine.enterprise.utils.cn.effine.utils.Constants"%>
<c:set var="ftp" value="<%=Constants.FTP_DOMAIN %>" scope="request"></c:set>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
  <head>
    <c:choose>
	   <c:when test="${requestScope.title!=null}">  
	   		   <title>${requestScope.title}</title>
	   </c:when>
	   <c:otherwise> 
	   		   <title>云路在线课堂</title>
	   </c:otherwise>
    </c:choose>
    <meta http-equiv="content-type" CONTENT="text/html; charset=utf-8">
    
    <%--
       SEO  meta 设置
     --%>
     <c:choose>
	   <c:when test="${not empty sessionScope.deployinfo.sys_meta_keyword}">  
	   		<meta name="keywords" content="${sessionScope.deployinfo.sys_meta_keyword}">
	   </c:when>
	   <c:otherwise> 
	  	    <meta name="keywords" content="mooc,在线教育,JAVA培训,CCNA培训,Android培训">
	   </c:otherwise>
	 </c:choose>
    <c:choose>
	   <c:when test="${not empty sessionScope.deployinfo.sys_meta_desc}">  
	   		<meta name="description" content="${sessionScope.deployinfo.sys_meta_desc}">
	   </c:when>
	   <c:otherwise> 
	  	    <meta name="description" content="云路在线课堂，解决大学生的职业技能学习以及实习就业难题，帮助企业找到合适的大学毕业生人才。">
	   </c:otherwise>
	 </c:choose>
	<jsp:include page="version.jsp"></jsp:include>
	<link type="image/x-icon" rel="shortcut icon" href="${version}/images/favicon.ico">
	<link rel="stylesheet" type="text/css" href="${ctx}${version}/css/global.css"/>
     <c:if test="${requestScope.cssUrl!=null}">
        <link rel="stylesheet" type="text/css" href="${version}/css/page/${requestScope.cssUrl}.css"/>
     </c:if>
	<!--[if IE 6]>
	<script src="/js/png.js"></script>
	<script>
		DD_belatedPNG.fix('*');
	</script>
	<![endif]-->
     <script type="text/javascript">
         var YL = {};
         YL.BOOTSTAMP = new Date().getTime();
         YL.STATIC_ROOT = "${version}";
         YL.DOMAIN="${ftp}";
    </script>
<body>
     
     <jsp:include page="header-s.jsp"></jsp:include>  
     <!-- content_s -->
     
     <decorator:body />
     
     <!-- content_e -->
     
     <!-- footer_s -->
      <div id="ft">
		<div class="wrap ft-con pr">
	    <p class="ft-nav clearfix">
	       <a href="/lms/about/us">关于我们</a>
	        <a href="/lms/about/join">加入云路</a>
	        <a href="/lms/about/problem">常见问题</a>
	        <a href="/lms/about/contact">联系我们</a>
	        <a href="javascript:;" class="sina-share">
	        <wb:follow-button uid="5308719755" type="red_1" width="67" height="24" ></wb:follow-button>
	        </a>
	      </p>
	      <p class="ft-copyright">
	        	<c:choose>
				   <c:when test="${not empty sessionScope.deployinfo.sys_icp}">  
				   		<span>${sessionScope.deployinfo.sys_icp}</span>
				   </c:when>
				   <c:otherwise> 
				  	    <span>Copyrights © 2012-2014 京ICP备14025955号</span>
				   </c:otherwise>
				 </c:choose>
				 <c:choose>
				   <c:when test="${not empty sessionScope.deployinfo.sys_count_code}">  
				   		<span class="hide">${sessionScope.deployinfo.sys_count_code}</span>
				   </c:when>
				   <c:otherwise> 
				  	    <span class="hide">0</span>
				   </c:otherwise>
				 </c:choose>
	      </p>
	      <a href="http://effine.cn" class="logo2 pa"><img src="/img/logo/logo02.png" alt="爱云路" width="175" height="40" ></a>
		</div>
		</div>
	<!-- footer -->	
	 <script type="text/javascript" data-main="${version}/js/page/${requestScope.jsUrl}"  src="/static/js/lib/r.js"></script>
 </body>
</html>
