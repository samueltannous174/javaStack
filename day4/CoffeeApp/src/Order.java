import java.util.ArrayList;
public class Order{
    private String name;
    private double total;
    private boolean ready;
    ArrayList<Item> items;

    public Order(String name){
        this.name = name;
        this.total = 0.0;
        this.ready = false;
        this.items = new ArrayList<Item>();
    }

    public void addItems(Item item){
        this.items.add(item);
        total += item.getPrice();
    }
    public ArrayList<Item> getList(){
       return items;
    }
    public double getTotal(){
        return total;

    }
    @Override
    public String toString() {
        return "Order [list=" + items + ", total=" + total+ "]";
    }



}