package Controller;

import Model.Type;
import Service.ObjectService;

import javax.swing.*;

public class FunctionObject {
    public ObjectService objectService=new ObjectService();
    public void prepareGenerateProveObjects(){
        objectService.generateProveObjects();
    }

    public void prepareCreateObject(){
        String name= JOptionPane.showInputDialog("Input the name of the object");
        String code=JOptionPane.showInputDialog("Input the code of the object");
        int optionType=JOptionPane.showOptionDialog(
                null,"Select one type", "Options Selector", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,    // null para icono por defecto.
                new Object[] { "FICHAS","PIEZAS_METAL", "ESFERAS", "RUEDAS"},null);
        int stock=0;double price=0;
        try {stock=Integer.parseInt(JOptionPane.showInputDialog("Input the stock of the object"));} catch (NumberFormatException nfe){JOptionPane.showMessageDialog(null, "Operation with String", "Dialogo error", JOptionPane.ERROR_MESSAGE);}
        try {price=Double.parseDouble(JOptionPane.showInputDialog("Input the price of the object"));}catch (NumberFormatException nfe){JOptionPane.showMessageDialog(null, "Operation with String", "Dialogo error", JOptionPane.ERROR_MESSAGE);}
        objectService.createObject(name,code,optionType,stock,price);
    }

    public void prepareConsultDataByCode(){
        String code=JOptionPane.showInputDialog("Input the code of the object that you want to consult");
        objectService.consultDataByCode(code);
    }

    public void prepareConsultDataByName(){
        String name=JOptionPane.showInputDialog("Input the name of the object that you wanna found");
        objectService.consultDataByName(name);
    }
    public void prepareUpdateInformation(){objectService.updateInformation();}
}
