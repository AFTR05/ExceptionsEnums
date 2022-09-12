package Application;

import Controller.FunctionLoan;
import Controller.FunctionObject;
import Controller.FunctionPerson;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        FunctionPerson functionPerson=new FunctionPerson();
        functionPerson.prepareGenerateMonitor();
        functionPerson.prepareGenerateStudent();
        functionPerson.prepareGenerateProfessor(functionPerson.monitorService.listMonitor);
        FunctionObject functionObject=new FunctionObject();
        functionObject.prepareGenerateProveObjects();
        FunctionLoan functionLoan=new FunctionLoan();
        functionLoan.prepareGenerateProveLoans(functionPerson.monitorService.listMonitor,functionPerson.studentService.listStudent,functionObject.objectService.listObject);

        int option;
        do {
            option= JOptionPane.showOptionDialog(
                    null,"Select one option", "Options Selector", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,    // null para icono por defecto.
                    new Object[] { "Professor","Monitor", "Students", "Objects","Loans","Reports","Quit" },null);
            switch (option){
                case 0:
                    int optionProfessor=JOptionPane.showOptionDialog(
                            null,"Select one option", "Options Selector", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,    // null para icono por defecto.
                            new Object[] { "Create","Delete", "Update", "Consult","Quit" },null);
                    switch (optionProfessor){
                        case 0:
                            functionObject.prepareUpdateInformation();
                            functionPerson.prepareCreateProfessor(functionPerson.monitorService.listMonitor);
                            break;
                        case 1:
                            functionObject.prepareUpdateInformation();
                            functionPerson.prepareDeleteProfessor();
                            break;
                        case 2:
                            functionObject.prepareUpdateInformation();
                            functionPerson.prepareUpdateProfessor(functionPerson.monitorService.listMonitor);
                            break;
                        case 3:
                            functionObject.prepareUpdateInformation();
                            functionPerson.prepareConsultProfessor();
                            break;
                    }
                    break;
                case 1:
                    int optionMonitor=JOptionPane.showOptionDialog(
                            null,"Select one option", "Options Selector", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,    // null para icono por defecto.
                            new Object[] { "Create","Delete", "Update", "Consult","Quit" },null);
                    switch (optionMonitor){
                        case 0:
                            functionObject.prepareUpdateInformation();
                            functionPerson.prepareCreateMonitor();
                            break;
                        case 1:
                            functionObject.prepareUpdateInformation();
                            functionPerson.prepareDeleteMonitor();
                            break;
                        case 2:
                            functionObject.prepareUpdateInformation();
                            functionPerson.prepareUpdateMonitor();
                            break;
                        case 3:
                            functionObject.prepareUpdateInformation();
                            functionPerson.prepareConsultMonitor();
                            break;
                    }
                    break;
                case 2:
                    int optionStudent=JOptionPane.showOptionDialog(
                            null,"Select one option", "Options Selector", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,    // null para icono por defecto.
                            new Object[] { "Create","Delete", "Update", "Consult","Quit" },null);
                    switch (optionStudent){
                        case 0:
                            functionObject.prepareUpdateInformation();
                            functionPerson.prepareCreateStudent();
                            break;
                        case 1:
                            functionObject.prepareUpdateInformation();
                            functionPerson.prepareDeleteStudent();
                            break;
                        case 2:
                            functionObject.prepareUpdateInformation();
                            functionPerson.prepareUpdateStudent();
                            break;
                        case 3:
                            functionObject.prepareUpdateInformation();
                            functionPerson.prepareConsultStudent();
                            break;
                    }
                    break;
                case 3:
                    int optionObjects=JOptionPane.showOptionDialog(
                            null,"Select one option", "Options Selector", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,    // null para icono por defecto.
                            new Object[] { "Create","Consult by name", "Consult by code","Quit" },null);
                    switch (optionObjects){
                        case 0:
                            functionObject.prepareUpdateInformation();
                            functionObject.prepareCreateObject();
                            break;
                        case 1:
                            functionObject.prepareUpdateInformation();
                            functionObject.prepareConsultDataByName();
                            break;
                        case 2:
                            functionObject.prepareUpdateInformation();
                            functionObject.prepareConsultDataByCode();
                            break;
                    }
                    break;
                case 4:
                    int optionLoan=JOptionPane.showOptionDialog(
                            null,"Select one option", "Options Selector", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,    // null para icono por defecto.
                            new Object[] { "Create","Consult by code", "Monitor amount loans","Quit" },null);
                    switch (optionLoan){
                        case 0:
                            functionObject.prepareUpdateInformation();
                            functionLoan.prepareCreateLoan(functionPerson.monitorService.listMonitor,functionPerson.studentService.listStudent,functionObject.objectService.listObject);
                            break;
                        case 1:
                            functionObject.prepareUpdateInformation();
                            functionLoan.prepareConsultLoanByCode();
                            break;
                        case 2:
                            functionObject.prepareUpdateInformation();
                            functionLoan.prepareAmountMonitorLoan(functionPerson.monitorService.listMonitor);
                            break;
                    }
                case 5:
                    int optionReport=JOptionPane.showOptionDialog(
                            null,"Select one option", "Options Selector", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,    // null para icono por defecto.
                            new Object[] { "Best student with amount of loans","Total income of the laboratory", "Monitors salary","Quit" },null);
                    switch (optionReport){
                        case 0:
                            functionPerson.prepareAmountLoanStudent();
                            break;
                        case 1:
                            functionLoan.prepareTotalIncome();
                            break;
                        case 2:
                            functionPerson.preparetotalSalary();
                            break;
                    }
            }
        }while (option!=6);




    }

}
