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

		System.err.println("----------------------------------");

		String s1 = "helloword";
		String s2 = new String("helloword");
		String s3 = "hello" + "word";
		String s4 = new String("hello") + "word";

		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1 == s4);
		System.out.println(s2 == s4);

	}

	private static String getBB() {
		return "b";
	}
}
