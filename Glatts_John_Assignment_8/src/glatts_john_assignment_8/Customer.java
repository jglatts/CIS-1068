package glatts_john_assignment_8;

public class Customer extends Person implements Comparable{
    
    private int customerID;
    private double grossSales;
    
    /***** Add the Default Constructors *****/
    
    public Customer(String f, String l, int a, String c, String s,  int z, int cID, double g) {
        super(f, l, a, c, s, z);
        this.customerID = cID;
        this.grossSales = g;
    }
    
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
        String s;
        s = "CustomerID: " + customerID + "\n";
        s += "GrossSales: " + grossSales + "\n";
        s += super.toString();
        return s;
    }
    
    @Override
    public String toCSV() {
        return customerID + ", " + grossSales + ", " + super.toCSV();
    }
    
    public int compareTo(Customer c) {
        if (this.customerID > c.getCustomerID()) return -1;
        if (this.customerID < c.getCustomerID()) return 1;
        return 0;
    }
    
    public void copy(Customer c) {
        this.customerID = c.getCustomerID();
        this.grossSales = c.getCustomerID();
        super.setFirstName(c.getFirstName()); 
        super.setLastName(c.getLastName());
        super.setAddress(c.getAddress(true));
        super.setCity(c.getCity());
        super.setZipCode(c.getZipCode(true));
    }
    
    public void copyCSV(String s) {
        String[] data = s.split(", ");
        this.customerID = Integer.parseInt(data[0]);
        this.grossSales = Double.parseDouble(data[1]);
        super.setFirstName(data[2]);
        super.setLastName(data[3]);
        super.setAddress(Integer.parseInt(data[4]));
        super.setCity(data[5]);
        super.setState(data[6]);
        super.setZipCode(Integer.parseInt(data[7]));
    }
    
    @Override
    public Customer clone() throws CloneNotSupportedException {
        return new Customer(super.getFirstName(), super.getLastName(), super.getAddress(true), 
                            super.getCity(), super.getState(), super.getZipCode(true), customerID, grossSales);
    }

    @Override
    public int compareTo(Object t) {
        Customer c = (Customer)t;
        if (this.customerID > c.getCustomerID()) return -1;
        if (this.customerID < c.getCustomerID()) return 1;
        return 0;
    }
    
}
