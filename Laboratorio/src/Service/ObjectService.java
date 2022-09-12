package Service;

import Model.Object;
import Model.Type;

import javax.swing.*;
import java.util.ArrayList;

public class ObjectService {
    public ArrayList <Object> listObject=new ArrayList<>();
    public void generateProveObjects(){
        listObject.add(new Object("Ficha automovil","98165", Type.FICHAS,30,1000));
        listObject.add(new Object("Metal floor","61425",Type.PIEZAS_METAL,10,5000));
        listObject.add(new Object("Race wheel","31521",Type.RUEDAS,100,500));
    }

    public void createObject(String name,String code,int optionType,int stock,double price){
        Type type=null;
        switch (optionType){
            case 0:type=Type.FICHAS;break;
            case 1:type=Type.PIEZAS_METAL;break;
            case 2:type=Type.ESFERAS;break;
            case 3:type=Type.RUEDAS;break;
        }
        listObject.add(new Object(name,code,type,stock,price));
    }

    public void consultDataByCode(String code){
        boolean confirm=false;
        for (int x=0;x<listObject.size();x++){
            if(listObject.get(x).getCode().equalsIgnoreCase(code)){
                confirm=true;
                if (listObject.get(x).getStatus()){
                    JOptionPane.showMessageDialog(null,"Object found!\n\n"+"Name: "+listObject.get(x).getName()+"\nCode: "+listObject.get(x).getCode()+"\nStock: "+listObject.get(x).getStock()+"\nPrice: "+listObject.get(x).getPrice()+"\nType_Use: "+listObject.get(x).getType().getUse()+"\nType_Position: "+listObject.get(x).getType().getPosition()+"\nAmount of Loans: "+listObject.get(x).getAmountLoan());
                }else{
                    JOptionPane.showMessageDialog(null,"Object Found!\n\nThis object is inactive because its stock is 0");
                }
            }
        }
        if (!confirm){
            JOptionPane.showMessageDialog(null,"The object with this code does not exist");
        }
    }

    public void consultDataByName(String name){
        boolean confirm=false;
        for (int x=0;x<listObject.size();x++){
            if(listObject.get(x).getName().equalsIgnoreCase(name)){
                confirm=true;
                if (listObject.get(x).getStatus()){
                    JOptionPane.showMessageDialog(null,"Object found!\n\n"+"Name: "+listObject.get(x).getName()+"\nCode: "+listObject.get(x).getCode()+"\nStock: "+listObject.get(x).getStock()+"\nPrice: "+listObject.get(x).getPrice()+"\nType_Use: "+listObject.get(x).getType().getUse()+"\nType_Position: "+listObject.get(x).getType().getPosition()+"\nAmount of Loans: "+listObject.get(x).getAmountLoan());
                }else{
                    JOptionPane.showMessageDialog(null,"Object Found!\n\nThis object is inactive because its stock is 0");
                }
            }
        }
        if (!confirm){
            JOptionPane.showMessageDialog(null,"The object with this code does not exist");
        }
    }

    public void updateInformation(){
            for (int x=0;x<listObject.size();x++){
                if (listObject.get(x).getStock() == 0){
                    listObject.get(x).setStatus(false);
                }
            }
    }
}
