package rgr.calculations;

// TODO: Auto-generated Javadoc
/**
 * The Class CalculationSalary.
 */
public final class CalculationSalary {

/**
 * Calculate salary.
 *
 * @param fullSalary the full salary
 * @param incomeTax the income tax
 * @param pensionTax the pension tax
 * @param medicalTax the medical tax
 * @param socialTax the social tax
 * @param insurance the insurance
 * @return the double
 */
public static double calculateSalary(double fullSalary, double incomeTax, double pensionTax, double medicalTax, double socialTax, double insurance) {
	return fullSalary - incomeTax - pensionTax - medicalTax - socialTax - insurance;
}
}
