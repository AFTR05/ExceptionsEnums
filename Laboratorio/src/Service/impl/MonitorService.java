package Service.impl;

import Exceptions.ExceptionInputNum;
import Model.Loan;
import Model.Monitor;
import Service.PersonService;

import javax.swing.*;
import java.util.ArrayList;

public class MonitorService implements PersonService {
    public ArrayList<Monitor> listMonitor=new ArrayList<>();

    public void GenerateProveMonitor(){
        listMonitor.add(new Monitor("Harold Andres","Software Engineering",1));
        listMonitor.add(new Monitor("Laura Sofia","Psychology",0));
        listMonitor.add(new Monitor("Valeria","Law",0));
    }

    public void createMonitor(String name,String career,int ageInCompany){
        listMonitor.add(new Monitor(name,career,ageInCompany));
    }

    public void totalSalary(){
        String message="Salary of monitors:\n\n";
        for (int x=0;x<listMonitor.size();x++){
            message+=listMonitor.get(x).getName()+"      Salary: "+((listMonitor.get(x).getTotalIncomeLoan()*0.2)+((listMonitor.get(x).getTotalIncomeLoan()*0.02)*(listMonitor.get(x).getAgeInCompany()))+"\n");
        }
        JOptionPane.showMessageDialog(null,message);
    }

    @Override
    public void deleteObject() {
        int option=0;
        String message="Select the Monitor that you want to delete\n\n";
        for (int x=0;x<listMonitor.size();x++){
            message+=x+"). "+listMonitor.get(x).getName()+"         "+listMonitor.get(x).getCareer()+"\n";
        }
        try {
            option=Integer.parseInt(JOptionPane.showInputDialog(message));
            ExceptionInputNum.condition(option,listMonitor.size());
        } catch (ExceptionInputNum ein){
            JOptionPane.showMessageDialog(null, "This is", "Error Dialog", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Operation with String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }catch (IndexOutOfBoundsException ioobe){
            JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            listMonitor.remove(option);
        }catch (IndexOutOfBoundsException ioobe){
            JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void update() {
        int option=0;
        String message="Select the Monitor that you want to update\n\n";
        for (int x=0;x<listMonitor.size();x++){
            message+=x+"). "+listMonitor.get(x).getName()+"         "+listMonitor.get(x).getCareer()+"\n";
        }
        try {
            option=Integer.parseInt(JOptionPane.showInputDialog(message));
            ExceptionInputNum.condition(option,listMonitor.size());
        } catch (ExceptionInputNum ein){
            JOptionPane.showMessageDialog(null, "This is", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Operation with String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }catch (IndexOutOfBoundsException ioobe){
            JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }
        int optionUpdate=JOptionPane.showOptionDialog(
                null,"Select one option", "Options Selector", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,new Object[] {"Name","Career","Amount of Loans","Age in company","Salir" },null);
        switch (optionUpdate){
            case 0:listMonitor.get(option).setName(JOptionPane.showInputDialog("Input the new name of the monitor"));break;
            case 1:listMonitor.get(option).setCareer(JOptionPane.showInputDialog("Input the new career of the monitor"));break;
            case 2:listMonitor.get(option).setAmountLoan(Integer.parseInt(JOptionPane.showInputDialog("Input the new amount of loans of the monitor")));break;
            case 3:listMonitor.get(option).setAgeInCompany(Integer.parseInt(JOptionPane.showInputDialog("Input the new Age in the company of the monitor")));break;
        }
    }

    @Override
    public void consult() {
        int option=0;
        String message="Select the Monitor that you want to see\n\n";
        for (int x=0;x<listMonitor.size();x++){
            message+=x+"). "+listMonitor.get(x).getName()+"         "+listMonitor.get(x).getCareer()+"\n";
        }
        try {
            option=Integer.parseInt(JOptionPane.showInputDialog(message));
            ExceptionInputNum.condition(option,listMonitor.size());
        } catch (ExceptionInputNum ein){
            JOptionPane.showMessageDialog(null, "This is", "Error Dialog", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Operation with String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }catch (IndexOutOfBoundsException ioobe){
            JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            JOptionPane.showMessageDialog(null,"Monitor information\n"+listMonitor.get(option).getName()+"            "+listMonitor.get(option).getCareer());
        }catch (IndexOutOfBoundsException ioobe){
            JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
