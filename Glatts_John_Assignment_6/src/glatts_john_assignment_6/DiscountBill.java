package glatts_john_assignment_6;

public class DiscountBill extends GroceryBill {

    protected boolean isPrefferd;
    protected int count;
    private double totalSavings;
    private double startPrice;
    private double newPrice;
    
    public DiscountBill(Employee clerk, boolean prefferd) {
        super(clerk);
        isPrefferd = prefferd;
        super.discountFlag = true;  
        
    }
    
    /*
        Returns the number of items that were discounted, if any
    */
    public int getDiscountCount() {
        return count;
    }
    
    /*
        Returns the total discount for this list of items, if any
    */
    public double getDiscountAmount() {
        return totalSavings;
    }
    
    
    @Override 
    // Overrides GroceryBill b\c of the discount
    public void addItem(Item i) {
        this.item = i;
        this.allItems += i.itemName + " ";
        if (isPrefferd) {
            this.oldPrices += "$" + i.price + " ";
            this.applyDiscount();
            this.allPrices += "$" + i.price + " ";
        }
        else {
            this.allPrices += "$" + newPrice + " ";
        }
        this.total += i.price;
    }
    
    /*
        Returns the percent of the total discount as a percent of what
        the total would have been otherwise
            - check out chegg
    */
    public double getDiscountPercent() {
        return 0.0;
    }
    
    private void applyDiscount() {
        startPrice = this.item.price;
        newPrice = this.item.price * this.item.getDiscount();
        this.item.price = newPrice;
        totalSavings = startPrice - newPrice;
        count++;    
    }
    
}
