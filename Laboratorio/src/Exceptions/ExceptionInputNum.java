package Exceptions;

public class ExceptionInputNum extends Exception{
    public ExceptionInputNum(String msg) {
        super(msg);
    }

    public static void condition(int option,int size) throws ExceptionInputNum {
        if (option>size) {
            throw new ExceptionInputNum("The number is not a option");
        }
    }
}
