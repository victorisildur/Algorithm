import static org.junit.Assert.*;

import org.junit.Test;


public class test {

	@Test
	public void test() {
		Solution sol = new Solution();
		String needle = "world";
		String haystack = "helloworld";
		System.out.println(sol.strStr(haystack, needle));
		needle = "hello";
		System.out.println(sol.strStr(haystack, needle));
		needle = "";
		System.out.println(needle.isEmpty());
	}
	@Test
	public void test2() {
		Solution2 sol = new Solution2();
		String needle = "world";
		String haystack = "helloworld";
		System.out.println(sol.strStr(haystack, needle));
		needle = "hello";
		System.out.println(sol.strStr(haystack, needle));
	}
}
