package Controller;

import Model.Monitor;
import Model.Object;
import Model.Student;
import Service.LoanService;

import javax.swing.*;
import java.util.ArrayList;

public class FunctionLoan {
    LoanService loanService=new LoanService();
    public void prepareGenerateProveLoans(ArrayList<Monitor> listMonitors, ArrayList<Student> listStudent, ArrayList<Object> listObject){
        loanService.generateProveLoans(listMonitors,listStudent,listObject);
    }

    public void prepareCreateLoan(ArrayList<Monitor> listMonitors, ArrayList<Student> listStudent, ArrayList<Object> listObject){
        String beginLoan= JOptionPane.showInputDialog("Input the day of beginning of the loan");
        int daysLoan=Integer.parseInt(JOptionPane.showInputDialog("Input the total days of the loan"));
        String code=JOptionPane.showInputDialog("Input the code of the loan");
        loanService.createLoan(listMonitors,listStudent,listObject,beginLoan,daysLoan,code);
    }

    public void prepareConsultLoanByCode(){
        String code=JOptionPane.showInputDialog("Input the code of the loan");
        loanService.consultLoanByCode(code);
    }

    public void prepareAmountMonitorLoan(ArrayList<Monitor> listMonitors){
        loanService.amountMonitorLoans(listMonitors);
    }

    public void prepareTotalIncome(){
        loanService.totalIncome();
    }
}
