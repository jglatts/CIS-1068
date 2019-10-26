package glatts_john_assignment_6;

public class StudentAdvanceTicket extends AdvanceTicket {
    
    public StudentAdvanceTicket(int number, int daysAdvance) {
        super(number, daysAdvance);
        price /= 2;

    }
    
    @Override
    public String toString() {
        return super.toString() + " (ID required)";
    }    
    
}
