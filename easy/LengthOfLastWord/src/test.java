import static org.junit.Assert.*;

import org.junit.Test;


public class test {

	@Test
	public void test() {
		String str = "hahha";
		for(String piece : str.split(" ")) {
			System.out.println( piece );
		}
	}

}
