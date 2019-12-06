package glatts_john_assignment_8;

/**
 * Customer Class
 *  - Inherits Person and uses the Comparable interface
 * 
 * ------ToDo------
 *      - get the compareTo() working
 *      - double check all methods
 * 
 * @author johng
 */
// implents Comparable<Person>!!!
public class Customer extends Person implements Comparable<Customer>{
    
    private int customerID;
    private double grossSales;
    
    /**
     * Constructor with all the data passed in as parameters
     * 
     * @param f, firstName of customer
     * @param l, lastName of customer
     * @param a, address of customer
     * @param c, city of customer
     * @param s, state of customer
     * @param z, zipCode of customer
     * @param cID, customerID of customer
     * @param g, grossSales of customer 
     */
    public Customer(String f, String l, String a, String c, String s,  String z, int cID, double g) {
        super(f, l, a, c, s, z);
        this.customerID = cID;
        this.grossSales = g;
    }
    
    /**
     * Constructor with a CSV string as a parameter
     * 
     * @param s, the CSV string containing all necessary data
     */
    public Customer(String s) {
        super(s);  
        this.copyCSV(s);
    }
    
    /* Default Constructor */
    public Customer() {}
    
    /**
     * Getters
     */
    public int getCustomerID() { return customerID; }
    public double getGrossSales() { return grossSales; }
    
    /**
     * Setters
     */
    public void setCustomerID(int c) { this.customerID = c; }
    public void setGrossSales(double d) { this.grossSales = d; }

    @Override
    public String toString() {
        String s = "CustomerID: " + customerID + "\nGrossSales: $" + 
                    grossSales + "\n" + super.toString();
        return s + "\n";
    }
    
    /**
     * @return the customer's full name 
     */
    public String getName() {
        return super.getFirstName() + " " + super.getLastName();
    }
    
    @Override
    public String toCSV() {
        return customerID + "," + grossSales + "," + super.toCSV();
    }

    /**
     * Compare the current Customer to the Customer passed as a parameter
     * Check which one has the smaller customerID number
     * 
     * @param c, the Customer to compare to
     * @return the value indicating which customer ID is smaller
     */    
    public int compareTo(Customer c) {
        if (customerID > c.getCustomerID()) return 1;
        if (customerID < c.getCustomerID()) return -1; 
        return 0;
    }
    
    /**
     * Copy Customer data passed as a parameter to the this current Customer 
     * 
     * @param c, the Customer to copy data from
     */
    public void copy(Customer c) {
        this.customerID = c.getCustomerID();
        this.grossSales = c.getCustomerID();
        super.setFirstName(c.getFirstName()); 
        super.setLastName(c.getLastName());
        super.setAddress(c.getAddress());
        super.setCity(c.getCity());
        super.setZipCode(c.getZipCode());
    }
    
    /**
     * Given a CSV string as a parameter, extract all the necessary data from it
     * 
     * @param s, the CSV string
     */
    public void copyCSV(String s) {
        String[] data = s.split(",");
        this.customerID = Integer.parseInt(data[0]);
        this.grossSales = Double.parseDouble(data[1]);
        super.setFirstName(data[2]);
        super.setLastName(data[3]);
        super.setAddress(data[4]);
        super.setCity(data[5]);
        super.setState(data[6]);
        super.setZipCode(data[7]);
    }
    
    @Override
    public Customer clone() throws CloneNotSupportedException {
        return new Customer(super.getFirstName(), super.getLastName(), super.getAddress(), 
                            super.getCity(), super.getState(), super.getZipCode(), customerID, grossSales);
    }
    
}
