/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glatts_john_assignment_3;

import java.util.Scanner;

/**
 *
 * @author John Glatts
 * @duedate 9-20-19
 * 
 */
public class Glatts_John_Assignment_3 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner pigScanner = new Scanner (System.in);
        System.out.println("\nFraction sum of " + 15 + " = " + fractionSum(15));
        //smallestLargest(scanner); // test this with some randomly gen. int's
        System.out.println("\nBinary represention of: " + 44 + " is " + toBinary(44));
        System.out.println("\nBinary represention of: " + 420 + " is " + toBinary(420));
        showTwos(7);
        showTwos(18);
        showTwos(24);
        showTwos(188);
        System.out.println("\n\nPascals Triangle");
        // tweak both of these
        pascalsTriangle();
        System.out.println("\n\n");
        pigLatin(pigScanner);
       
    }
    
    /*  
        Accept an integer parameter and return the sum of the first n terms of the sequence
    */
    public static double fractionSum(int fracValue) {
        double sum = 0;
        
        for (int i = 1; i <= fracValue; ++i) {
            sum = sum + 1.0 /  i;
        }
        
        return sum;
    }
    
     /*  
        Prompt the user how many integers they would like to enter
        Scan each integer in and then find the smallest and largest values
    */
    public static void smallestLargest(Scanner scanner) {
        
        System.out.print("\nHow many numbers would you like to enter?  ");
        int numberLimit = scanner.nextInt();
        int[] inputArray = new int[numberLimit];
        
        for (int i = 0; i < numberLimit; ++i) {
            System.out.print("Enter number ----->  ");
            inputArray[i] = scanner.nextInt();
            System.out.println("");
        }
        
        System.out.println("Smallest Number = " + getSmallestNumber(inputArray));
        System.out.println("Largest Number = " +   getLargestNumber(inputArray));
        
    }
    
    /*  
        Find and return the smallest number entered by the user
    */    
    public static int getSmallestNumber(int array[]) {
        int smallest = array[0];
        
        for (int i = 0; i < array.length; ++i) {
            if (array[i] < smallest) smallest = array[i];
        }
        
        return smallest;
    }
    
     /*  
        Find and return the largest number entered by the user
    */     
    public static int getLargestNumber(int array[]) {
        int largest = array[0];
        
        for (int i = 0; i < array.length; ++i) {
             if (array[i] > largest) largest = array[i];
        }
        
        return largest;
    }
    
     /*  
          Accept an integer as a paramter and return the binary value  
    */         
    public static String toBinary(int intValue) {
        return (String)Integer.toBinaryString(intValue);
    }
    
     /*  
           Format and print pascals triangle  
                - the values seem to be right, but the formatting is way off
    */   
    public static void pascalsTriangle() {

        int noRow = 11,  c = 1;
        for(int i = 0; i < noRow; i++) {
            for(int blk = 1; blk<= noRow-i; blk++)
            System.out.print(" ");
            for(int j = 0; j <= i; ++j)  {
                if (j==0 || i==0)
                    c=1;
                else
                   c = (c * (i - j + 1))  /  j;
                System.out.print(" " + c);
            }
           if (i != noRow-1) System.out.print("\n");
        }    
        
    }
    
     /*  
          Compute the factors of 2 for an integer parameter  
    */      
    public static void showTwos(int value) {
        System.out.print("\nFactors of 2 for: " + value + " = ");
        while (value % 2 == 0) {
            System.out.print("2 * ");
            value /= 2;
        }
        System.out.println(value);
    }
 
     /*  
          Prompt the user to enter a string to convert to pig latin
          and print the converted string
    */          
    public static void pigLatin(Scanner scanner) {
        System.out.print("\nEnter a string to be converted to pig latin: ");
        String str = scanner.nextLine();
        System.out.print("\nPig Latin = " + convertToPigLatin(str));
    }

     /*  
          Accept the user's string as a parameter and convert it to pig latin
          return the converted string
                
                    - Get this working and then clean up in helper functions !!
                    - It's close but still got some work to do     
    */        
    public static String convertToPigLatin(String str) {
        char[] vowels = new char[] { 'a', 'e', 'i', 'o', 'u' };
        String[] consonants = new String[] {"th", "ch", "sh"};
        String[] strArray = str.split(" ");  
        String[] newString = new String[strArray.length];   // double check this size 
        int[] positionArray = new int[strArray.length];   // double check this size 
        int index= 0;
        String pigLatin = "";
                
        for (int z = 0; z < strArray.length; ++z) {
              for (int y = 0; y < consonants.length; ++y) {
                  // lil hairy here
                  if (strArray[z].startsWith(consonants[y])) {
                      // now this is'nt working :(
                      newString[z] = strArray[z].substring(2)+strArray[z].substring(0,2)+"-ay " ;
                      positionArray[z] = z; // flag the position of the changed word
                  }
                 else newString[z] = strArray[z] + "-ay";    
              }
        }    
        
        for (int i = 0; i < strArray.length; ++i) {
              for (int x = 0; x < vowels.length; ++x) {
                  if (strArray[i].charAt(0) == vowels[x])  strArray[i] += "-ay ";   // hunting the vowels
              }
        }
        
        // populate the pigLatin string
        // getting a null for some of the values 
        for (int t = 0; t < strArray.length; ++t) {
            System.out.println(strArray[t] + "");
            if (t != positionArray[index]) {
                pigLatin += strArray[t] + " ";
            }
            else {
                pigLatin += newString[index] + " ";
            }
            index++;
        }
        
        return pigLatin += "\n";
    
    }
}

