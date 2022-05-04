//package testrgr;
//
//import static org.junit.Assert.*;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import rgr.calculations.CalculationSalary;
//import rgr.calculations.CalculationTaxes;
//
//// TODO: Auto-generated Javadoc
///**
// * The Class CalculateTest.
// */
//public class CalculateTest {
//	
//	/** The tarif rate. */
//	private static double tarifRate = 100;
//	
//	/** The number of. */
//	private static double numberOf = 10;
//	
//	/** The full salary. */
//	private static double fullSalary;
//	
//	/** The insurance. */
//	private static String salary, incomeTax, pensionTax, medicalTax, socialTax, insurance;
//	
//	/**
//	 * Before.
//	 */
//	@BeforeClass
//	public static void Before() {
//		fullSalary = tarifRate * numberOf;
//		incomeTax = Double.toString(CalculationTaxes.calculateIncomeTaxForResident(fullSalary));
//		pensionTax = Double.toString(CalculationTaxes.calculatePensionTax(fullSalary));
//		medicalTax = Double.toString(CalculationTaxes.calculateMedicalTax(fullSalary));
//		socialTax = Double.toString(CalculationTaxes.calculateSocialTax(fullSalary));
//		insurance = Double.toString(CalculationTaxes.calculateInsuranceTax(fullSalary));
//		salary = Double.toString(CalculationSalary.calculateSalary(fullSalary, CalculationTaxes.calculateIncomeTaxForResident(fullSalary), CalculationTaxes.calculatePensionTax(fullSalary), CalculationTaxes.calculateMedicalTax(fullSalary), CalculationTaxes.calculateSocialTax(fullSalary), CalculationTaxes.calculateInsuranceTax(fullSalary)));
//	}
//	
//	/**
//	 * Test.
//	 */
//	@Test
//	public void test() {
//		assertEquals(insurance,"2.0");
//		assertEquals(pensionTax,"220.0");
//		assertEquals(incomeTax,"130.0");
//		assertEquals(medicalTax,"51.0");
//		assertEquals(socialTax,"29.0");
//		assertEquals(salary,"568.0");
//	}
//}
