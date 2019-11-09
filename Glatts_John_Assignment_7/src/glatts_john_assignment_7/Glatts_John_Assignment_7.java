package glatts_john_assignment_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Glatts_John_Assignment_7 {

    /*
        Main Driver Function
    */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Welcome to Exercise 2: swapPairs \nThis program will switch the order of each of the pairs in a ArrayList, "
        + "\nstarting with the first two, then next two, and so on.");
        ArrayList<String> l1 = new ArrayList<>();
        l1.add("to");
        l1.add("be");
        l1.add("or");
        l1.add("not");
        l1.add("to");
        l1.add("be");
        l1.add("hamlet");
        System.out.println("Original ArrayList: " + l1.toString());
        swapPairs(l1);
        System.out.println("Swapped Array: " + l1.toString());
        
        System.out.println("\nWelcome to Exercise 7: removeDuplicates");
        System.out.println("This program will take in a sorted ArrayList and remove all duplicates from the list");
        ArrayList l2 = new ArrayList<>();
        l2.add("be");
        l2.add("be");
        l2.add("is");
        l2.add("not");
        l2.add("or");
        l2.add("question");
        l2.add("that");
        l2.add("the");
        l2.add("to");
        l2.add("to");
        System.out.println("Original ArrayList: " + l2.toString());
        removeDuplicates(l2);
        System.out.println("Removed Duplicates: " + l2.toString());
        
        System.out.println("\nWelcome to Excerisie 11: stutter accepts an ArrayList of strings and an integer, "
        + "\nand replaces every string with that number of itself."
        + "If the integer is less than 1,it should clear the list");
        ArrayList<String> l3 = new ArrayList<>();
        l3.add("how");
        l3.add("are");
        l3.add("you");
        System.out.println("Original Arraylist: " + l3.toString());
        stutter(l3, 4);
        System.out.println("stutter ArrayList (integer = 4): " + l3.toString());
        stutter(l3, -1);
        System.out.println("stutter ArrayList (integer = -1): " + l3.toString());
        
        System.out.println();
        checkFileReverse();
        System.out.println();
        checkFamLine();        
    }
    
    /*
        Swap the adjancent pairs of the given list
    */
    public static void swapPairs(ArrayList<String> list) {
        for (int i = 0; i < list.size()-2; i += 2) {
            String first = list.get(i);
            String second = list.get(i+1);
            list.set(i, second);
            list.set((i+1), first);
        }    
    }
    
    /*
        Print the current list
    */    
    public static void printList(ArrayList<String> list, String s) {
        System.out.print(s);
        list.forEach((i) -> {
            System.out.print(i + " ");
        });
        System.out.println();
    }
    
    /*
        Remove any duplicate values from the list
    */
    public static void removeDuplicates(ArrayList<String> list) {
        for (int i = 0; i < list.size(); ++i) {
            String base = list.get(i);
            for (int x = i+1; x < list.size(); ++x) {
                String check = list.get(x);
                if (base.equals(check))
                    list.remove(x);
                }
            }
    }
    
    /*
        Print each value of the list, k,  times
        If k < 0, remove all values
    */    
    public static void stutter(ArrayList<String> list, int k) {
        if (k > 0) {
            for (int i = 0; i < list.size(); ++i) {
                String s = list.get(i);
                for (int x = 0; x < k-1; ++x) 
                    list.add(i++, s);
            }
        }
        else list.removeAll(list);
    }
    
    /*
        Check the FileReverse class/methods
    */    
    public static void checkFileReverse() throws FileNotFoundException, IOException {
        FileReverse f = new FileReverse(new File("input_file.txt"));
        System.out.println("Programming Project 2: Reverse a file");
        System.out.println("The Original File Contains = ");
        f.printFileString();
        f.reverse();
        System.out.println("-----------------------------File is Reversed-----------------------------");
        System.out.println("The Reversed File is saved at '" + f.getReversedFileName() + "'");
        f.reverseLines();
        System.out.println("The Reversed File (with the order swapped!) is saved at '" + f.getSwappedFileName() + "'");
    }
    
    /*
        Check the Person class/methods
    */     
    public static void checkFamLine() throws FileNotFoundException {
        Person p = new Person(new File("king_henry.txt"));  
        Person j = new Person(new File("john_fam.txt"));
        System.out.println("Programming Project 3: Family Tree");
        p.getFamFile();
        p.printFamLine();
        System.out.println();
        j.getFamFile();
        j.printFamLine();
    }
    
}
