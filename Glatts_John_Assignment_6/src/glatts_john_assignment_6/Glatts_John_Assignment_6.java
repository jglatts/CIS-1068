package glatts_john_assignment_6;

import java.util.Random;

public class Glatts_John_Assignment_6 {

    /*
        Main Driver Function
        ToDo 
            - add prompts at each ex. saying what problem it is 
    */
    public static void main(String[] args) {
        // Ch. 9, 5-7
        checkTicketPrice();
        
        // Ch. 9, 8
        MinMaxAccount a = new MinMaxAccount(new Startup("test"));
        System.out.println("\nThe minimum balance is " + a.getMin() + " pennies");
        System.out.println("The maximum balance is " + a.getMax() + " pennies");

        // Ch. 9, 10
        checkGroceryBill();
    }
    
    public static void checkTicketPrice() {
        Random r = new Random();
        int count = 1;  // change this to a dynamic number 
        double price = Ticket.getPrice();
        switch ((int)price) {
            case 50:
                    WalkUpTicket walkUpTicket = new WalkUpTicket(count);
                    System.out.println(walkUpTicket.toString());
                    break;
            case 40:
                {
                    AdvanceTicket advanceTicket = new AdvanceTicket(count, 7);
                    System.out.println(advanceTicket.toString());
                    break;
                }
            case 30:
                {
                    AdvanceTicket advanceTicket = new AdvanceTicket(count, 12);
                    System.out.println(advanceTicket.toString());
                    break;
                }
            case 20:
                {
                    StudentAdvanceTicket studentAdvanceTicket = new StudentAdvanceTicket(count, 7);
                    System.out.println(studentAdvanceTicket.toString());
                    break;
                }
            case 15:
                {
                    StudentAdvanceTicket studentAdvanceTicket = new StudentAdvanceTicket(count, 12);
                    System.out.println(studentAdvanceTicket.toString());
                    break;
                }
            default:
                {
                    System.out.println("Invalid Ticket Price");
                    break;
                }
        }
    }
    
    public static void checkGroceryBill() {
        GroceryBill g = new GroceryBill(new Employee("Bob"));
        DiscountBill gPoly = new DiscountBill(new Employee("Joe"), true);
        
        // no discount bill
        g.addItem(new Item("apple", .75));
        g.addItem(new Item("orange", .50));
        g.addItem(new Item("steak", 50.00));
        g.addItem(new Item("beer", 15.00));
        g.printReceipt();
        System.out.println("Total Price = $" + g.getTotal() + " - no discount added");
        
        // bill with discounts 
        gPoly.addItem(new Item("milk", 10));
        gPoly.addItem(new Item("eggs", 8));
        gPoly.printReceipt();
        System.out.println("Total Price = $" + g.getTotal() + " - with discount");
    }
    
}
