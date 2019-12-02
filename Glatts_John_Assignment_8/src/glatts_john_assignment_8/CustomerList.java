package glatts_john_assignment_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
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
 *  - Work o Sorting Algs.
 *  
 *  - Add update(id, amt) function
 *      - pass in  custID and amount to add to grossSales
 * 
 * @author johng
 */
public class CustomerList {
    
    private int size;
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
        int count = 0;
        for (Customer c : custArray)
            if (c != null)
                count++;
        size = count;
        return size;
    }
    
    /**
     * Get the customer at the given array, if it exists
     * @param i, the index of the customer in the array
     * @return the customer if it exists, null otherwise
     */
    public Customer get(int i) {
        if (i < size) return custArray[i];        
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
     * @param c, the customer to add
     */
    public void add(Customer c) {
        if(custArray[size-1] == null) addCustomer(c);
        else makeTempArrayAdd(c);
    }
    
    /**
     * Find the first empty index in the list and add the new customer
     * 
     * @param c, the customer to add 
     */
    private void addCustomer(Customer c) {
        for (int i = 0; i < size; ++i) {
            if (custArray[i] == null) {
                custArray[i] = c;
                break;
            }    
        }    
    }
    
    /**
     * Make a new array twice the size of OG and insert new value
     * 
     * @param c, the customer to add 
     */
    private void makeTempArrayAdd(Customer c) {
        size *= 2;
        Customer[] tempArray = new Customer[size];
        updateTemp(tempArray, c);
        updateCustArray(tempArray);
    } 
    
    /**
     * Update the temp. array, by copying all the info over
     * 
     * @param temp, the temp array
     * @param c, the customer to add
     */
    private void updateTemp(Customer[] temp, Customer c) {
        int count = 0;
        for (int i = 0; i < size/2; ++i) {
            temp[i] = custArray[i];
            count = i;
        }    
        temp[count+1] = c;
    }
    
    /**
     * Update the actual CustomerArray 
     * 
     * @param temp, the temp array to copy from
     */
    private void updateCustArray(Customer[] temp) {
        custArray = new Customer[size];
        for (int x = 0; x < size; ++x) {
            custArray[x] = temp[x];
        }    
    }

    /**
     * Remove the customer at the given index from the list
     * 
     * @param i, the index to remove the customer
     * @return the customer if completed, null otherwise
     */
    public Customer remove(int i) {
        if (i == (size-1)) return removeLastElement(i);
        if (i < size) return removeAndUpdate(i);
        return null;
    }    
    
    /**
     * Remove the customer at the last index, no array update required
     * 
     * @param i, the index to remove
     * @return the customer deleted
     */
    private Customer removeLastElement(int i) {
        Customer c = custArray[i];
        custArray[i] = null;
        size--;
        return c;
    }
    
    /**
     *  Remove a customer and update the size of the array
     * 
     * @param i
     * @return the customer deleted 
     */
    private Customer removeAndUpdate(int i) {
        Customer c = custArray[i];
        custArray[i] = null;
        size--;
        for (int x = i; x < size; ++x) {
            custArray[x] = custArray[x+1];
        } 
        return c;    
    }
    
    @Override
    public String toString() {
        String s = "";
        double total = 0;
        for (Customer c : custArray) {
            if (c != null) {
                s += c.toString();
                total += c.getGrossSales();
            }
        }        
        return s + "Total Gross Sales = " + total;
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
        try { return readFile(fileName); } 
        // change this to a general Exception??
        catch (FileNotFoundException e) {
            System.out.println("File doesnt exist. Please try again.");
            return null;
        }
    }
    
    /**
     * Scan through a file and add new customers to the list
     * 
     * @param scan, scanner object
     * @param c, the new customerList
     * @param f, the file to read
     * @return the customerList containing the new customers
     */
    private static CustomerList readFile(String fileName) throws FileNotFoundException {
        File custInput = new File(fileName);
        Scanner scan = new Scanner(custInput);
        CustomerList newList = new CustomerList((int)custInput.length()); // get the right value here, way off
        int size = 0;
        scan.nextLine();  
        while (scan.hasNextLine()) {
            size++;
            newList.add(new Customer(scan.nextLine()));                
        }    
        newList.size = size;    
        return newList;          
    }
    
    /**
     * Write the current CustomerList to the given file
     * 
     * @param cList, the CustomerList to write to file
     * @param f, the file to write to
     * @return true if completed, false otherwise
     * @throws FileNotFoundException 
     */
    public static boolean write(CustomerList cList, String f) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File(f));
        output.println("CustomerID, GrossSales, FirstName, LastName, Address, City, State, ZipCode");
        boolean check = false;
        for (int i = 0; i < cList.size(); ++i) {
            output.println(cList.get(i).toCSV());
            check = true;
        } 
        return check;
    }
    
    /**
     * Sort the CustomerList by CustomerID
     */
    public void sort() {
        for (int i = 0; i < size-1; ++i) {
            for (int x = 0; x < size-i-1; ++x) {
                if (custArray[x].compareTo(custArray[x+1]) > 0) {
                    Customer temp = custArray[x+1];
                    custArray[x+1] = custArray[x];
                    custArray[x] = temp;                
                } 
            }
        }        
    }
    
    /**
     * Find the index of a Customer with the CustomerID as the argument
     * 
     * @param i, the customerID to look for
     * @return the index if it is found, the new added index if it was not found
     * 
     *  ----ToDo----
     *      -  add the new value if it doesn't already exist
     *          - and return the insertion point
     */
    public int indexOf(int i) {
        return findIndexOf(i, 0, size-1);
    }
    
    /**
     *  Recursive binary search method to locate the index of a CustomerID 
     * 
     * @param i, the CustomerID
     * @param left, the left partition of array
     * @param right, the right partition of array
     * @return the index of the CustomerID, -1 if it DNE
     */
    private int findIndexOf(int i, int left, int right) {
        if (right >= left) {
            int mid = left + (right-left) / 2;
            if (custArray[mid].getCustomerID() == i) return mid;
            if (i > custArray[mid].getCustomerID()) return findIndexOf(i, mid + 1, right);
            else return findIndexOf(i, left, mid-1);     
        }
        return -1;
    }

    /**
     *  Update the grossSales of a given customer
     * 
     * @param id, the customerID
     * @param amount, the amount to add to grossSales
     * @return true if successful, false otherwise
     */
    public boolean update(int id, double amount) {
        int idx = indexOf(id);
        if (idx > 0) {
            custArray[idx].setGrossSales(custArray[idx].getGrossSales() + amount);
            return true;                
        }        
        return false;
    }
            
}