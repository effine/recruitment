/**
 * @Date 2015年1月21日  下午7:38:24
 * @author 张亚飞
 * @email verphen@163.com
 */

package cn.effine.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.effine.service.CorporationService;
import cn.effine.utils.Constants;
import cn.effine.utils.ExceptionUtils;

/** 公司  */
@Controller
@RequestMapping("corporation")
public class CorporationController {
	private static Logger log = LoggerFactory.getLogger(ExceptionUtils.class);
	@Autowired
	private CorporationService corporationService;
	
	/**
	 * 跳转：公司主页
	 *
	 * @param corporationId
	 *            公司ID
	 * @return 跳转:公司主页
	 */
	@RequestMapping("main/{corporationId}")
	public String toMain(HttpServletRequest request, HttpServletResponse response, Model model) {
		String url = request.getServletPath();
		String[] urlArr = url.split("/");
		if (null == urlArr || urlArr.length != 3) return "404";
		int corporationId = 0;
		try {
			corporationId = Integer.parseInt(urlArr[urlArr.length - 1]); //获取：url后面的公司ID
		} catch (NumberFormatException e) {
			log.error("解析url末尾公司ID异常；", e);
		}
		if(0 != corporationId){
			//获取：公司信息
			Map<String,Object> map = corporationService.getCorporation(corporationId);
			int scale = Integer.parseInt(map.get("scale").toString());
			map.put("scale", Constants.CORPORATION_SCALE_MAP.get(scale));	//公司规模：将数字转换其代表意义
			model.addAttribute(map);
			return "server/corporation/main";
		}
		return "404";
	}
	
	//TODO effine
	@RequestMapping("test")
	public String test(HttpServletRequest request, HttpServletResponse response) {

		return "server/corporation/detailsCorporation";
	}
}
