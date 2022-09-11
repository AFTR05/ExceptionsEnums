package Service.impl;

import Exceptions.ExceptionInputNum;
import Model.Monitor;
import Model.Professor;
import Service.PersonService;

import javax.swing.*;
import java.util.ArrayList;

public class ProfessorService implements PersonService {
    public ArrayList<Professor> listProfessor = new ArrayList<>();

    public void generateProveProfessor(ArrayList<Monitor> monitors) { //pasar por paremetro arreglo de monitor para crear profesor
        listProfessor.add(new Professor("Ignacio", "Math", monitors.get(0)));
        listProfessor.add(new Professor("Johan", "Spanish", monitors.get(1)));
        listProfessor.add(new Professor("Carlos", "Integral calculus", monitors.get(2)));
    }

    public void createProfessor(String name, String subject, ArrayList<Monitor> monitors) {
        int option=0;
        String message = "Select the monitor for the teacher\n\n";
        for (int x = 0; x < monitors.size(); x++) {
            message += x+"). " + monitors.get(x).getName() + "         " + monitors.get(x).getCareer() + "\n";
        }
        try {
            option = Integer.parseInt(JOptionPane.showInputDialog(message));
            ExceptionInputNum.condition(option,monitors.size());
        } catch (ExceptionInputNum ein){
            JOptionPane.showMessageDialog(null, "This is", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Operation with String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }catch (IndexOutOfBoundsException ioobe){
            JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }
        listProfessor.add(new Professor(name, subject, monitors.get(option)));
    }

    @Override
    public void deleteObject() {
        int option = 0;
        String message = "Select the Professor that you want to delete\n\n";
        for (int x = 0; x < listProfessor.size(); x++) {
            message += x+"). " + listProfessor.get(x).getName() + "         " + listProfessor.get(x).getSubject() + "\n";
        }
        try {
            option = Integer.parseInt(JOptionPane.showInputDialog(message));
            ExceptionInputNum.condition(option, listProfessor.size());
        } catch (ExceptionInputNum ein) {
            JOptionPane.showMessageDialog(null, "This is", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Operation with String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }catch (IndexOutOfBoundsException ioobe){
            JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }
        listProfessor.remove(option);
    }

    public void update(ArrayList<Monitor> monitors) {
        int option=0;
        String message="Select the Professor that you want to update\n\n";
        for (int x=0;x<listProfessor.size();x++){
            message+=x+"). "+listProfessor.get(x).getName()+"         "+listProfessor.get(x).getSubject()+"\n";
        }
        try {
            option=Integer.parseInt(JOptionPane.showInputDialog(message));
            ExceptionInputNum.condition(option,listProfessor.size());
        } catch (ExceptionInputNum ein){
            JOptionPane.showMessageDialog(null, "This is", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Operation with String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }catch (IndexOutOfBoundsException ioobe){
            JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }
        int optionUpdate=JOptionPane.showOptionDialog(
                null,"Select one option", "Options Selector", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,new Object[] {"Name","Subject","Monitor","Salir" },null);
        switch (optionUpdate){
            case 0:listProfessor.get(option).setName(JOptionPane.showInputDialog("Input the new name of the professor"));break;
            case 1:listProfessor.get(option).setSubject(JOptionPane.showInputDialog("Input the new subject of the professor"));break;
            case 3:
                int optionMonitor=0;
                String messageMonitor = "Select the monitor for the teacher\n\n";
                for (int x = 0; x < monitors.size(); x++) {
                    messageMonitor += x+"). " + monitors.get(x).getName() + "         " + monitors.get(x).getCareer() + "\n";
                }
                try {
                    optionMonitor = Integer.parseInt(JOptionPane.showInputDialog(message));
                    ExceptionInputNum.condition(optionMonitor,monitors.size());
                } catch (ExceptionInputNum ein){
                    JOptionPane.showMessageDialog(null, "This is", "Dialogo error", JOptionPane.ERROR_MESSAGE);
                }catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Operation with String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    listProfessor.get(option).setMonitor(monitors.get(optionMonitor));
                } catch(IndexOutOfBoundsException ioobe){
                    JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            }
    }

    @Override
    public void consult() {
        int option=0;
        String message="Select the Monitor that you want to see\n\n";
        for (int x=0;x<listProfessor.size();x++){
            message+=x+"). "+listProfessor.get(x).getName()+"         "+listProfessor.get(x).getSubject()+"\n";
        }
        try {
            option=Integer.parseInt(JOptionPane.showInputDialog(message));
            ExceptionInputNum.condition(option,listProfessor.size());
        } catch (ExceptionInputNum ein){
            JOptionPane.showMessageDialog(null, "This is", "Error Dialog", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Operation with String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            JOptionPane.showMessageDialog(null,"Monitor information\n"+listProfessor.get(option).getName()+"            "+listProfessor.get(option).getSubject()+"          Monitor: "+listProfessor.get(option).getMonitor().getName());
        } catch (IndexOutOfBoundsException ioobe){
            JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


