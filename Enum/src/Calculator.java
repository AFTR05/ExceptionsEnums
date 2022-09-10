public class Calculator {
    private int operando1;
    private int operando2;

    public int sumar(){
        return operando1+operando2;
    }

    public int restar(){
        return operando1-operando2;
    }

    public float dividir(){
        return operando1/operando2;
    }

    public float multiplicar(){
        return operando1*operando2;
    }

    public float getOperando1() {
        return operando1;
    }

    public void setOperando1(int operando1) {
        this.operando1 = operando1;
    }

    public float getOperando2() {
        return operando2;
    }

    public void setOperando2(int operando2) {
        this.operando2 = operando2;
    }

    public void setOperandos(int operando1,int operando2){
        this.operando1=operando1;
        this.operando2=operando2;
    }
}
