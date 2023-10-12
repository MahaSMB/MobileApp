import java.time.LocalDateTime;
public class HistoryItem extends Items {
    LocalDateTime time;
    HistoryItem(){

    }
    HistoryItem(float value, int quantity, String description, LocalDateTime time){
        this.setValue(value);
        this.setQuantity(quantity);
        this.setDescription(description);
        this.time = time;
    }
}