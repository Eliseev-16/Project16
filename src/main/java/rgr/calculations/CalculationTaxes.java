package rgr.calculations;

// TODO: Auto-generated Javadoc
/**
 * The Class CalculationTaxes.
 */
public class CalculationTaxes {
	
/** The Constant INSURANCETAX. */
private static String PENSIONTAX, MEDICALTAX, SOCIALTAX, INSURANCETAX;

/** The Constant INCOMETAXFORREZIDENT. */
private static String INCOMETAXFORREZIDENT, INCOMETAXFORNONREZIDENT;

	public void setValue(String PENSIONTAX, String MEDICALTAX, String SOCIALTAX, String INSURANCETAX, 
		String INCOMETAXFORREZIDENT, String INCOMETAXFORNONREZIDENT) {
	this.PENSIONTAX = PENSIONTAX;
	this.MEDICALTAX = MEDICALTAX;
	this.SOCIALTAX = SOCIALTAX;
	this.INSURANCETAX = INSURANCETAX;
	this.INCOMETAXFORREZIDENT = INCOMETAXFORREZIDENT;
	this.INCOMETAXFORNONREZIDENT = INCOMETAXFORNONREZIDENT;
}
/**
 * Calculate income tax for resident.
 *
 * @param fullSalary the full salary
 * @return the double
 */
public static double calculateIncomeTaxForResident(double fullSalary) {
	Double INCOMEFORREZIDENT = Double.parseDouble(INCOMETAXFORREZIDENT);
	return fullSalary * INCOMEFORREZIDENT/100;
	}

/**
 * Calculate income tax for non resident.
 *
 * @param fullSalary the full salary
 * @return the double
 */
public static double calculateIncomeTaxForNonResident(double fullSalary) {
	Double INCOMEFORNONREZIDENT = Double.parseDouble(INCOMETAXFORNONREZIDENT);
	return fullSalary * INCOMEFORNONREZIDENT/100;
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
public static double calculateAmountOfTaxes(double incomeTax, double pensionTax, double medicalTax, double socialTax, double insurance) {
	return incomeTax + pensionTax + medicalTax + socialTax + insurance;
}
}
