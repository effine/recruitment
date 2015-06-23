/**
 * @author effine
 * @Date 2015年6月23日  上午9:10:26
 * @email verphen#gmail.com
 */

package cn.effine;

public class StringTest {
	public static void main(String[] args) {
		System.err.println("----------------------------");
		String a2 = "ab";
		final String bb2 = "b";
		String b2 = "a" + bb2;
		System.out.println(a2 == b2);
		System.err.println("--------------111--------------");
		String a1 = "ab";
		String bb1 = "b";
		String b1 = "a" + bb1;
		System.out.println(a1 == b1);
		System.err.println("----------------------------");
		String s1 = "helloword";
		String s2 = new String("helloword");
		String s3 = "hello" + "word";
		String s4 = new String("hello") + "word";

		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1 == s4);
		System.out.println(s2 == s4);
		System.err.println("----------------------------");
		String a = "a1";
		String b = "a" + 1;
		System.out.println(a == b);
	}
}
