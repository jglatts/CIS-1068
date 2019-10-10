package glatts_john_assignment_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
        
public class Glatts_John_Assignment_4 {
    
    public static final String numbersPath = "numbers.txt";
    public static final String tokenPath = "tokens.txt";
    public static final String storyPath = "story.txt";
    
    /*
    
    ToDo:
        - output file for new story + a scanner option asking about it
        - prompts + clean up the output
    
    */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(new File(numbersPath));
        Scanner statsScanner = new Scanner(new File(tokenPath));
        Scanner storyScanner = new Scanner(new File(storyPath));
        int[] devArray = new int[]{1, -2, 4, -4, 9, -6, 16, -8, 25, -10}; 
        evenNumbers(scanner, numbersPath.length());
        System.out.println("Stats-File has " + getStats(statsScanner) + " lines of text\n");
        System.out.println("Std-Dev is: " + stdDev(devArray) + "\n");   // add a prompt for this
        generateMatrices();
        startStory(storyScanner);
        // have to add the myers bridge thing 
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
        System.out.println("\nLooking at 'numbers.txt'");
        System.out.printf("\t-File has "+index + " numbers, sum = " + getSum(allValues));
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
        // double check this guy to make sure it's in percent form
        return ((double)evenCount / (double)size) * 100;
    }
    
    /* 
           Parse a text file with strings and display stats 
                - need to find and print largest line
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
        Find and return the standard deviation from a given array
    */
    public static double stdDev(int[] values) {
        // getting something, but its not right     
        double sd = 0;
        int average = getSum(values) / values.length;
        System.out.println("The average value of the array is: " + average);
        for (int i = 0; i < values.length; i++) {
            sd += Math.pow(values[i] - average, 2) / values.length;
        }
         return Math.sqrt(sd);
     }
    
     /*
        Generate two 2D arrays, i.e 2 matrices
        2 x 7
    */
    public static void generateMatrices() {
        int[][] arrOne = new int[][] {
            new int[] { 1, 2, 3, 7, 12, 20, 69 },
            new int[] { 1, 2, 3, 7, 12, 20, 69 },
            new int[] { 1, 2, 3, 7, 12, 20, 69 },
        };
        int[][] arrTwo = new int[][] {
            new int[] { 1, 2, 3, 7, 12, 20, 69 },
            new int[] { 1, 2, 3, 7, 12, 20, 69 },
            new int[] { 1, 2, 3, 7, 12, 20, 69 },
        };       
        addMatrices(arrOne, arrTwo);
    }
    
     /*
        Add both matrices together
    */
    public static void addMatrices(int[][] arrOne, int[][] arrTwo) {
        int sizeOne = arrOne.length;
        int sizeTwo = arrOne[0].length;
        int[][] arrThree = new int[sizeOne][sizeTwo];
        // add the 2 matrices 
        for (int i = 0; i < sizeOne; ++i) {
            for (int x = 0; x < sizeTwo; ++x) {
                arrThree[i][x] = arrOne[i][x] + arrTwo[i][x];
            }
        }
        printMatrices(arrThree);
    }
    
    /*
        Print the new matrix
    */
    public static void printMatrices(int[][] arrThree) {
        int value;
        System.out.println("\nAdded Matrices = ");
        for (int i = 0; i < arrThree.length; ++i) {
            for (int x = 0; x < arrThree[0].length; ++x) {
                value =arrThree[i][x]; 
                System.out.print(" " + value);
            }
            System.out.println(" ");
        }
    }
    
    /*
        Scan the story file and begin the new story
    */
    public static void startStory(Scanner scanner) throws IOException {
        String strStory = "";
        while (scanner.hasNextLine()) 
            strStory += scanner.nextLine();
        int[] placeHolderIndices = findPlaceHolders(strStory);
        String values = askUserForWords();
        String[] getLines = values.split(" ");
        makeNewStory(strStory, getLines, placeHolderIndices);
     }
    
    /*
        Loop through the values in the file and find the placeholders
    */ 
    public static int[] findPlaceHolders(String str) {
        String[] allWords = str.split(" ");
        int[] indices = new int[5];   
        int count = 0;
        for (int i = 0; i < allWords.length; ++i) {
            char lastSegment = allWords[i].charAt(allWords[i].length()-1);
            if (checkForPlaceHolder(allWords[i].charAt(0), lastSegment)) {
                indices[count] = i;
                count++;
            }
        }
        return indices;
    }

    /*
         Check the first and last char of a given string to see if it's a placeholder  
    */      
    public static boolean checkForPlaceHolder(char firstSegment, char lastSegment) {
        return firstSegment == '<' && lastSegment == '>';
    }
        
   /*
        Replace the placeholders with the new words, entered by user
   */  
    public static void makeNewStory(String originalString, String[] newWords, int[] placeHolderIndices) throws IOException {
       PrintStream printStream = new PrintStream(new File(newWords[0]));
       String[] splitOriginalStory = originalString.split(" ");
       int index = 1;   
       int holderIndex = 1;
       for (int i = 0; i < splitOriginalStory.length; ++i) {
           if (i == placeHolderIndices[holderIndex]) {
               splitOriginalStory[i] = newWords[index]; 
               index++;
               if (holderIndex < 4) holderIndex++;
           } 
       }
       printStoryToFile(splitOriginalStory, printStream);
   }
   
   /*
        Print the new strory to the console
        Formatting looks good, clean up the period 
   */
   public static void printStoryToFile(String[] story, PrintStream printStream) {
       for (int x = 0; x < story.length; ++x) {
           if (x == 0)  System.out.print("\t"); // indent the first line
           if (story[x].equals(".")) {
               // printing the period way off 
               printStream.println(story[x]);
               printStream.print("\t");
           }
           else {
               printStream.print(story[x] + " ");
           }
       }   
   }

   /*
        Prompt the user to enter words to fill in the story
   */   
    public static String askUserForWords() {
        Scanner scanner = new Scanner(System.in);
        String newStr;
        System.out.println("\nThis is the story program");
        System.out.print("Please enter a file: ");
        newStr = scanner.next();
        System.out.print("Please enter an adjective: ");
        newStr += " " + scanner.next();
        System.out.print("Please enter a plural noun: ");
        newStr += " " + scanner.next();       
        System.out.print("Please enter a noun: ");
        newStr += " " + scanner.next();    
        System.out.print("Please enter an adjective: ");
        newStr +=" " + scanner.next();   
        System.out.print("Please enter a place: ");
        newStr +=" " + scanner.next();           
        return newStr;
    }
     
}
