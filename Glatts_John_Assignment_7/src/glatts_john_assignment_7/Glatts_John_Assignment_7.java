package glatts_john_assignment_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Glatts_John_Assignment_7 {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println();
        checkSwapPairs();
        System.out.println();
        checkDuplicates();
        System.out.println();
        checkStutter();
        System.out.println();
        checkFileReverse();
    }
    
    public static void checkSwapPairs() {
        ArrayList<String> a = new ArrayList<>(); 
        a.add("to");
        a.add("be");
        a.add("or");
        a.add("not");
        a.add("to");
        a.add("be");
        a.add("hamlet");
        printList(a, "List before swapping pairs: ");
        swapPairs(a);
        printList(a, "List after swapping pairs: "); 
    }
    
    public static void swapPairs(ArrayList<String> list) {
        for (int i = 0; i < list.size()-2; i += 2) {
            String first = list.get(i);
            String second = list.get(i+1);
            list.set(i, second);
            list.set((i+1), first);
        }    
    }
    
    public static void printList(ArrayList<String> list, String s) {
        System.out.print(s);
        list.forEach((i) -> {
            System.out.print(i + " ");
        });
        System.out.println();
    }
    
    public static void removeDuplicates(ArrayList<String> list) {
        // add a check for empty strings
        for (int i = 0; i < list.size(); ++i) {
            String base = list.get(i);
            for (int x = i+1; x < list.size(); ++x) {
                String check = list.get(x);
                if (base.equals(check))
                    list.remove(x);
            }
        }
    }
    
    public static void checkStutter() {
        ArrayList<String> a = new ArrayList<>();
        a.add("how");
        a.add("are");
        a.add("you");
        printList(a, "The List before stuttering: ");
        stutter(a, 4);  
        printList(a, "The List after stuttering: ");
    }
    
    public static void stutter(ArrayList<String> list, int k) {
        if (k != 0) {
            for (int i = 0; i < list.size(); ++i) {
                String s = list.get(i);
                for (int x = 0; x < k-1; ++x) 
                    list.add(i++, s);
            }
        }
        else list.removeAll(list);
    }
    
    public static void checkDuplicates() {
        ArrayList<String> a = new ArrayList<>();
        a.add("be");
        a.add("be");
        a.add("is");
        a.add("not");
        a.add("or");
        a.add("question");
        a.add("that");
        a.add("the");
        a.add("to");
        a.add("to");
        printList(a, "The list before removing duplicates: ");
        Collections.sort(a);
        removeDuplicates(a);
        printList(a, "The list after removing duplicates: ");
    }
    
    public static void checkFileReverse() throws FileNotFoundException {
        System.out.println("The Original File = ");
        FileReverse f = new FileReverse(new File("test.txt"));
        f.printFile();
        f.reverse();
        System.out.println("\nThe Reversed File = ");
        f.printFile();
    }
    
}
