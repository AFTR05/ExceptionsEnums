package Controller;

import Model.Loan;
import Model.Monitor;
import Service.impl.MonitorService;
import Service.impl.ProfessorService;
import Service.impl.StudentService;
import javax.swing.*;
import java.util.ArrayList;
public class FunctionPerson {
    public MonitorService monitorService=new MonitorService();
    public ProfessorService professorService=new ProfessorService();
    public StudentService studentService=new StudentService();
//monitor------------------------------------------------------------------------------------------------------------------------------------------------------
    public void prepareGenerateMonitor(){
        monitorService.GenerateProveMonitor();
    }
    public void prepareCreateMonitor(){monitorService.createMonitor(JOptionPane.showInputDialog("Input the name of the monitor"),JOptionPane.showInputDialog("Input the career of the monitor"),Integer.parseInt(JOptionPane.showInputDialog("Input the age in the company of the monitor")));}
    public void prepareDeleteMonitor(){monitorService.deleteObject();}
    public void prepareUpdateMonitor(){monitorService.update();}
    public void prepareConsultMonitor(){monitorService.consult();}
    public void preparetotalSalary(){monitorService.totalSalary();}
//Student---------------------------------------------------------------------------------------------------------------------------------------------------
    public void prepareGenerateStudent(){
        studentService.GenerateProveStudent();
    }
    public void prepareCreateStudent(){studentService.createStudent(JOptionPane.showInputDialog("Input the name of the student"),JOptionPane.showInputDialog("Input the career of the student"));}
    public void prepareDeleteStudent(){studentService.deleteObject();}
    public void prepareUpdateStudent(){studentService.update();}
    public void prepareConsultStudent(){studentService.consult();}
    public void prepareAmountLoanStudent(){studentService.amountLoanStudent();}
//professor-------------------------------------------------------------------------------------------------------------------------------------------------
    public void prepareGenerateProfessor(ArrayList<Monitor> listMonitors){professorService.generateProveProfessor(listMonitors);}
    public void prepareCreateProfessor(ArrayList<Monitor> listMonitors){professorService.createProfessor(JOptionPane.showInputDialog("Input the name of the professor"),JOptionPane.showInputDialog("Input the subject of obove teacher"),listMonitors);}
    public void prepareDeleteProfessor(){professorService.deleteObject();}
    public void prepareUpdateProfessor(ArrayList<Monitor> listMonitors){professorService.update(listMonitors);}
    public void prepareConsultProfessor(){professorService.consult();}
}
