/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelloWorld;

/**
 *
 * @author John Glatts
 * @due-date 
 */
public class Main {

    /* Format and print the letter H to console */    
    public static void printH() {
        System.out.println("\nH\tH");
        System.out.println("H\tH");
        System.out.println(" HHHHHHH");
        System.out.println("H\tH");
        System.out.println("H\tH");
    }
    
    /* Format and print the letter E to console */    
    public static void printE() {
        System.out.println("\nEEEEEEEEE");
        System.out.println("E");
        System.out.println("EEEEE");
        System.out.println("E");
        System.out.println("EEEEEEEEE");

    }
    
    /* Format and print the letter L to console */    
    public static void printL() {
        System.out.println("\nL");
        System.out.println("L");
        System.out.println("L");
        System.out.println("L");
        System.out.println("LLLLLLLLL");
    }
    
    /* Format and print the letter O to console */
    public static void printO() {
        System.out.println("\nOOOOOOOOO");
        System.out.println("O\tO");
        System.out.println("O\tO");
        System.out.println("O\tO");
        System.out.println("O\tO");
        System.out.println("OOOOOOOOO");
    }
        
    /* Format and print a comma to console */
    public static void printComma() {
        System.out.println("\n\n\n\n,,");
        System.out.println(",");
    }

    /* Format and print the letter W to console */
    public static void printW() {
        System.out.println("W\tWW\tW");
        System.out.println("W\tWW\tW");
        System.out.println("   WW       WW  ");
        System.out.println("   WW       WW  ");
        System.out.println("    W     W   ");
    }
    
    /* Format and print the letter R to console */
    public static void printR() {
        System.out.println("\nRRRRRRR");
        System.out.println("R\tR");
        System.out.println("RRRRRRR");
        System.out.println("R\tR");
        System.out.println("R      R");
    }
    
    /* Format and print the letter D to console */
    public static void printD() {
        System.out.println("\nDDDDDDDD");
        System.out.println("D\tD");
        System.out.println("D\tD");
        System.out.println("D\tD");
        System.out.println("D    D");
    }
    
    /* Format and print exclamation point to console */
    public static void printPoint() {
        System.out.println("\n!!");
        System.out.println("!!");
        System.out.println("!!");
        System.out.println(" ");    // blank line
        System.out.println("!!");
    }
    
    /* Call all helper fn()s and print to console */
    public static void printHelloWorld() {
        printH();
        printE();
        printL();
        printL();
        printO();
        printComma();
        printW();   
        printO();
        printR();
        printL();
        printD();
        printPoint();    
    }
    
    public static void bubbleSort(int arr[]) {
        // bubble sort bish
        int temp;
        // i may have to be 1
        for (int i = 1; i < arr.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[j] > arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
    /* Program entry point */
    public static void main(String[] args) {
        //printHelloWorld();
        int arr[] = {0, 100, 45, 67, 99, 69, 420, 66, 77, 39};
        bubbleSort(arr);
        // print the sorted array 
        for (int i=0;i<arr.length;++i) {System.out.println(arr[i]);};
    }
}
