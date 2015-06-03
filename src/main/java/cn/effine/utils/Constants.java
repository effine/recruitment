/**
 * @Date 2015年1月22日  上午10:51:27
 * @author 张亚飞
 * @email verphen@163.com
 */

package cn.effine.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/** 常量操作 */
public class Constants {
	
	//ftp文件服务器地址
	public static final String FTP_DOMAIN=PropertiesUtils.getProp("ftp.domain");

	// 分页
	public static final int PAGE_SIZE = 10; // 每页显示记录数
	public static final int CORPORATION_JOB_PAGE_SIZE = 5; // 公司主页显示岗位记录条数

	public static final long SEVEN_MILLIS = (long)(7 * 24 * 60 * 60 * 1000);	//七天时间毫秒数
	
	
	public enum Belle {
	    para1,  para2,  para3,  para4;
	}
	
	
	
	
	/** 枚举：岗位性质  */
	public static enum COR_JOB_TYPE {
		fullTime(1, "全职"), trainee(2, "实习");
		public  final int key;
		public  final String value;

		COR_JOB_TYPE(int key, String value) {
			this.key = key;
			this.value = value;
		}
	}
	
	/** 枚举：岗位状态 */
	static enum COR_JOB_STATUS {
		del(0, "删除"), upline(1, "上线"), downline(1, "下线");
		private int key;
		private String value;

		private COR_JOB_STATUS(int key, String value) {
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}
	}
	
	/** 枚举：简历处理状态 */
	static enum COR_JOB_REQUEST_STATUS {
		unhandle(0, "未阅读（处理）"), readed(1, "已阅读"), unsatisfy(2, "不合适"), interview(3, "已发送面试邀请"), del(4, "已删除"),;
		private int key;
		private String value;

		private COR_JOB_REQUEST_STATUS(int key, String value) {
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}
	}
	
	//公司
	public static final Map<Integer,String> CORPORATION_SCALE_MAP =  new LinkedHashMap<Integer,String>();	//公司规模
	
	//岗位
	public static final Map<Integer,String> JOB_TYPE_MAP =  new LinkedHashMap<Integer,String>();	//岗位类型
	
	static{
		//公司规模
		CORPORATION_SCALE_MAP.put(1, "100人以下 ");
		CORPORATION_SCALE_MAP.put(2, "100-500人 ");
		CORPORATION_SCALE_MAP.put(3, "500-1000人 ");
		CORPORATION_SCALE_MAP.put(4, "1000人以上 ");
		
		//岗位类型
		JOB_TYPE_MAP.put(1, "全职");
		JOB_TYPE_MAP.put(2, "实习");
	}
 
}
