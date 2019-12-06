package glatts_john_assignment_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * CustomerList Class
 *      - Mimics ArrayLists with a few extra features 
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
    public int size() { return size; }
    
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
        Customer[] tempArray = new Customer[size*2];
        updateTemp(tempArray, c);
    } 
    
    /**
     * Update the temp. array, by copying all the info over
     * 
     * @param temp, the temp array
     * @param c, the customer to add
     */
    private void updateTemp(Customer[] temp, Customer c) {
        int i;
        for (i = 0; i < size; ++i) {
            temp[i] = custArray[i];
        }    
        temp[i+1] = c;
        updateCustArray(temp);
    }
    
    /**
     * Update the actual CustomerArray 
     * 
     * @param temp, the temp array to copy from
     */
    private void updateCustArray(Customer[] temp) {
        size *= 2;
        custArray = new Customer[size];
        custArray = temp;
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
     * @return the newList if completed, null if read() fails
     * @throws FileNotFoundException 
     */
    public static CustomerList read(String fileName) throws FileNotFoundException {
        try { return readFile(fileName); }
        catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException occured. Please make sure the file exists and try again.");
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
        File input = new File(fileName);
        Scanner scan = new Scanner(input);
        CustomerList newList = new CustomerList(readLines(input));
        newList.size = readLines(input)-1;
        scan.nextLine(); // get rid of first line in input
        while (scan.hasNextLine()) {
            newList.add(new Customer(scan.nextLine()));                
        }
        return newList;
    }
    
    /**
     * Count the lines in the file using Scanner
     * 
     * @param scan, scan object with a file
     * @return amount of lines in file
     */
    private static int readLines(File f) throws FileNotFoundException {
        Scanner scan = new Scanner(f);
        int count = 0;
        while (scan.hasNextLine()) {
            count++;
            scan.nextLine(); 
        }    
        return count;
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
        boolean check = false;
        PrintStream output = new PrintStream(new File(f));
        output.println("CustomerID,GrossSales,FirstName,LastName,Address,City,State,ZipCode");
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
            for (int x = 0; x < size-i-1; ++x)
                if (custArray[x].compareTo(custArray[x+1]) > 0)
                    swap(x+1, x);
        }        
    }

    /**
     *  Swap the customers in smallest->largest order
     * 
     * @param valOne, value to swap
     * @param valTwo , value to swap
     */
    private void swap(int valOne, int valTwo) {
        Customer temp = custArray[valOne];
        custArray[valOne] = custArray[valTwo];
        custArray[valTwo] = temp;       
    }
    
    /**
     * Find the index of a Customer with the CustomerID as the argument
     * 
     * @param i, the customerID to look for
     * @return the index if it is found
     */
    public int indexOf(int i) {
        this.sort();
        return findIndexOf(i, 0, size-1);
    }
    
    private int findInsertionIndex(int value) {
        int n = 0;
        for (int i = 0; i < size-1; ++i) {
            if (custArray[i].getCustomerID() < value && custArray[i+1].getCustomerID() > value) {
                return i;
            }
        }
        return n;
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
        int newIdx;
        if (idx > 0) {
            custArray[idx].setGrossSales(custArray[idx].getGrossSales() + amount);
            return true;                
        } else System.out.println("DEBUG--THE INSERTION POINT IS: " + findInsertionIndex(id));
        return false;
    }
            
}