package Model;

public class DetalleObject {
    private Object object;
    private int amount;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public DetalleObject(Object object, int amount) {
        this.object = object;
        this.amount = amount;
    }
}
