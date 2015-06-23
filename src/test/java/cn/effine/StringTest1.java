/**
 * @author effine
 * @Date 2015年6月23日  上午9:21:27
 * @email verphen#gmail.com
 */

package cn.effine;

public class StringTest1 {
	public static void main(String[] args) {
		String a = "ab";
		final String bb = getBB();
		String b = "a" + bb;
		System.out.println(a == b);
	}

	private static String getBB() {
		return "b";
	}
}
