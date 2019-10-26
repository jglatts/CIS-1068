package glatts_john_assignment_6;

public class Glatts_John_Assignment_6 {

    public static void main(String[] args) {
        WalkUpTicket test = new WalkUpTicket(123);
        AdvanceTicket n = new AdvanceTicket(124, 13);
        StudentAdvanceTicket x = new StudentAdvanceTicket(125, 9);
        System.out.println("\n" + test.toString());
        System.out.println("\n" + n.toString());
        System.out.println("\n" + x.toString());
    }
    
}
