package glatts_john_assignment_6;

public class MinMaxAccount {
    
    private final int max;
    private final int min;
    
    // may have to add the extra classes 
    public MinMaxAccount(Startup startup) {
        this.max = startup.max;
        this.min = startup.min;
    }
    
    public int getMax() {
        return max;
    }
    
    public int getMin() {
        return min;
    }    
    
    
}
