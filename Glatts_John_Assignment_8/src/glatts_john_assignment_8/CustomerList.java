package glatts_john_assignment_8;

public class CustomerList {
    
    private int size;
    private Customer[] custArray;
    
    public CustomerList() {
        this.size = 4;
        custArray = new Customer[4];
    }
    
    public CustomerList(int s) {
        this.size = s;
        custArray = new Customer[size];
    }
    
    public int size() { 
        return size; 
    }
    
    public Customer get(int i) {
        if (i < (size-1))
            return custArray[i];
        return null;
    }
    
    public boolean set(Customer c, int i) {
        if (i < (size-1)) {
            custArray[i] = c;
            return true;
        }            
        return false;
    }
    
    public void add(Customer c) {
        Customer[] tempArray;

        if(custArray[size-1] == null) {
            custArray[size-1] = c;
        }
        else {
            // prolly have to tweak this
            int lastIndex = findLastIndex();
            size *= 2;
            tempArray = new Customer[size];
            tempArray = custArray;
            custArray = new Customer[size];
            custArray = tempArray;
            custArray[lastIndex] = c;
        }
    }
    
    private int findLastIndex() {
        int count = 0;
        for (int i = 0; i < size; ++i) {
            if (custArray[i] != null)
                count = i;
        }
        return count;
    }
    
    public Customer remove(int i) {
        if (i < findLastIndex()) {
            // have to do more here, tweak the array 
            Customer t = custArray[i];
            custArray[i] = null;
            return t;
        }    
        return null;
    }
            
}
