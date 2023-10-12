/*
Maha Basheikh
Lab 2
September 12, 2023
 */
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
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getDescription() {
        return description;
    }
}