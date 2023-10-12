import java.util.ArrayList;
import java.util.Iterator;

public class CashRegister {
    static ArrayList<Items> itemList;


    public static void main(String[] args) {
        itemList = new ArrayList<Items>();
        ArrayList<HistoryItem> historyItemList = new ArrayList<HistoryItem>();

        CashRegister obj1 = new CashRegister();
        obj1.initialize();
        obj1.displayMenu(itemList);

    }
    public void initialize (){
        Items item1 =  new Items(100, 10, "Pants" );
        Items item2 =  new Items(400, 40, "shoes" );
        Items item3 =  new Items(99, 50, "Shirts" );
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        /*System.out.println("Items List created: " + item1.toString() + " " + item2.toString()
                + " " + item3.toString());*/

    }

    public void displayMenu(ArrayList<Items> itemList) {
        System.out.println("Items available to Purchase: ");
        /*Iterator<Items> iter1 = itemList.iterator();
        while (iter1.hasNext()) {
            System.out.print(iter1.next().getDescription() + " " );
        }
        System.out.println("\t");
        Iterator<Items> iter2 = itemList.iterator();
        while (iter2.hasNext()) {
            System.out.print(iter2.next().getValue() + " " );
        }*/
        while (itemList. > ){

        }
    }



}