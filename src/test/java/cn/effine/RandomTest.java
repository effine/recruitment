package cn.effine;

public class RandomTest {

	public static void main(String[] args) {

		String s1 = "helloword";
		String s2 = new String("helloword");
		
		System.out.println(s1==s2);
		
		Integer i1 = 2;
		Integer i2 = 2;
		System.err.println(i1==i2);
		

	}
}
