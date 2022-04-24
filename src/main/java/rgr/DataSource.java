package rgr;

import javax.swing.JComboBox;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class DataSource.
 */
public abstract class DataSource implements Structure {

	private String surname, name, patronumic; //ФИО
	
	/** The salary. */
    private double salary; // з/п

    /** The tariff rate. */
    private String tariffRate;//тарифная ставка

    /** The number of. */
    private String numberOf; //количество дней/часов

    /** The is day. */
    private boolean isResident, isDay; //комбобоксы

    /** The insurance. */
    private double incomeTax, pensionTax, medicalTax, socialTax, insurance; //налоги

    /**
     * Sets the values.
     *
     * @param tariffRate the tariff rate
     * @param numberOf the number of
     * @param resident the resident
     * @param typeOfPeriod the type of period
     * @param salary the salary
     * @param incomeTax the income tax
     * @param pensionTax the pension tax
     * @param medicalTax the medical tax
     * @param socialTax the social tax
     * @param insurance the insurance
     */
    protected final void setValues(JTextField tariffRate, JTextField numberOf, JComboBox resident, JComboBox typeOfPeriod,
                                   double salary, double incomeTax,double pensionTax,double medicalTax, double socialTax, double insurance){
        this.tariffRate=tariffRate.getText();
        this.numberOf=numberOf.getText();
        if (typeOfPeriod.getSelectedItem().equals("Подневная")) {
            this.isDay=true;
        } else {
            this.isDay=false;
        }
        if (resident.getSelectedItem().equals("Резидент")) {
            this.isResident=true;
        } else {
            this.isResident=false;
        }
        this.salary = salary;
        this.incomeTax = incomeTax;
        this.pensionTax = pensionTax;
        this.medicalTax = medicalTax;
        this.socialTax = socialTax;
        this.insurance = insurance;
    }

    /**
     * Sets the values.
     *
     * @param salary the salary
     * @param incomeTax the income tax
     * @param pensionTax the pension tax
     * @param medicalTax the medical tax
     * @param socialTax the social tax
     * @param insurance the insurance
     */
    protected final void setValues(double salary, double incomeTax,double pensionTax,double medicalTax,
                                   double socialTax, double insurance){
        this.salary = salary;
        this.incomeTax = incomeTax;
        this.pensionTax = pensionTax;
        this.medicalTax = medicalTax;
        this.socialTax = socialTax;
        this.insurance = insurance;

    }

    /**
     * Gets the salary.
     *
     * @return the salary
     */
    public final double getSalary() {
        return salary;
    }

    /**
     * Gets the checks if is day.
     *
     * @return the checks if is day
     */
    public final boolean getIsDay() {
        return isDay;
    }

    /**
     * Gets the income tax.
     *
     * @return the income tax
     */
    public final double getIncomeTax() {
        return incomeTax;
    }

    /**
     * Gets the pension tax.
     *
     * @return the pension tax
     */
    public final double getPensionTax() {
        return pensionTax;
    }

    /**
     * Gets the medical tax.
     *
     * @return the medical tax
     */
    public final double getMedicalTax() {
        return medicalTax;
    }

    /**
     * Gets the insurance.
     *
     * @return the insurance
     */
    public final double getInsurance() {
        return insurance;
    }

    /**
     * Gets the tariff rate.
     *
     * @return the tariff rate
     */
    public final String getTariffRate() {
        return tariffRate;
    }

    /**
     * Gets the number of.
     *
     * @return the number of
     */
    public final String getNumberOf() {
        return numberOf;
    }

    /**
     * Gets the checks if is resident.
     *
     * @return the checks if is resident
     */
    public final boolean getIsResident() {
        return isResident;
    }

    /**
     * Gets the social tax.
     *
     * @return the social tax
     */
    public final double getSocialTax() {
        return socialTax;
    }


    /**
     * Check exeption.
     *
     * @throws Exception the exception
     */
    public abstract void checkExeption() throws Exception;


    /**
     * Zeroing.
     */
    public final void zeroing() {
        salary = ZERO;
        incomeTax = ZERO;
        pensionTax = ZERO;
        medicalTax = ZERO;
        socialTax = ZERO;
        insurance = ZERO;
    }

}
