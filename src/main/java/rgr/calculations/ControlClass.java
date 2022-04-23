package rgr.calculations;

import javax.swing.JOptionPane;

import rgr.DataSource;
import rgr.gui.MainGUI;
import rgr.servlets.ServletForMainPage.RequestCalc;

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
	
	/** The tarif. */
	private String tarif;
	
	/**
	 * Instantiates a new control class.
	 *
	 * @throws Exception the exception
	 */
	public ControlClass() throws Exception{
		tarifRate = Double.parseDouble(RequestCalc.getTariffRate());
		numberOf = Double.parseDouble(RequestCalc.getWorkTime());
		checkExeption();
		fullSalary = tarifRate * numberOf;
		isResident = RequestCalc.getIsResident();
		calculate();
		callSetValue();
	}
	
	/**
	 * Calculate.
	 */
	public void calculate() {
		if (isResident==true) {
			incomeTax = Math.floor(CalculationTaxes.calculateIncomeTaxForResident(fullSalary));
		} 
		else {
			incomeTax = Math.floor(CalculationTaxes.calculateIncomeTaxForNonResident(fullSalary));
		}
		pensionTax = Math.floor(CalculationTaxes.calculatePensionTax(fullSalary));
	    medicalTax = Math.floor(CalculationTaxes.calculateMedicalTax(fullSalary));
	    socialTax = Math.floor(CalculationTaxes.calculateSocialTax(fullSalary));
	    insurance = Math.floor(CalculationTaxes.calculateInsuranceTax(fullSalary));
	    salary = Math.floor(CalculationSalary.calculateSalary(fullSalary, incomeTax, pensionTax, medicalTax, 
	    		socialTax, insurance));
	    amountOfTaxes = CalculationTaxes.calculateAmountOfTaxes(incomeTax, pensionTax, medicalTax,
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
	 * Check exeption.
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
