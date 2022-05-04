package rgr.calculations;

import javax.swing.JOptionPane;

import rgr.DataSource;
import rgr.servlets.ServletForMainPage.RequestCalc;
import rgr.sqlManager.CoefficientValues;
import rgr.sqlManager.SQLReader;

// TODO: Auto-generated Javadoc
/**
 * The Class ControlClass.
 */
public final class ControlClass extends DataSource {
	
	/** The is resident. */
	private static boolean isResident;
	
    /** The number of. */
    private static double fullSalary, salary, incomeTax, pensionTax, medicalTax, socialTax, 
    insurance, tarifRate, numberOf, amountOfTaxes;
	
	/**
	 * Instantiates a new control class.
	 *
	 * @param requestCalc the request calc
	 * @throws Exception the exception
	 */
	public ControlClass(RequestCalc requestCalc) throws Exception{
		tarifRate = requestCalc.getTariffRate();
		numberOf = requestCalc.getNumberOf();
		checkExeption();
		fullSalary = tarifRate * numberOf;
		isResident = requestCalc.getIsResident();
		calculate();
		callSetValue();
	}
	
	/**
	 * Calculate.
	 *
	 * @throws Exception the exception
	 */
	public void calculate() throws Exception {
		CoefficientValues coefficients = SQLReader.readCoefficients();
		CalculationTaxes calculationTaxes = new CalculationTaxes();
		calculationTaxes.setValue(coefficients.getPension(), coefficients.getMedical(),
				coefficients.getSocial(),coefficients.getInsurance(), coefficients.getIncome(),
				coefficients.getIncomeNonResident());
		if (isResident==true) {
			incomeTax = Math.floor(calculationTaxes.calculateIncomeTaxForResident(fullSalary));
		} 
		else {
			incomeTax = Math.floor(calculationTaxes.calculateIncomeTaxForNonResident(fullSalary));
		}
		pensionTax = Math.floor(calculationTaxes.calculatePensionTax(fullSalary));
	    medicalTax = Math.floor(calculationTaxes.calculateMedicalTax(fullSalary));
	    socialTax = Math.floor(calculationTaxes.calculateSocialTax(fullSalary));
	    insurance = Math.floor(calculationTaxes.calculateInsuranceTax(fullSalary));
	    salary = Math.floor(CalculationSalary.calculateSalary(fullSalary, incomeTax, pensionTax, medicalTax, 
	    		socialTax, insurance));
	    amountOfTaxes = calculationTaxes.calculateAmountOfTaxes(incomeTax, pensionTax, medicalTax,
	    		socialTax, insurance);
	}
	
	/**
	 * Call set value.
	 */
	@Override
	public void callSetValue() {
		// TODO Auto-generated method stub 
	    setValues(salary, incomeTax, pensionTax, medicalTax, socialTax, insurance);
	}

	/**
	 * Check exception.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void checkExeption() throws Exception{
		// TODO Auto-generated method stub
		if(numberOf * tarifRate <= 0 || numberOf <= 0 || tarifRate <= 0) {
			throw new Exception("Ошибка в введенных данных");
		}
	}
	
	/**
	 * Gets the full salary.
	 *
	 * @return the full salary
	 */
	public static double getFullSalary() {
	return Math.floor(fullSalary);
	}
	
	/**
	 * Gets the amount of salary.
	 *
	 * @return the amount of salary
	 */
	public static double getAmountOfTaxes() {
		return Math.floor(amountOfTaxes);
		}
}
