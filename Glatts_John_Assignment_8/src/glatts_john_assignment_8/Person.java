package glatts_john_assignment_8;

/**
 * Person Class
 *  - Contains data for other classes to inherit
 * @author johng
 */
public class Person {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    
    /* Constructer that accecpts a CVS string */
    public Person(String s) { }    
    
    /* Default Constructor */
    public Person() {}
    
    /**
     * Parameterized Person Constructor
     * 
     * @param f, first name
     * @param l, last name
     * @param a, address
     * @param c, city
     * @param s, state
     * @param z, zip code 
     */
    public Person(String f, String l, String a, String c, String s, String z) {
        this.firstName = f;
        this.lastName = l;
        this.address = a;
        this.city = c;
        this.state = s;
        this.zipCode = z;
    }
    
    /**
     *  Getters
     */
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address+""; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipCode() { return zipCode; }   
    
    /**
     *  Setters
     */
    public void setFirstName(String s) { this.firstName = s; }
    public void setLastName(String s) { this.lastName = s; }
    public void setAddress(String a) { this.address = a; }
    public void setCity(String s) { this.city = s; }
    public void setState(String s) { this.state = s; }
    public void setZipCode(String s) { this.zipCode = s; }
        
    @Override
    public String toString() {
        String s = "FirstName: " + firstName + "\n";
        s += "LastName: " + lastName + "\n";
        s += "Address: " + address + "\n";
        s += "City: " + city + "\n";
        s += "State: " + state + "\n";
        s += "ZipCode: " + zipCode + "\n";
        return s;
    }
    
    /**
     * Format the data to a CSV string
     * 
     * @return the CSV string 
     */
    public String toCSV() {
        return firstName + "," + lastName + "," + address + "," + city + "," + state + "," + zipCode;
    }
    
    /**
     * Copy the data from p to this Person
     * 
     * @param p, person to copy data
     */
    public void copy(Person p) {
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.address = p.getAddress();
        this.city = p.getCity();
        this.state = p.getState();
        this.zipCode = p.getZipCode();
    }
    
    /**
     * Copy the data passed as arguments to this Person
     * 
     * @param f, first name
     * @param l, last name
     * @param a, address
     * @param c, city
     * @param z, zip code
     */
    public void copy(String f, String l, String a, String c, String s, String z) {
        this.firstName = f;
        this.lastName = l;
        this.address = a;
        this.city = c;
        this.state = s;
        this.zipCode = z;   
    }
    
    /**
     * Return a Person with a copy of this data
     * 
     * @return new Person object
     * @throws CloneNotSupportedException 
     */
    @Override
    public Person clone() throws CloneNotSupportedException {
        return new Person(firstName, lastName, address, city, state, zipCode);
    }
    
}
