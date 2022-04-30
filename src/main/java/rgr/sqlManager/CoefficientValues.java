package rgr.sqlManager;

public class CoefficientValues {

    private String income;
    private String incomeNonResident;
    private String pension;
    private String medical;
    private String social;
    private String insurance;

    CoefficientValues(String income, String incomeNonResident, String pension, String medical,
                      String social,String insurance){
        this.income = income;
        this.incomeNonResident = incomeNonResident;
        this.pension = pension;
        this.medical = medical;
        this.social = social;
        this.insurance = insurance;
    }

    public String getIncome (){
        return income;
    }
    public String getIncomeNonResident (){
        return incomeNonResident;
    }
    public String getPension (){
        return pension;
    }
    public String getSocial (){
        return social;
    }
    public String getMedical (){
        return medical;
    }
    public String getInsurance (){
        return insurance;
    }

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
