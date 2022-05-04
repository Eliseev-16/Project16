package testrgr;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import rgr.sqlManager.SQLReader;

public class DBtest {
	private static int access = 0;


	@BeforeClass
	public static void setUp() {
		try {
			access = SQLReader.readUser("Eliseev", "12345");
		} catch (Exception e) {
			assertEquals(0,1);
		}
	}

	/**
	 * Test.
	 */
	@Test
	public void test() {
		assertEquals(1,access);
	}
	

}
