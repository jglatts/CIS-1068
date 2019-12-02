package glatts_john_assignment_8;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 *  ToDo
 *      - double check if add() can grow dynamically
 *      - get rid of all the try-catches !!!!!!!!!!!!
 *          - try-catches are at toString() and compareTo()
 *      - use a clone() for the add()      
 * 
 * @author johng
 */
public class Glatts_John_Assignment_8 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ///*
        Customer c1 = new Customer("John", "Glatts", "2009 Carmel", "Jamison", "PA", "18929", 1234, 234.00);
        Customer c2 = new Customer("John", "Glatts", "2009 Carmel", "Jamison", "PA", "18929", 1234, 234.00);
        Customer c3 = new Customer("John", "Glatts", "2009 Carmel", "Jamison", "PA", "18929", 1234, 234.00);
        Customer c4 = new Customer("John", "Glatts", "2009 Carmel", "Jamison", "PA", "18929", 1234, 234.00);
        Customer c5 = new Customer("John", "Glatts", "2009 Carmel", "Jamison", "PA", "18929", 1234, 234.00);
        Customer c6 = new Customer("John", "Glatts", "2009 Carmel", "Jamison", "PA", "18929", 1234, 234.00);
        CustomerList cL = new CustomerList(2);
        cL.add(c1);
        cL.add(c2);
        cL.add(c3);
        cL.add(c4);
        cL.add(c5);
        cL.add(c6);
        System.out.println("Testing Add - \n" + cL.toString());
        System.out.println("Testing Size - " + cL.size() + "\n");
        //*/
        
        ///*
        boolean b = false;
        System.out.println("Read file");
        CustomerList cl = CustomerList.read("Customers.csv");
        if(cl != null){
            System.out.println("Read: " + cl.size() + " records");
            cl.sort();
            System.out.println(cl.toString() + "\n\n\n");
        }
        else {
            System.out.println("File read error.");
            return;
        }
        System.out.println("Test get and set for CustomerList");
        System.out.println("x = " + cl.get(0));
        Customer c = cl.get(0);
        c.setFirstName("Homer");
        cl.set(c, 0);
        System.out.println("x = " + cl.get(0));
        System.out.println("\n\n\n");
        cl.sort(); // this was not in the original main, however indexOf must be sorted in order to work (binary search)
        System.out.println("Test indexOf and update");
        System.out.println("idx = " + cl.indexOf(34));
        System.out.println("Customer with id 35 = \n" + cl.get(cl.indexOf(35)));
        b = cl.update(35, 100.0);
        if(b)
            System.out.println("Update successful");
        else
            System.out.println("Update not successful");
        System.out.println("Customer with id 35 = \n" + cl.get(cl.indexOf(35)));
        cl.update(41, 150.0);
        cl.update(59, 200.0);
        cl.update(72, 250.0);
        b = cl.update(350, 100.0);
        if(b)
            System.out.println("Update successful");
        else
            System.out.println("Update not successful. Index 350 does not exisit");
        System.out.println("\n\n\n");
        System.out.println("Test remove");
        System.out.println("x = " + cl.get(1)); // Remove an existing Customer
        c = cl.remove(1);
        if(c != null)
            System.out.println("Deleted\n" + c.toString());
        else
            System.out.println("No Customer deleted");
        c = cl.remove(101);
        if(c != null)
            System.out.println("Deleted\n" + c.toString());
        else
            System.out.println("No Customer deleted. Index 101 does not exisit");
        System.out.println("\n\n\n");
        b = CustomerList.write(cl, "NewCustomers.csv");
        if(b)
            System.out.println("File write successful. New file saved at 'NewCustomers.csv'");
        else
            System.out.println("File write not successful");

        Customer[] array = new Customer[10];
        array[0] = new Customer();  
        //*/
    }
    
    

}
