package testrgr;
//
import static org.junit.Assert.*;
//
import org.junit.BeforeClass;
import org.junit.Test;
//
import rgr.fortest.ClassForTest;
//
//// TODO: Auto-generated Javadoc
///**
// * The Class GetTest.
// */
public class GetTest {
//
//	/** The test class. */
	private static ClassForTest testClass;
//	
//	/**
//	 * Sets the up.
//	 */
	@BeforeClass
	public static void setUp() {
		testClass=new ClassForTest();
	}
//	
//	
//	/**
//	 * Test.
//	 */
	@Test
	public void test() {
		assertEquals(testClass.getSalary(), 5.6, 0.0);
		assertEquals(testClass.getIncomeTax(), 7.8, 0.0);
		assertEquals(testClass.getPensionTax(), 502.1, 0.0);
		assertEquals(testClass.getMedicalTax(), 20.0, 0.0);
		assertEquals(testClass.getSocialTax(), 777.3, 0.0);
		assertEquals(testClass.getInsurance(), 15.2, 0.0);
	}

}
