package glatts_john_assignment_6;

public class Item {
    
    protected String itemName;
    protected double price;
    
    public Item(String item, double price) {
        this.itemName = item;    
        this.price = price;    
    }
    
    public double getPrice() {
        return price;
    }
    
    public double getDiscount() {
        return .5; 
    }
    
    
}
