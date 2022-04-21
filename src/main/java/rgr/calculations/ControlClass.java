package rgr.calculations;

import javax.swing.JOptionPane;

import rgr.DataSource;
import rgr.gui.MainGUI;

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
	 * @param frame the frame
	 * @throws Exception the exception
	 */
	public ControlClass(MainGUI frame) throws Exception{
		tarifRate = Double.parseDouble(frame.getTariffRate());
		numberOf = Double.parseDouble(frame.getNumberOf());
		checkExeption();
		fullSalary = tarifRate * numberOf;
		isResident = frame.getIsResident();
		calculate();
		callSetValue();
	}
	
	/**
	 * Calculate.
	 */
	public void calculate() {
		if (isResident==true) {
			incomeTax = CalculationTaxes.calculateIncomeTaxForResident(fullSalary);
		} 
		else {
			incomeTax = CalculationTaxes.calculateIncomeTaxForNonResident(fullSalary);
		}
		pensionTax = CalculationTaxes.calculatePensionTax(fullSalary);
	    medicalTax = CalculationTaxes.calculateMedicalTax(fullSalary);
	    socialTax = CalculationTaxes.calculateSocialTax(fullSalary);
	    insurance = CalculationTaxes.calculateInsuranceTax(fullSalary);
	    salary = CalculationSalary.calculateSalary(fullSalary, incomeTax, pensionTax, medicalTax, 
	    		socialTax, insurance);
	    amountOfTaxes = CalculationTaxes.calculateAmountOfSalary(incomeTax, pensionTax, medicalTax,
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
	return fullSalary;
	}
	
	/**
	 * Gets the amount of salary.
	 *
	 * @return the amount of salary
	 */
	public static double getAmountOfSalary() {
		return amountOfTaxes;
		
	}
	
}
