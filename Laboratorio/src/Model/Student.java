package Model;

public class Student extends Person{
    private String career;

    private int amoutLoan;

    public int getAmoutLoan() {
        return amoutLoan;
    }

    public void setAmoutLoan(int amoutLoan) {
        this.amoutLoan = amoutLoan;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Student(String name,String career) {
        setName(name);
        this.career = career;
        this.amoutLoan=0;
    }
}
