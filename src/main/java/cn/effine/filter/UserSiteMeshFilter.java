/**
 * @Date 2015年1月26日  下午6:01:56
 * @author 张亚飞
 * @email verphen@163.com
 */

package cn.effine.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

public class UserSiteMeshFilter extends SiteMeshFilter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){
		String requestType = ((HttpServletRequest) request).getHeader("X-Requested-With");
		try {
			if(null != requestType && "XMLHttpRequest".equals(requestType))	//过滤ajax请求
		    	chain.doFilter(request, response);
		     else 
				super.doFilter(request, response,chain);
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	};
}
