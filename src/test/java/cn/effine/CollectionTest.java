/**
 * @author effine
 * @Date 2015年6月24日  下午5:40:03
 * @email verphen#gmail.com
 */

package cn.effine;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class CollectionTest {
	public static void main(String[] args) {

		// 研究HashMap底层实现
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(null, null);

		// HashTabe的底层分析
		Map<String, Object> table = new Hashtable<String, Object>();
		table.put(null, null);
		
<<<<<<< HEAD
		// rebase分支
		String re = "rebase";
		System.err.println(re+"----------");
		
		//  dev分支
		String str = "develop";
=======
		//  dev分支
		String str = "develop";
		System.err.println(str);
		
		
>>>>>>> update dev 2
	}
}
