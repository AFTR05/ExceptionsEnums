package Controller;

import Service.ObjectService;

public class FunctionObject {
    ObjectService objectService=new ObjectService();
    public void prepareGenerateProveObjects(){
        objectService.generateProveObjects();
    }
}
