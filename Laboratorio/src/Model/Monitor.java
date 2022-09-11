package Model;

public class Monitor extends Person{
    private String career;
    private int ageInCompany;

    private int amountLoan;

    public int getAgeInCompany() {
        return ageInCompany;
    }

    public void setAgeInCompany(int ageInCompany) {
        this.ageInCompany = ageInCompany;
    }

    public int getAmountLoan() {
        return amountLoan;
    }

    public void setAmountLoan(int amountLoan) {
        this.amountLoan = amountLoan;
    }

    public Monitor(String name, String career, int ageInCompany) {
        setName(name);
        this.career = career;
        this.ageInCompany=ageInCompany;
        this.amountLoan=0;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}
