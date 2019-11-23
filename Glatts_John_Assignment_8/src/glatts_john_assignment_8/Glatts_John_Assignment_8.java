package glatts_john_assignment_8;

import java.io.FileNotFoundException;

/**
 * 
 *  ToDo
 *      - double check if sort() and compareTo() are working right
 *          - sort is NOT WORKING right
 *      - double check if add() can grow dynamically
 * 
 * @author johng
 */
public class Glatts_John_Assignment_8 {

    public static void main(String[] args) throws FileNotFoundException {
        /*
        CustomerList c = CustomerList.read("testCSV.txt");
        System.out.println("\n");   // was getting the error here w/ sort() b/c there was only 1 entry in the list
        System.out.println(c.toString());
        
        //public Customer(String f, String l, String a, String c, String s,  String z, String cID, String g)
        Customer c1 = new Customer("Doug", "Farts", "356 County Line Rd.", "Warminster", "PA", 18974, 30, 698.29);
        Customer c2 = new Customer("Sam", "Farts", "356 County Line Rd.", "Warminster", "PA", 18975, 6, 150.67);
        Customer c3 = new Customer("Monica", "Farts", "356 County Line Rd.", "Warminster", "PA", 18974, 21, 23.7);
        Customer c4 = new Customer("Tom", "Farts", "356 County Line Rd.", "Warminster", "PA", 18974, 9, 13.5);
        Customer c5 = new Customer("Tim", "Farts", "356 County Line Rd.", "Warminster", "PA", 18974, 21, 13.5);
        Customer c6 = new Customer("Denise", "Farts", "356 County Line Rd.", "Warminster", "PA", 18974, 420, 13.5);
        Customer c7 = new Customer("Peter", "Farts", "356 County Line Rd.", "Warminster", "PA", 18974, 2, 13.5);
        CustomerList l = new CustomerList(7);
        l.add(c1);
        l.add(c2);
        l.add(c3);
        l.add(c4);
        l.add(c5);
        l.add(c6);
        l.add(c7);
        l.sort();
        l.write(l, "test_output.txt"); 
        checkRemove();
        checkUpdate();
        */
        checkJUPIN();
    }

    public static void checkRemove() throws FileNotFoundException {
            Customer c1 = new Customer("Doug", "Test", "356 County Line Rd.", "Warminster", "PA", 18974, 30, 698.29);
            Customer c2 = new Customer("Sam", "Test", "356 County Line Rd.", "Warminster", "PA", 18974, 6, 150.67);
            Customer c3 = new Customer("Monica", "Test", "356 County Line Rd.", "Warminster", "PA", 18974, 21, 23.7);
            Customer c4 = new Customer("Pete", "Test", "356 County Line Rd.", "Warminster", "PA", 18974, 2, 23.7);
            CustomerList c = new CustomerList(4);
            c.add(c1);
            c.add(c2);
            c.add(c3);
            c.add(c4);
            c.remove(0);
            c.remove(0);
            c.remove(0);
            c.write(c, "test_output_removed.txt");
    }
    
    public static void checkUpdate() {
            Customer c1 = new Customer("Doug", "Test", "356 County Line Rd.", "Warminster", "PA", 18974, 30, 700.00);
            Customer c2 = new Customer("Sam", "Test", "356 County Line Rd.", "Warminster", "PA", 18974, 6, 150.67); 
            CustomerList c = new CustomerList(4);
            c.add(c1);
            c.add(c2);
            System.out.println("\n\n-----Checking Update Function-----\n");
            System.out.println("Updated GrossSales = " + c1.getGrossSales());
            System.out.println(c.toString());
            c.update(30, 20.50);
            System.out.println("Updated GrossSales(For CustID 30) = " + c1.getGrossSales());
    }
    
    public static void checkJUPIN() throws FileNotFoundException {
        boolean b = false;
         // Read file
         System.out.println("Read file");
         CustomerList cl = CustomerList.read("Customers.csv");
         if(cl != null){
            System.out.println("Read: " + cl.size() + " records");
            cl.sort();
            System.out.println(cl.toString() + "\n\n\n");
         }
         else{
            System.out.println("File read error.");
            return;
         }

         // Test get and set for CustomerList
         System.out.println("Test get and set for CustomerList");
         System.out.println("x = " + cl.get(0));
         Customer c = cl.get(0);
         c.setFirstName("Homer");
         cl.set(c, 0);
         System.out.println("x = " + cl.get(0));
         System.out.println("\n\n\n");

         // Test indexOf and update 
        System.out.println("Test indexOf and update");
        System.out.println("idx = " + cl.indexOf(92));
        System.out.println("Index of 92 = " + cl.indexOf(92));
        System.out.println("Customer with id 92 = \n" + cl.get(cl.indexOf(92)));
                
        // Update an existing Customer
        b = cl.update(92, 100.0); // not updating b/c indexOf() is off
        if(b)
        System.out.println("Update successful");
        else
        System.out.println("Update not successful");
        System.out.println("Customer with id 35 = \n" + cl.get(cl.indexOf(35)));
        cl.update(41, 150.0);
        cl.update(59, 200.0);
        cl.update(72, 250.0);
        // Update a non-existing Customer
        b = cl.update(350, 100.0);
        if(b)
        System.out.println("Update successful");
        else
        System.out.println("Update not successful");
        System.out.println("\n\n\n");

        // Test remove
        System.out.println("Test remove");
        System.out.println("x = " + cl.get(1));
        // Remove an existing Customer
        c = cl.remove(1);
        if(c != null)
        System.out.println("Deleted\n" + c.toString());
        else
        System.out.println("No Customer deleted");
        // Remove an existing Customer
        c = cl.remove(101);
        if(c != null)
        System.out.println("Deleted\n" + c.toString());
        else
        System.out.println("No Customer deleted");
        System.out.println("\n\n\n");

        // Write file
        b = CustomerList.write(cl, "NewCustomers.csv");
        if(b)
        System.out.println("File write successful");
        else
        System.out.println("File write failed");          
    
    }

}
