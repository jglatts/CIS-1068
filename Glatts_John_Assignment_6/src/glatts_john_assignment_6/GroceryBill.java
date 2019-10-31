package glatts_john_assignment_6;

public class GroceryBill {
    
    private final String clerkName;
    protected String allItems = "";
    protected String allPrices = "";
    protected String oldPrices = "";
    protected double total;
    protected boolean discountFlag = false;
    protected Item item;
    
    public GroceryBill(Employee clerk) {
        clerkName = clerk.name;
    }
    
    public void addItem(Item i) {
        this.item = i;
        allItems += i.itemName + " ";
        allPrices += "$" + i.price + " ";
        total += i.price;
    }
    
    public double getTotal() {
        return total;
    }
    
    public void printReceipt() {
        String[] items = allItems.split(" ");
        String[] prices = allPrices.split(" ");
        String[] printOldPrices = oldPrices.split(" ");         
        System.out.println();
        for (int i = 0; i < items.length; ++i) {
            if (discountFlag) {
                System.out.printf("Item %2d = %6s %6s = %6s -- full price = %6s\n", (i+1), items[i], "Price", prices[i], printOldPrices[i]);
            }
            else
                System.out.printf("Item %2d = %6s %6s = %6s\n", (i+1), items[i], "Price", prices[i]);
        }
    } 
    
}