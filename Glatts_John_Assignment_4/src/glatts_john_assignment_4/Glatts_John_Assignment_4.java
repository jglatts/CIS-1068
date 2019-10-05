package glatts_john_assignment_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Glatts_John_Assignment_4 {
    
    public static final String numbersPath = "numbers.txt";

    public static final String tokenPath = "tokens.txt";
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(numbersPath));
        Scanner statsScanner = new Scanner(new File(tokenPath));
        evenNumbers(scanner, numbersPath.length());
        System.out.println("Stats-File has " + getStats(statsScanner) + " lines of text ");
     }

    /* 
            Parse a file and find all the numbers inside
            Display various stats about the file
    */
    public static void evenNumbers(Scanner scanner, int size) {
        int[] allValues = new int[size+1]; 
        int index = 0;  
        while (scanner.hasNextInt()){
            allValues[index] = scanner.nextInt();
            index++;
        }
        printNumberInfo(allValues, index);
    }
    
    /* 
            Print info from the numbers file
    */
    public static void printNumberInfo(int[] allValues, int index) {
        int evens = countEvens(allValues, index);
        System.out.printf("\n"+index + " numbers, sum = " + getSum(allValues));
        System.out.print(", " + evens + " evens " );
        // convert to %
        System.out.printf( "%.2f" , getPercent(evens, index));
        System.out.print("%\n\n");
    }
    
    /* 
            Return the sum of values from the text file 
    */    
    public static int getSum(int[] values) {
        int count = 0;
        for (int i = 0; i < values.length; ++i) {
            count += values[i];
        }
        return count;    
    }

    /* 
            Count amount of even numbers from text file 
    */      
    public static int countEvens(int[] values, int size) {
        int evenCount = 0;
        for (int i = 0; i < size; ++i) {
            if (values[i] % 2 == 0) 
                evenCount++;
        }
        return evenCount;    
    }
    
    
    /* 
            Return the percent of even numbers from text file  
   */     
    public static double getPercent(int evenCount, int size) {
        return (double)evenCount / (double)size ;
    }
    
    /* 
           Parse a text file with strings and display stats 
    */      
    public static int getStats(Scanner statsScanner) {
        int count = 0;
        while (statsScanner.hasNextLine()) {
                String str = statsScanner.nextLine(); 
                System.out.print("Line #" + count + " has " + examineTokens(str) + " tokens, " + "longest = " + getLongestToken(str));
                System.out.println("");
                count++;
        }
        return count;
    }
    
    
    /* 
           Find the number of tokens on each line 
    */      
    public static int examineTokens(String str) {
        String[] strSplit = str.split(" "); // getting the right values now 
        return strSplit.length;
    }
    
     /* 
            Find the longest loken of the line 
    */     
    public static int getLongestToken(String str) {
        String[] strSplit = str.split(" ");
        int count = 0, longest = strSplit[0].length();
        for (int i = 0; i < strSplit.length; ++i) {
            if (strSplit[i].length() >= longest) {
                    longest = strSplit[i].length();
                    count = longest;
            }
        }
        return count;
    }
    
   /* 
    public static double stdDev(int[] values) {
        double sd = 0;
        double average = 0.0;
        for (int i = 0; i < values.length; i++) {
            sd += square(values[i] - average) / values.length;
        }
        return math.sqrt(sd);
    }
*/
}
