package cn.effine.utils;

import java.util.Map;

import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 *
 */
public class EmailUtils {
	private static Logger log =LoggerFactory.getLogger(EmailUtils.class);

	/**
	 * 发送邮件： 面试邀请
	 * 
	 * @param emailMap
	 *            邮件配置信息
	 * @param toEmail
	 *            被邀请人邮箱
	 * @param toName
	 *            被邀请人姓名
	 * @param emailContent
	 *            邮件内容
	 * @return Boolean
	 */
	public static boolean sendInterviewInvite(Map<String,Object> emailMap, String toEmail, String toName, String emailContent) {
		String subject = "面试邀请"; // 主题 
		HtmlEmail email = new HtmlEmail();
		email.setHostName(String.valueOf(emailMap.get("smtp")));	// 设置发信的smtp服务器 
		email.setSubject(subject); 		// 设置邮件主题 
		email.setAuthentication(String.valueOf(emailMap.get("fromEmail")), String.valueOf(emailMap.get("password")));// SMTP服务器认证,设置帐号、密码
		email.setCharset("utf-8");	// 设置邮件字符集 
		try {
			email.addTo(toEmail, toName);	// 设置收件人帐号和收件人
			String yl_username = String.valueOf(emailMap.get("nikeName"));
			email.setFrom(String.valueOf(emailMap.get("fromEmail")),yl_username);	// 设置发信的邮件帐号和发信人
			email.setHtmlMsg(emailContent);	// 设置邮件正文，此方法这里的样式可以显示出来 
			email.send();
			return true;
		} catch (Exception  e) {
			log.error("发送面试邀请邮件失败！邮件地址："+ toEmail, e);
			return false;
		}
	}
}