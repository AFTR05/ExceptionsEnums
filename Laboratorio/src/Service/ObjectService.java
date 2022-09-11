package Service;

import Model.Object;
import Model.Type;

import java.util.ArrayList;

public class ObjectService {
    ArrayList <Object> listObject=new ArrayList<>();
    public void generateProveObjects(){
        listObject.add(new Object("Ficha automovil","98165", Type.FICHAS,30,1000));
        listObject.add(new Object("Metal floor","61425",Type.PIEZAS_METAL,10,5000));
        listObject.add(new Object("Race wheel","31521",Type.RUEDAS,100,500));
    }
}
