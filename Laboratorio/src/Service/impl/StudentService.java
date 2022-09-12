package Service.impl;

import Exceptions.ExceptionInputNum;
import Model.Student;
import Service.PersonService;

import javax.swing.*;
import java.util.ArrayList;

public class StudentService implements PersonService {
    public ArrayList <Student> listStudent=new ArrayList<>();
    public void GenerateProveStudent(){
        listStudent.add(new Student("Mariana","Medicine"));
        listStudent.add(new Student("Andres","Software Engineering"));
        listStudent.add(new Student("Nicolas","Vet"));
    }

    public void createStudent(String name,String career){
        listStudent.add(new Student(name,career));
    }

    public void amountLoanStudent(){
        Student bestStudent=listStudent.get(0);
        for (int x=0;x<listStudent.size();x++){
            if (bestStudent.getAmoutLoan()<listStudent.get(x).getAmoutLoan()){
                bestStudent=listStudent.get(x);
            }
        }
        JOptionPane.showMessageDialog(null,"The student with the most of loans is:\n "+bestStudent.getName()+" with "+bestStudent.getAmoutLoan()+" amount of loans");
    }

    @Override
    public void deleteObject() {
        int option=0;
        String message="Select the Student that you want to delete\n\n";
        for (int x=0;x<listStudent.size();x++){
            message+=x+"). "+listStudent.get(x).getName()+"         "+listStudent.get(x).getCareer()+"\n";
        }
        try {
            option=Integer.parseInt(JOptionPane.showInputDialog(message));
            ExceptionInputNum.condition(option,listStudent.size());
        } catch (ExceptionInputNum ein){
            JOptionPane.showMessageDialog(null, "This is", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Operation with String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }catch (IndexOutOfBoundsException ioobe){
            JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            listStudent.remove(option);
        }catch (IndexOutOfBoundsException ioobe){
            JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }

    }


    public void update() {
        int option=0;
        String message="Select the Student that you want to update\n\n";
        for (int x=0;x<listStudent.size();x++){
            message+=x+"). "+listStudent.get(x).getName()+"         "+listStudent.get(x).getCareer()+"\n";
        }
        try {
            option=Integer.parseInt(JOptionPane.showInputDialog(message));
            ExceptionInputNum.condition(option,listStudent.size());
        } catch (ExceptionInputNum ein){
            JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Operation with String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }catch (IndexOutOfBoundsException ioobe){
            JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }
        int optionUpdate=JOptionPane.showOptionDialog(
                null,"Select one option", "Options Selector", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,new Object[] {"Name","Career","Amount of Loans","Salir" },null);
        switch (optionUpdate){
            case 0:listStudent.get(option).setName(JOptionPane.showInputDialog("Input the new name of the student"));break;
            case 1:listStudent.get(option).setCareer(JOptionPane.showInputDialog("Input the new career of the student"));break;
            case 2:listStudent.get(option).setAmoutLoan(Integer.parseInt(JOptionPane.showInputDialog("Input the new amount of loans of the student")));break;
        }
    }

    @Override
    public void consult() {
        int option=0;
        String message="Select the Student that you want to see\n\n";
        for (int x=0;x<listStudent.size();x++){
            message+=x+"). "+listStudent.get(x).getName()+"         "+listStudent.get(x).getCareer()+"\n";
        }
        try {
            option=Integer.parseInt(JOptionPane.showInputDialog(message));
            ExceptionInputNum.condition(option,listStudent.size());
        } catch (ExceptionInputNum ein){
            JOptionPane.showMessageDialog(null, "This is", "Error Dialog", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Operation with String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }catch (IndexOutOfBoundsException ioobe){
            JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            JOptionPane.showMessageDialog(null,"Monitor information\n"+listStudent.get(option).getName()+"            "+listStudent.get(option).getCareer());

        }catch (IndexOutOfBoundsException ioobe){
            JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
