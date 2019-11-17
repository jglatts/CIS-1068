package glatts_john_assignment_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class CustomerList {
    
    private int size;
    private int idx = 0;
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
            if (idx < size) {
                custArray[idx] = c;
                idx++;
            }    
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
            // call a method to tweak the Array here
            return t;
        }    
        return null;
    }
    
    @Override
    public String toString() {
        String s = "";
        double total = 0;
        for (Customer c : custArray) {
            s += c.toString();
            total += c.getGrossSales();
        }
        return s + " Total Gross Sales = " + total;
    }
    
    public static CustomerList read(String fileName) throws FileNotFoundException {
        File custInput = new File(fileName);
        Scanner scan = new Scanner(custInput);
        CustomerList newList = new CustomerList((int)custInput.length());
        if (custInput.exists()) {
            while (scan.hasNextLine()) {
                try {
                    String csv = scan.nextLine();
                    Customer c = new Customer(csv);
                    newList.add(c);
                } catch(Exception e) {
                    System.out.println("Something went wrong :(");
                }
            }
        return newList;    
        }
        else return null;
    }
    
    public boolean write(CustomerList cList, String f) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File(f));
        try {
            for (int i = 0; i < cList.size(); ++i) {
                output.println(cList.get(i).toCSV());
            }    
            return true;
        } catch(Exception e) {
            System.out.println("Something went wrong :(");
        }        
        return false;
    }
    
    public void sort() {
        Arrays.sort(custArray);
    }
    
    public int indexOf(int i) {
        this.sort();    
        int l = 0, r = custArray.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
            if (custArray[m].getCustomerID() == i) 
                return m; 
            if (custArray[m].getCustomerID() < i) 
                l = m + 1; 
            else
                r = m - 1; 
        } 
        return -1;
    }
            
}
