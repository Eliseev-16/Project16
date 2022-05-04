package rgr.sqlManager;

// TODO: Auto-generated Javadoc
/**
 * The Class CoefficientValues.
 */
public class CoefficientValues {

    /** The income. */
    private String income;
    
    /** The income non resident. */
    private String incomeNonResident;
    
    /** The pension. */
    private String pension;
    
    /** The medical. */
    private String medical;
    
    /** The social. */
    private String social;
    
    /** The insurance. */
    private String insurance;

    /**
     * Instantiates a new coefficient values.
     *
     * @param income the income
     * @param incomeNonResident the income non resident
     * @param pension the pension
     * @param medical the medical
     * @param social the social
     * @param insurance the insurance
     */
    CoefficientValues(String income, String incomeNonResident, String pension, String medical,
                      String social,String insurance){
        this.income = income;
        this.incomeNonResident = incomeNonResident;
        this.pension = pension;
        this.medical = medical;
        this.social = social;
        this.insurance = insurance;
    }

    /**
     * Gets the income.
     *
     * @return the income
     */
    public String getIncome (){
        return income;
    }
    
    /**
     * Gets the income non resident.
     *
     * @return the income non resident
     */
    public String getIncomeNonResident (){
        return incomeNonResident;
    }
    
    /**
     * Gets the pension.
     *
     * @return the pension
     */
    public String getPension (){
        return pension;
    }
    
    /**
     * Gets the social.
     *
     * @return the social
     */
    public String getSocial (){
        return social;
    }
    
    /**
     * Gets the medical.
     *
     * @return the medical
     */
    public String getMedical (){
        return medical;
    }
    
    /**
     * Gets the insurance.
     *
     * @return the insurance
     */
    public String getInsurance (){
        return insurance;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "CoefficientValues{" +
                "income=" + income +
                ", incomeNonResident=" + incomeNonResident +
                ", pension=" + pension +
                ", medical=" + medical +
                ", social=" + social +
                ", insurance=" + insurance +
                '}';
    }
}
