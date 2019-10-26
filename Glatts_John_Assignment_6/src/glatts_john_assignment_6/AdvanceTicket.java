package glatts_john_assignment_6;

public class AdvanceTicket extends Ticket {
    
    public int daysAdvanced;
    
    public AdvanceTicket(int number, int daysAdvanced) {
        super(number);
        this.daysAdvanced = daysAdvanced;
        evaluatePrice();
    }
    
    private double evaluatePrice() {
        if (daysAdvanced > 10) price = 30.00;
        else price = 40.00;
        return price;
    }
    
    @Override
    public String toString() {
        return super.toString() + " - Advanced Ticket, " + daysAdvanced + " days in advanced";
    }
}
