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
    
    public static boolean checkY(int yVal) {
        if (yVal < 15) return true;
        if (yVal > 30) return true;
        return false;
    }
    
    public static void vertPrint() {
        for (int i = 0; i < 50; ++i) {
            for (int y = 0; y < 50; ++y) {
                // tweak that alog. baby
                  if (checkY(y)) {
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
        //trippyPrint();
        //vertPrint();
        
        System.out.println("\nEnter Your Name: ");
        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine();  // Read user input
        if (userName.equals("mudbone")) vertPrint(); 
        System.out.println(userName);
    }
    
}
