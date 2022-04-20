package rgr.calculations;

// TODO: Auto-generated Javadoc
/**
 * The Class CalculationTaxes.
 */
public final class CalculationTaxes {
	
/** The Constant INSURANCETAX. */
private final static String PENSIONTAX = "22", MEDICALTAX = "5.1", SOCIALTAX = "2.9", INSURANCETAX = "0.2";

/** The Constant INCOMETAXFORREZIDENT. */
private final static double INCOMETAXFORREZIDENT = 13, INCOMETAXFORNONREZIDENT = 30;
	
/**
 * Calculate income tax for resident.
 *
 * @param fullSalary the full salary
 * @return the double
 */
public static double calculateIncomeTaxForResident(double fullSalary) {
	return fullSalary * INCOMETAXFORREZIDENT/100;
	}

/**
 * Calculate income tax for non resident.
 *
 * @param fullSalary the full salary
 * @return the double
 */
public static double calculateIncomeTaxForNonResident(double fullSalary) {
	return fullSalary * INCOMETAXFORNONREZIDENT/100;
	}

/**
 * Calculate medical tax.
 *
 * @param fullSalary the full salary
 * @return the double
 */
public static double calculateMedicalTax(double fullSalary) {
	Double medical = Double.parseDouble(MEDICALTAX);
	return fullSalary * medical/100;
	}

/**
 * Calculate social tax.
 *
 * @param fullSalary the full salary
 * @return the double
 */
public static double calculateSocialTax(double fullSalary) {
	Double social = Double.parseDouble(SOCIALTAX);
	return fullSalary * social/100;
	}

/**
 * Calculate insurance tax.
 *
 * @param fullSalary the full salary
 * @return the double
 */
public static double calculateInsuranceTax(double fullSalary) {
	Double insurance = Double.parseDouble(INSURANCETAX);
	return fullSalary * insurance/100;
	}

/**
 * Calculate pension tax.
 *
 * @param fullSalary the full salary
 * @return the double
 */
public static double calculatePensionTax(double fullSalary) {
	Double pension = Double.parseDouble(PENSIONTAX);
	return fullSalary * 22/100;
	}

/**
 * Calculate amount of salary.
 *
 * @param incomeTax the income tax
 * @param pensionTax the pension tax
 * @param medicalTax the medical tax
 * @param socialTax the social tax
 * @param insurance the insurance
 * @return the double
 */
public static double calculateAmountOfSalary(double incomeTax, double pensionTax, double medicalTax, double socialTax, double insurance) {
	return incomeTax + pensionTax + medicalTax + socialTax + insurance;
}
}
