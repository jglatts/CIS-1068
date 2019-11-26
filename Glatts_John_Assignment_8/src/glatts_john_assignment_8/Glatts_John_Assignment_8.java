package glatts_john_assignment_8;

import java.io.FileNotFoundException;

/**
 * 
 *  ToDo
 *      - double check if add() can grow dynamically
 *      - get rid of all the try-catches 
 * 
 * @author johng
 */
public class Glatts_John_Assignment_8 {

    public static void main(String[] args) throws FileNotFoundException {
        checkJUPIN();
    }

    public static void checkJUPIN() throws FileNotFoundException {
        boolean b = false;
        // Read file
        System.out.println("Read file");
        CustomerList cl = CustomerList.read("Customers.csv");
        if(cl != null){
            cl.sort();
            System.out.println("Read: " + cl.size() + " records");
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
        System.out.println("idx = " + cl.indexOf(35));
        System.out.println("Customer with id 35 = \n" + cl.get(cl.indexOf(35)));
        // Update an existing Customer
        b = cl.update(35, 100.0);
        if (b) System.out.println("Update successful");
        else System.out.println("Update not successful");
        System.out.println("Customer with id 35 = \n" + cl.get(cl.indexOf(35)));
        cl.update(41, 150.0);
        cl.update(59, 200.0);
        cl.update(72, 250.0);
        // Update a non-existing Customer
        b = cl.update(350, 100.0);
        if(b)
            System.out.println("Update successful");
        else
            System.out.println("Update not successful. There is no CustomerID #" + 350);
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
        // Remove a non-existing Customer
        c = cl.remove(101);
        if(c != null)
        System.out.println("Deleted\n" + c.toString());
        else
        System.out.println("No Customer deleted. Index #101 is null");
        System.out.println("\n\n\n");
        // Write file
        b = CustomerList.write(cl, "NewCustomers.csv");
        if(b)
            System.out.println("File write successful. Wrote " + cl.size() + " records to 'NewCustomers.csv'");
        else
            System.out.println("File write failed"); 
    }

}
