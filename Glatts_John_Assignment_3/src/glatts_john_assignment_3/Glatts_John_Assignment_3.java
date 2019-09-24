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
 * @duedate 9-27-19
 * 
 */
public class Glatts_John_Assignment_3 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
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
       */
        Scanner pigScanner = new Scanner (System.in);
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
    
    // figure out a way to get this guy working
    public static int findValue(int arr[], int firstValue, String check) {
        int value = 0;
        
        for (int i = 0; i < arr.length; ++i) {
            if (check.equals("lowest")) {
                if (arr[i] < firstValue) value = arr[i];
            }
            else {
                if (arr[i] > firstValue) value = arr[i];
            }
        }
        return value;
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
                - use proper formatting, i.e 4 space width padding    
    */   
    public static void pascalsTriangle() {
        // see if 3 scanner objects are really needed
        Scanner pascalScanner = new Scanner(System.in);
        int  count = 1;
        
        System.out.print("\nThis is the pascalsTriangle program. How many lines of the triangle would you like? ");
        int noRow = pascalScanner.nextInt();
        
        // get proper formatting working 
        for(int i = 0; i < noRow; i++) {
            for(int x = 1; x <= noRow-i; x++) {
                System.out.print(" ");
            }
            for(int j = 0; j <= i; ++j)  {
                if (j==0 || i==0)
                    count = 1;
                else
                   count = (count * (i - j + 1))  /  j;
                System.out.print(" " + count);
            }
           System.out.print("\n");
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
        System.out.print("\nPig Latin = " + translateToPigLatin(str));
    }
    
    // terminate the program when user enters a blank string 
    // get this working
    public static String translateToPigLatin(String str) {
        String outPut = "";
        String segment[] = str.split(" ");
        
        for (int i = 0; i < segment.length; ++i) {
            System.out.println(segment[i] + "");   //debug
            for (int y = 0; y < segment[i].length(); ++y) {
                char segmentIndex = segment[i].charAt(y);
                if (checkForVowel(segmentIndex)) {
                     if (y != 0) {
                            //String toMove = segment[i].substring(0, y);
                            String toMove = segment[i].substring(0, 2); // testing where we should put the substring 
	      String cutHere = segment[i].substring(y, segment[i].length());    // change this back to 2?
                            outPut += swapLetters(cutHere, toMove);
	  }
	  else {
	       outPut += segment[i] + "-ay ";
	  }                    
                }
             }
          }
        return outPut;   
    }  

    // method is working 
    public static boolean checkForVowel(char charSegment) {
        return (charSegment == 'a' || charSegment == 'e' || charSegment == 'i' || charSegment == 'o' || charSegment == 'u'); // maybe clean up, but a nice one-liner 
    }
    
    // seems like this method is working 
    public static String swapLetters(String cut, String move) {
        String returnStr = cut + move + "-ay ";
        return returnStr;
    }
    
}
    

