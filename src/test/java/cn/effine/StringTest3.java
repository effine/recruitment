/**
 * @author effine
 * @Date 2015年6月23日  上午9:22:55
 * @email verphen#gmail.com
 */

package cn.effine;

public class StringTest3 {
	private static String a = new String("ab");

	public static void main(String[] args) {
		String s1 = "a";
		String s2 = "b";
		String s = s1 + s2;
		System.out.println(s == a);
		System.out.println(s.intern() == a);
		System.out.println(s == a.intern());
		System.out.println(s.intern() == a.intern());
	}
}
