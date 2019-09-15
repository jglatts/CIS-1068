/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package work_ant_cmon;

import java.util.Scanner;


/**
 *
 * @author User
 */
public class Work_Ant_Cmon {
    
    public static int SIZE = 300;
    
    public static void trippyPrint() {
        for (int c = 0; c < 5; ++c) {
         for (int i = 0;  i < 20 ; ++i) {
            for (int j = 0; j < i; ++j) {
                System.out.print("**||**");
            }
           System.out.println("");   // throw a new line in there
        }
        // rev. the pattern
        for (int x = 20;  x > 0 ; --x) {
            for (int z = 0; z < x; ++z) {
                System.out.print("**||**");
            }
           System.out.println("");   // throw a new line in there
        }
            System.out.println("\n");
        }
    }
    
    public static boolean yValCheck(int yVal) {
        if (yVal < (SIZE / 10)) return true;
        if (yVal < (SIZE / 3) && yVal > (SIZE / 5)) return true;
        if (yVal > (SIZE / 2.5) && yVal < (SIZE / 2)) return true;
        if (yVal > (SIZE / 1.6) && yVal < (SIZE / 1.4)) return true;
        if (yVal > (SIZE / 1.25)) return true;
        
        return false;
    }
    
    public static void vertPrint() {
        String check = " ";

        for (int i = 0; i < SIZE; ++i) {
            for (int y = 0; y < SIZE; ++y) {
                // tweak that alog. baby
                  if (yValCheck(y)) {
                      System.out.print("*");
                  } 
                  else {
                      System.out.print(" ");
                  }
                  //System.out.print("" + y + "");
            }
           System.out.println(" ");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String userName;
        
        do {
                 System.out.println("\nEnter Your Name: ");
                 Scanner scan = new Scanner(System.in);
                 userName = scan.nextLine();  // Read user input
        }  while (userName.equals("mudbone") == false);
        
        vertPrint();
        System.out.println("\n\n---------------------------------------------------");
        System.out.println("*\n*\n*\n*\n*\n*\t\t" + "Writen By: Mudbone xD" + "\n*\n*\n*\n*\n*\n*\n*\n*\n*");
        System.out.println("---------------------------------------------------");
    }
    
}
