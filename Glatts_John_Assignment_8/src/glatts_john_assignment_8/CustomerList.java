package glatts_john_assignment_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * CustomerList Class
 *      - Mimics ArrayLists with a few extra features 
 * 
 * 
 * ToDo
 *  - Check all methods for completion
 *  - Make sure the file read/write are working
 *      - seem to be getting a 'off-by-one' error on the write()
 * 
 * @author johng
 */

public class CustomerList {
    
    private int size;
    private int idx = 0;
    private Customer[] custArray;
    
    /**
     * Default Constructor
     * Set the length of array to 4
     */
    public CustomerList() {
        this.size = 4;
        custArray = new Customer[4];
    }
    
    /**
     * CustomerList constructor with int parameter
     * @param i, the size of the new array
     */
    public CustomerList(int i) {
        this.size = i;
        custArray = new Customer[i];
    }
    
    /**
     * @return the arrays size
     */
    public int size() { 
        return size; 
    }
    
    /**
     * Get the customer at the given array, if it exists
     * @param i, the index of the customer in the array
     * @return the customer if it exists, null otherwise
     */
    public Customer get(int i) {
        if (i < size)
            return custArray[i];
        return null;
    }
    
    /**
     * Add a new customer at the given index
     * @param c, the customer to add
     * @param i, the index of to add the customer at
     * @return true if completed, false otherwise
     */
    public boolean set(Customer c, int i) {
        if (i < size) {
            custArray[i] = c;
            return true;
        }            
        return false;
    }
    
    /**
     * Add a new customer to the array
     * If the array is full, make a new array twice the size 
     * and transfer the data
     * 
     *  - DOUBLE CHECK THIS GUY
     * 
     * @param c, the customer to add
     */
    public void add(Customer c) {
        Customer[] tempArray;
        if(custArray[size-1] == null) {
            custArray[idx] = c;
            idx++;
        }
        else {
            int lastIndex = findLastIndex();
            size *= 2;
            tempArray = new Customer[size];
            tempArray = custArray;
            custArray = new Customer[size];
            custArray = tempArray;
            custArray[lastIndex] = c;
        }
    }
    
    /**
     * Find the the last index of array that has a value
     * This method is used when making a new array
     * @return the index of the last value in array
     */
    private int findLastIndex() {
        int count = 0;
        for (int i = 0; i < size; ++i) {
            if (custArray[i] != null)
                count = i;
        }
        return count;
    }
    
    /**
     * Remove the customer at the given index from the list
     * @param i, the index to remove the customer
     * @return the customer if completed, null otherwise
     * 
     *  ToDo
     *      - change the size of the array after a remove() is called
     *          - i.e, swawp every value to i+1 indices
     * 
     */
    public Customer remove(int i) {
        if (i < findLastIndex()) {
            Customer t = custArray[i];
            custArray[i] = null;
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
    
    /**
     * Read a file that contains a CSV string
     * Instantiate a new Customer with the CSV string and add them to the list
     * 
     * @param fileName, the file to read
     * @return the newList if completed, null otherwise
     * @throws FileNotFoundException 
     */
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
    
    /**
     * Write the current CustomerList to the given file
     * @param cList, the CustomerList to write to file
     * @param f, the file to write to
     * @return true if completed, false otherwise
     * @throws FileNotFoundException 
     */
    public boolean write(CustomerList cList, String f) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File(f));
        try {
            for (int i = 0; i < cList.size(); ++i) {
                output.println(cList.get(i).toCSV());
            }    
            return true;
        } catch(Exception e) {
            System.out.println("Something went wrong :(" + e);
        }        
        return false;
    }
    
    /**
     * Sort the CustomerList by CustomerID
     * 
     * ----NOT WORKING----
     * 
     */
    public void sort() {
        Arrays.sort(custArray);
    }
    
    /**
     * Find the index of a Customer with the CustomerID as the argument
     * @param i, the customerID to look for
     * @return the index if it is found, the new added index if it was not found
     * 
     *  ----ToDo----
     *      -  add the new value if it doesn't already exist
     *      -  then update the array (change its size/indices etc...)
     * 
     */
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
