package Service;

import Exceptions.ExceptionInputNum;
import Model.*;
import Model.Object;

import javax.swing.*;
import java.util.ArrayList;

public class LoanService {
    public ArrayList<Loan> listLoan=new ArrayList<>();
    public void generateProveLoans(ArrayList<Monitor> listMonitors, ArrayList<Student> listStudent, ArrayList<Object> listObject){
        DetalleObject detalleObject1[]={new DetalleObject(listObject.get(0),5),new DetalleObject(listObject.get(1),2)};
        listObject.get(0).setStock(listObject.get(0).getStock()-5);listObject.get(1).setStock(listObject.get(1).getStock()-2);
        listStudent.get(0).setAmoutLoan(listStudent.get(0).getAmoutLoan()+1);
        listLoan.add(new Loan("05/08/2022",10,"79510",listMonitors.get(0),listStudent.get(0),detalleObject1));
        listLoan.get(0).setTotalValue(detalleObject1[0].getObject().getPrice()*detalleObject1[0].getAmount()+detalleObject1[1].getAmount()*detalleObject1[1].getObject().getPrice());
        listMonitors.get(0).setTotalIncomeLoan(listMonitors.get(0).getTotalIncomeLoan()+listLoan.get(0).getTotalValue());
    }
    public void createLoan(ArrayList<Monitor> listMonitors, ArrayList<Student> listStudent, ArrayList<Object> listObject,String beginLoan,int daysLoan,String code){
        int dimention=0;
        try {
            dimention=Integer.parseInt(JOptionPane.showInputDialog("Input the amount of products that you want to loan"));
        }catch (NumberFormatException nfe) {JOptionPane.showMessageDialog(null, "Operation with String", "Dialogo error", JOptionPane.ERROR_MESSAGE);}
        DetalleObject detalleObject[]=new DetalleObject[dimention];
        int selectedObject[]=new int[dimention];
        double totalValue=0;
        String messagedetalle="";
        for (int x=0;x<dimention;x++){
            selectedObject[x]=selectObject(listObject);
            detalleObject[x]=new DetalleObject(listObject.get(selectedObject[x]),selectNumberObject(listObject.get(selectedObject[x])));
            totalValue+=detalleObject[x].getObject().getPrice()*detalleObject[x].getAmount();
            messagedetalle+=detalleObject[x].getObject().getName()+"      unids: "+detalleObject[x].getAmount()+"\n";
        }
        int monitorOption=selectMonitor(listMonitors);int studentOption=selectStudent(listStudent);
        listLoan.add(new Loan(beginLoan,daysLoan,code,listMonitors.get(monitorOption),listStudent.get(studentOption),detalleObject));
        listMonitors.get(monitorOption).setAmountLoan(listMonitors.get(monitorOption).getAmountLoan()+1);
        listMonitors.get(monitorOption).setTotalIncomeLoan(listMonitors.get(monitorOption).getTotalIncomeLoan()+totalValue);
        listStudent.get(studentOption).setAmoutLoan(listStudent.get(studentOption).getAmoutLoan()+1);
        for (int i=0;i<dimention;i++){listObject.get(selectedObject[i]).setAmountLoan(listObject.get(selectedObject[i]).getAmountLoan()+1);}int position=0;
        for (int y=0;y<listLoan.size();y++){
            if (listLoan.get(y).getCode().equalsIgnoreCase(code)){
                position=y;
                break;
            }
        }
        listLoan.get(position).setTotalValue(totalValue);
        JOptionPane.showMessageDialog(null,"Finish loan!\n\nBegin date: "+listLoan.get(position).getBeginLoan()+"\nDays on loan: "+listLoan.get(position).getDaysLoan()+"\nCode: "+listLoan.get(position).getCode()+"\nMonitor: "+listLoan.get(position).getMonitor().getName()+"\nStudent: "+listLoan.get(position).getStudent().getName()+"\n"+messagedetalle+"\nTotal Value: "+listLoan.get(position).getTotalValue());
    }

    public void consultLoanByCode(String code){
        int position=0;
        boolean confirm=false;
        for (int y=0;y<listLoan.size();y++){
            if (listLoan.get(y).getCode().equalsIgnoreCase(code)){
                confirm=true;
                position=y;
                break;
            }
        }
        if(confirm){
            String messagedetalle="";
            for (int x=0;x<listLoan.get(position).getDetalleObjects().length;x++){
                messagedetalle+=listLoan.get(position).getDetalleObjects()[x].getObject().getName()+"      unids: "+listLoan.get(position).getDetalleObjects()[x].getAmount()+"\n";
            }
            JOptionPane.showMessageDialog(null,"Finish loan!\n\nBegin date: "+listLoan.get(position).getBeginLoan()+"\nDays on loan: "+listLoan.get(position).getDaysLoan()+"\nCode: "+listLoan.get(position).getCode()+"\nMonitor: "+listLoan.get(position).getMonitor().getName()+"\nStudent: "+listLoan.get(position).getStudent().getName()+"\n"+messagedetalle+"\nTotal Value: "+listLoan.get(position).getTotalValue());
        }else{
            JOptionPane.showMessageDialog(null,"Loan not found!","Error Dialog",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void amountMonitorLoans(ArrayList<Monitor> listMonitors){
        String message="Amount of loans of monitors:\n\n";
        for (int x=0;x<listMonitors.size();x++){
            message+=listMonitors.get(x).getName()+"       amountLoans: "+listMonitors.get(x).getAmountLoan();
        }
        JOptionPane.showMessageDialog(null,message);
    }

    public void totalIncome(){
        double totalIncomes=0;
        for (int x=0;x<listLoan.size();x++){
            totalIncomes+=listLoan.get(x).getTotalValue();
        }
        JOptionPane.showMessageDialog(null,"The total incomes of the laboratory is: "+totalIncomes);
    }

    public int selectMonitor(ArrayList<Monitor> monitors){
        int monitorOption=0;
        String message = "Select the monitor for the Loan\n\n";
        for (int x = 0; x < monitors.size(); x++) {
            message += x+"). " + monitors.get(x).getName() + "         " + monitors.get(x).getCareer() + "\n";
        }
        try {
            monitorOption = Integer.parseInt(JOptionPane.showInputDialog(message));
            ExceptionInputNum.condition(monitorOption,monitors.size());
        }catch (ExceptionInputNum ein){JOptionPane.showMessageDialog(null, "This is", "Dialogo error", JOptionPane.ERROR_MESSAGE);}
        catch (NumberFormatException nfe) {JOptionPane.showMessageDialog(null, "Operation with String", "Dialogo error", JOptionPane.ERROR_MESSAGE);}
        try {
            System.out.println(monitors.get(monitorOption));
        } catch (IndexOutOfBoundsException ioobe){JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);}
        return monitorOption;
    }

    public int selectStudent( ArrayList<Student> students){
        int studentOption=0;
        String message = "Select the monitor for the Loan\n\n";
        for (int x = 0; x < students.size(); x++) {
            message += x+"). " + students.get(x).getName() + "         " +students.get(x).getCareer() + "\n";
        }
        try {
            studentOption = Integer.parseInt(JOptionPane.showInputDialog(message));
            ExceptionInputNum.condition(studentOption,students.size());
        } catch (ExceptionInputNum ein){
            JOptionPane.showMessageDialog(null, "This is", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Operation with String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            System.out.println(students.get(studentOption));
        } catch (IndexOutOfBoundsException ioobe){
            JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }
        return studentOption;
    }

    public int selectObject(ArrayList<Object> objects){
        int objectOption=0;
        String message = "Select the monitor for the Loan\n\n";
        for (int x = 0; x < objects.size(); x++) {
            message += x+"). " + objects.get(x).getName() + "         " +objects.get(x).getPrice() + "         "+objects.get(x).getType().getUse()+"\n";
        }
        try {
            objectOption = Integer.parseInt(JOptionPane.showInputDialog(message));
            ExceptionInputNum.condition(objectOption,objects.size());
        } catch (ExceptionInputNum ein){
            JOptionPane.showMessageDialog(null, "This is", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Operation with String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            System.out.println(objects.get(objectOption));
        } catch (IndexOutOfBoundsException ioobe){
            JOptionPane.showMessageDialog(null, "This is not a option", "Dialogo error", JOptionPane.ERROR_MESSAGE);
        }
        return objectOption;
    }

    public int selectNumberObject(Object object){
        int numberObject;
        do {
            numberObject=Integer.parseInt(JOptionPane.showInputDialog("Input the number of unids of the object"));
            if(numberObject>object.getStock()){
               JOptionPane.showMessageDialog(null,"The number of unids exceeds the stock of the object");
            }
        }while (numberObject>object.getStock());
        return numberObject;
    }

}
