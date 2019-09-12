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
        for (int i = 0;  i < 30 ; ++i) {
            for (int j = 0; j < i; ++j) {
                System.out.print("****");
            }
           System.out.println("");   // throw a new line in there
        }
        // rev. the pattern
        for (int x = 30;  x > 0 ; --x) {
            for (int z = 0; z < x; ++z) {
                System.out.print("**||**");
            }
           System.out.println("");   // throw a new line in there
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("\n\n\nEnter Your Name: ");
        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine();  // Read user input
        if ( userName.equals("mudbone")) trippyPrint();
        System.out.println(userName);
    }
    
}
