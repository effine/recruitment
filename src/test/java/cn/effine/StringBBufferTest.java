/**
 * @author effine
 * @Date 2015年6月23日  上午9:36:26
 * @email verphen#gmail.com
 */

package cn.effine;

public class StringBBufferTest {
	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer();

		System.err.println(new StringBuffer("abc").equals(new StringBuffer(
				"abc")));

		String s1 = null;
		String s2 = "";
		System.err.println(s1 == s2);

	}
}
