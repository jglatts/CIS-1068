package glatts_john_assignment_8;

public class Person {

    private String firstName;
    private String lastName;
    private int address;
    private String city;
    private String state;
    private int zipCode;
    
    /**
     * Parameterized Person Constructor
     * @param f, first name
     * @param l, last name
     * @param a, address
     * @param c, city
     * @param s, state
     * @param z, zip code 
     */
    public Person(String f, String l, int a, String c, String s, int z) {
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
    public String getZipCode() { return zipCode+""; }   
    public int getAddress(boolean check) { 
        return address; 
    }
    public int getZipCode(boolean check) { 
        return zipCode; 
    }
    
    /**
     *  Setters
     */
    public void setFirstName(String s) { this.firstName = s; }
    public void setLastName(String s) { this.lastName = s; }
    public void setAddress(int a) { this.address = a; }
    public void setCity(String s) { this.city = s; }
    public void setState(String s) { this.state = s; }
    public void setZipCode(int z) { this.zipCode = z; }
        
    @Override
    public String toString() {
        String s;
        s = "FirstName: " + firstName + "\n";
        s += "LastName: " + lastName + "\n";
        s += "Address: " + address + "\n";
        s += "City: " + city + "\n";
        s += "State: " + state + "\n";
        s += "ZipCode: " + zipCode + "\n";
        System.out.println(s);
        return s;
    }
    
    /**
     * Format the data to a CSV string
     * @return the CSV string 
     */
    public String toCSV() {
        return firstName + ", " + lastName + ", " + address + ", " + city + ", " + state + ", " + zipCode;
    }
    
    /**
     * Copy the data from p to this Person
     * @param p, person to copy data
     */
    public void copy(Person p) {
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.address = p.getAddress(true);
        this.city = p.getCity();
        this.state = p.getState();
        this.zipCode = p.getZipCode(true);
    }
    
    /**
     * Copy the data passed as arguments to this Person
     * @param f, first name
     * @param l, last name
     * @param a, address
     * @param c, city
     * @param z, zip code
     */
    public void copy(String f, String l, int a, String c, String s, int z) {
        this.firstName = f;
        this.lastName = l;
        this.address = a;
        this.city = c;
        this.state = s;
        this.zipCode = z;   
    }
    
    /**
     * Return a Person with a copy of this data
     * @return new Person object
     * @throws CloneNotSupportedException 
     */
    @Override
    public Person clone() throws CloneNotSupportedException {
        return new Person(firstName, lastName, address, city, state, zipCode);
    }
    
}
