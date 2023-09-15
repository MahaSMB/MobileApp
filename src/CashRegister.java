import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
/*
Maha Basheikh
Lab 2
September 12, 2023
 */
public class CashRegister {
    static ArrayList<Items> itemList;
    static ArrayList<HistoryItem> historyItemList;
    int  userQuantity;
    int  userIndex;

    public static void main(String[] args) {
        itemList = new ArrayList<Items>();
        historyItemList = new ArrayList<HistoryItem>();
        CashRegister obj1 = new CashRegister();
        obj1.initialize();
        obj1.displayMenu(itemList);
        obj1.purchase(obj1.userIndex,obj1.userQuantity);
    }
    public void initialize (){
        Items item1 =  new Items(100, 10, "Pants" );
        Items item2 =  new Items(400, 40, "shoes" );
        Items item3 =  new Items(99, 50, "Shirts" );
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
    }

    public void displayMenu(ArrayList<Items> itemList) {
        System.out.println("Items available to Purchase: ");
        boolean entry = false;
        Scanner input = new Scanner(System.in);
        while(!entry){
            int i=0;
            for(Items it : itemList){
                System.out.println(i+"."+ " Item name:"+it.getDescription()+
                        "\tItem Price:"+it.getValue());
                i++;
            }
            System.out.println("What do you want to buy? Choose an option");
            userIndex = input.nextInt();
            if(userIndex>=i){
                System.out.println("Invalid entry. Please try again");
            }else{
                entry = true;
            }
        }
        System.out.println("How many "+itemList.get(userIndex).getDescription()+
                " do you want?");
        userQuantity = input.nextInt();
        input.close();
    }

    public void purchase(int itemIndex, int quantity){
        //calculating total cost
    float price = itemList.get(itemIndex).getValue();
    float totalCost = price*quantity;

    //updating the inventory
    int newQuantity = itemList.get(itemIndex).getQuantity() - quantity;
    itemList.get(itemIndex).setQuantity(newQuantity);
    System.out.println("Updated Quantity is:"+ newQuantity);

    //record history
        LocalDateTime myDateObj = LocalDateTime.now();
        //System.out.println(myDateObj);
        HistoryItem historyItem = new HistoryItem(totalCost, quantity, itemList.get(itemIndex).getDescription(), myDateObj);
        historyItemList.add(historyItem);

        System.out.println("Total Purchase cost is: "+totalCost);
    }
    public void viewHistory(){
        System.out.println("Purchase History:");
        for(HistoryItem it : historyItemList){
            System.out.println("Item Name: "+it.getDescription()+"\nQuantity: "+
                    it.getQuantity()+"\nTotal Cost: "+it.getValue()+"\nTime: "+it.getTime());
        }
    }
}