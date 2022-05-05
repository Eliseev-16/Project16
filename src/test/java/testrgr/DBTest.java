package testrgr;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import rgr.sqlManager.SQLReader;

// TODO: Auto-generated Javadoc
/**
 * The Class DBtest.
 */
public class DBTest {
	
	/** The access. */
	private static int access = 0;


	/**
	 * Sets the up.
	 */
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
