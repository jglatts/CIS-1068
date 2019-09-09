/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import java.util.Random; 

/**
 *
 * @author User
 */
public class Main {

    public static void sortMe(int[] arr) {
        int temp;
        
        for (int i=0; i<arr.length; ++i) {
            for (int j=0; j<arr.length - 1;++j) {
                // clean this up
                if (arr[j] > arr[j+1]) {
                        temp = arr[j]; 
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
        }
    }
}        
    
    public static void printMe(int[] arr, String dir) {
        if (dir.equals("fwd")) {
            for (int i=0;i<arr.length;++i) {
                System.out.println(arr[i]);
            }        
        }
        else {
             for (int i=arr.length-1;i>0;--i) {
                System.out.println(arr[i]);
            }            
        }
    }
    
    public static void genNumbers(int[] arr) {
        Random rand = new Random();
        
        for (int i = 0; i< 15; ++i) {
            arr[i] = rand.nextInt(1000);
        }
    }   
    
    public static void logInfo(String dir) {
        System.out.println("\n\n\n\n\n");
        System.out.println("--------------------------------------");
        System.out.println(dir.equals("rev") ? "Reversing the Array......." : "Populating the Array......." );
        System.out.println("--------------------------------------");
        System.out.println("\n\n\n\n\n");
    }
    
    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = new int[15];
        logInfo("fwd");
        genNumbers(arr);
        sortMe(arr);
        printMe(arr, "fwd");
        logInfo("rev");
        sortMe(arr);
        printMe(arr, "rev");
    }
} 
