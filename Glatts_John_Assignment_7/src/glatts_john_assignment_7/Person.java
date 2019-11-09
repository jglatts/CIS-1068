package glatts_john_assignment_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {

   private final File famFile; 
   private String name = "";
   private final ArrayList<String> paternalLine = new ArrayList<>();
   private final ArrayList<String> maternalLine = new ArrayList<>();
   private final ArrayList<String> childLine = new ArrayList<>();
   private final ArrayList<String> famList = new ArrayList<>();
   
   /*
        Construct a new Person with the given file
   */
   public Person(File file) {
       famFile = file;
   }     
   
    /*
        Read in the input from the given file and store it in a list
    */  
   public void getFamFile() throws FileNotFoundException {
       Scanner scan = new Scanner(famFile);
       Boolean n = false;
       String check;
       int count = 0;
       while (scan.hasNext()) {
           if (!n) name = scan.nextLine();  
           n = true;
           switch (scan.nextLine()) {
               case "Maternal line:":
                   scan.nextLine(); 
                   check = scan.nextLine();
                   maternalLine.add(check);
                   break;
               case "Paternal line:":
                   scan.nextLine();
                   check = scan.nextLine();
                   paternalLine.add(check);
                   break;
               case "Children:":
                   while (scan.hasNextLine()) {
                    check = scan.nextLine();       
                    childLine.add(check);
                    if (scan.hasNextLine()) childLine.add(", ");
                   }
                   break;
               default:
                   break;
           }
        }
   }   
   
   /*
        Return the person's name
   */
   public String getName() {
       return name;
   }
   
   /*
        Format and print the family line to console
   */
   public void printFamLine() {
       System.out.println("Name = " + name);
       System.out.println("Maternal Line = ");
       System.out.println("\t" + name);
       Boolean check = false;
       for (String m : maternalLine) {
           System.out.println("\t\t" + m);
       }    
       System.out.println("Paternal Line = ");
       System.out.println("\t" + name);
       for (String p : paternalLine) {
           System.out.println("\t\t" + p);
       }
       System.out.println("Children = ");
       for (String c : childLine) {
           if (!check)System.out.print("\t");
           check = true;
           System.out.print(c);
       }    
       System.out.println();
   }
   
}
