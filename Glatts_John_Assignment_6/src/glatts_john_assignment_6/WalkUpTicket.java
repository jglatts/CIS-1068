package glatts_john_assignment_6;

public class WalkUpTicket extends Ticket {
    
    public WalkUpTicket(int number) {
        super(number);
        this.price = 50.00;
    }
    
    @Override
    public String toString() {
        return super.toString() + " - Walk Up Ticket";
    }
    
}
