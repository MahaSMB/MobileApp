import java.time.LocalDateTime;
/*
Maha Basheikh
Lab 2
September 12, 2023
 */
public class HistoryItem extends Items {
    LocalDateTime time;
    HistoryItem(){
    }
    HistoryItem(float value, int quantity, String description, LocalDateTime time){
        this.setQuantity(quantity);
        this.time = time;
    }
    public LocalDateTime getTime() {
        return time;
    }
}