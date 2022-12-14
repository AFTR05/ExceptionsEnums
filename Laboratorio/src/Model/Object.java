package Model;

public class Object {
    private String name;
    private String code;
    private Type type;
    private int stock;
    private int amountLoan;

    private boolean status;

    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getAmountLoan() {
        return amountLoan;
    }

    public void setAmountLoan(int amountLoan) {
        this.amountLoan = amountLoan;
    }

    public Object(String name, String code, Type type, int stock, double price) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.stock = stock;
        this.amountLoan = 0;
        this.price=price;
        this.status=true;
    }
}
