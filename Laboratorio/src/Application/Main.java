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

        int option;
        do {
            option= JOptionPane.showOptionDialog(
                    null,"Select one option", "Options Selector", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,    // null para icono por defecto.
                    new Object[] { "Professor","Monitor", "Students", "Objects","Loans","Reports","Salir" },null);
            switch (option){
                case 0:
                    int optionProfessor=JOptionPane.showOptionDialog(
                            null,"Select one option", "Options Selector", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,    // null para icono por defecto.
                            new Object[] { "Create","Delete", "Update", "Consult","Salir" },null);
                    switch (optionProfessor){
                        case 0:
                            functionPerson.prepareCreateProfessor(functionPerson.monitorService.listMonitor);
                            break;
                        case 1:
                            functionPerson.prepareDeleteProfessor();
                            break;
                        case 2:
                            functionPerson.prepareUpdateProfessor(functionPerson.monitorService.listMonitor);
                            break;
                        case 3:
                            functionPerson.prepareConsultProfessor();
                            break;
                    }
                    break;
                case 1:
                    int optionMonitor=JOptionPane.showOptionDialog(
                            null,"Select one option", "Options Selector", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,    // null para icono por defecto.
                            new Object[] { "Create","Delete", "Update", "Consult","Salir" },null);
                    switch (optionMonitor){
                        case 0:
                            functionPerson.prepareCreateMonitor();
                            break;
                        case 1:
                            functionPerson.prepareDeleteMonitor();
                            break;
                        case 2:
                            functionPerson.prepareUpdateMonitor();
                            break;
                        case 3:
                            functionPerson.prepareConsultMonitor();
                            break;
                    }
                    break;
                case 2:
                    int optionStudent=JOptionPane.showOptionDialog(
                            null,"Select one option", "Options Selector", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,    // null para icono por defecto.
                            new Object[] { "Create","Delete", "Update", "Consult","Salir" },null);
                    switch (optionStudent){
                        case 0:
                            functionPerson.prepareCreateStudent();
                            break;
                        case 1:
                            functionPerson.prepareDeleteStudent();
                            break;
                        case 2:
                            functionPerson.prepareUpdateStudent();
                            break;
                        case 3:
                            functionPerson.prepareConsultStudent();
                            break;
                    }
                    break;
            }
        }while (option!=6);




    }

}
