package cn.effine;

/**
 * 正则表达式测试类
 */
public class RegexTest {
	public static void main(String[] args) {
		String str = "Java now has regular expressions";
		System.out.println(str.matches("^Java"));
		System.out.println(str.matches("\\Breg.*"));
		System.out.println(str.matches("n.w\\s+h(a|i)s"));
		System.out.println(str.matches("s?"));
		System.out.println(str.matches("s*"));
		System.out.println(str.matches("s+"));
		System.out.println(str.matches("s{4}"));
		System.out.println(str.matches("s{1}"));
		System.out.println(str.matches("s{0,3}"));
		System.out.println(str.matches(""));
		System.out.println(str.matches(""));
	}
}
