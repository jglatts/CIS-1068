package glatts_john_assignment_6;

import java.util.Scanner;

public class Ticket {

    public double price;
    private final int number;
    
    public Ticket(int number) {
        this.number = number;    
    }
    
    public void getPrice() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nPlease enter the ticket price: ");
        double p = scan.nextDouble();
        this.price = p;
    }
    
    @Override
    public String toString() {
        return "Ticket Number: " + number + ", Price: " + price;
    }
    
}
