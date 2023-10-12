public class Items {
    private float value;
    private int quantity;
    private String description;
    Items(){

    }
    Items(float value, int quantity, String description) {
        this.value = value;
        this.quantity = quantity;
        this.description = description;
    }    public float
    getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return ("\nItem name " + this.description + "\tQuantity: " + this.quantity
                + "\t Price " + value);
    }
}