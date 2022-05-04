package rgr.fortest;

import rgr.DataSource;

// TODO: Auto-generated Javadoc
/**
 * The Class ClassForTest.
 */
public final class ClassForTest extends DataSource {
	
	/**
	 * Instantiates a new class for test.
	 */
	public ClassForTest(){
		callSetValue();
	}
	
	/**
	 * Call set value.
	 */
	@Override
	public void callSetValue() {
		
		setValues(5.6, 7.8, 502.1, 20.0, 777.3, 15.2);
		
	}
	
	/**
	 * Check exeption.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void checkExeption() throws Exception {
		
	}

}
