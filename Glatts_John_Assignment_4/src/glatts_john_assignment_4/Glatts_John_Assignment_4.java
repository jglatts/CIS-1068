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
    
     // Myers - Brigss globals
     public static int valueZero = 0; 
     public static int set21 = 1; // test the set 2 of 2'nd row of each
     public static int set22 = 2; // test the set 2 of 3'rd row of each
     public static int set31 = 3; // test the set 3 of 4'th row of each
     public static int set32 = 4; // test the set 3 of 5'th row of each
     public static int totalQuestSet = 7; // to test the last value of
     static int set1_A = 0; // count extrovert
     static int set1_B = 0; // count introvert
     static int set2_A = 0; // count sense
     static int set2_B = 0; // count intuition
     static int set3_A = 0; // count thinking
     static int set3_B = 0; // count feeling
     static int set4_A = 0; // count judge
     static int set4_B = 0; // count perception
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Ch. 6, ex. 2
        Scanner scanner = new Scanner(new File(numbersPath));
        evenNumbers(scanner, numbersPath.length());
        
        // Ch. 6, ex. 17
        Scanner statsScanner = new Scanner(new File(tokenPath));
        System.out.println("Stats-File has " + inputStats(statsScanner) + " lines of text\n");
        
        // Ch. 6, Programming Project 5
        Scanner storyScanner = new Scanner(new File(storyPath));        
        startStory(storyScanner);
        
        // Ch. 7, ex. 6
        int[] devArray = new int[]{1, -2, 4, -4, 9, -6, 16, -8, 25, -10}; 
        System.out.println("Std-Dev is: " + stdDev(devArray) + "\n");   
        
        // Ch. 7, ex. 19
        generateMatrices();
       
        // Ch. 7. Programming Project 4 
        startMyersBriggs(); 
    }

    /* 
            Parse a file and find all the numbers inside
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
        System.out.printf(index + " numbers, sum = " + getSum(allValues));
        System.out.print("\n" + evens + " evens (" );
        // convert to %
        System.out.printf( "%.2f" , getPercent(evens, index));
        System.out.print("%)\n\n");
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
        return ((double)evenCount / (double)size) * 100;
    }
    
    /* 
           Parse a text file with strings and display stats 
    */      
    public static int inputStats(Scanner statsScanner) {
        int count = 0;
        String longestString = "";
        while (statsScanner.hasNextLine()) {
                String str = statsScanner.nextLine();
                int tokens = examineTokens(str);
                System.out.print("Line #" + (count+1) + " has " + tokens + " tokens, " + "(longest = " + getLongestToken(str) + ") ");
                System.out.println(" ");
                count++;
                if (tokens > longestString.split(" ").length)
                    longestString = str;
        }
        System.out.println("Longest Line Found = " + longestString);
        return count;
    }
        
    /* 
           Find the number of tokens on each line 
    */      
    public static int examineTokens(String str) {
        // use this guy to also get the longest line
        String[] strSplit = str.split(" "); 
        return strSplit.length;
    }
    
     /* 
            Find the longest loken of the line 
            Return the number of tokens
    */     
    public static int getLongestToken(String str) {
        String[] strSplit = str.split(" ");
        int count = 0, index = 0, longest = strSplit[0].length();
        for (int i = 0; i < strSplit.length; ++i) {
            if (strSplit[i].length() >= longest) {
                    longest = strSplit[i].length();
                    count = longest;
                    index = i;
            }
        }
        return count;
    }
    
    /*
        Find and return the standard deviation from a given array
    */
    public static double stdDev(int[] values) {
        double sd = 0.0;
        int average = getSum(values) / values.length;
        System.out.println("\nThe average value of the array is: " + average);
        for (int i = 0; i < values.length; i++) {
            sd += Math.pow(values[i] - average, 2) / values.length;
        }
         return Math.sqrt(sd);
     } 
    
     /*
        Generate two 2D arrays
    */
    public static void generateMatrices() {
        int[][] arrOne = new int[][] {
            new int[] { 1, 2, 3, 7, 12, 20},
            new int[] { 1, 2, 3, 7, 12, 20},
            new int[] { 1, 2, 3, 7, 12, 20},
        };
        int[][] arrTwo = new int[][] {
            new int[] { 1, 2, 3, 7, 12, 20},
            new int[] { 1, 2, 3, 7, 12, 20},
            new int[] { 1, 2, 3, 7, 12, 20},
        };       
        printMatrices(matrixAdd(arrOne, arrTwo));
    }
    
     /*
        Add both matrices together and return their sum
    */
    public static int[][] matrixAdd(int[][] arrOne, int[][] arrTwo) {
        int[][] arrThree = new int[arrOne.length][arrOne[0].length];
        for (int i = 0; i < arrOne.length; ++i) {
            for (int x = 0; x < arrOne[0].length; ++x) {
                arrThree[i][x] = arrOne[i][x] + arrTwo[i][x];
            }
        }
        return arrThree;
    }
    
    /*
        Print the new matrix
    */
    public static void printMatrices(int[][] arrThree) {
        System.out.println("\nAdded Matrices = ");
        for (int i = 0; i < arrThree.length; ++i) {
            for (int x = 0; x < arrThree[0].length; ++x) {
                int value =arrThree[i][x]; 
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
       int holderIndex = 0;
       for (int i = 0; i < splitOriginalStory.length; ++i) {
           if (i == placeHolderIndices[holderIndex]) {
               splitOriginalStory[i] = newWords[index]; 
               index++;
               if (holderIndex < 4) holderIndex++;
           } 
       }
       printStoryToFile(splitOriginalStory, printStream);
       System.out.println("Saved the story at: " + newWords[0]);
   }
   
   /*
        Format and print the new strory to the console
   */
   public static void printStoryToFile(String[] story, PrintStream printStream) {
       for (int x = 0; x < story.length; ++x) {
           // try and clean up the ugly period 
           if (story[x].equals(".")) {
               printStream.print(story[x]);     
               printStream.println(" ");
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
        System.out.print("Please enter a output file, (followed by .txt): ");
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

    /*
        Start the Myers-Briggs program and prompt the user for a input file
        Once a file is verified and exists, convert the scores and display
    */
    public static void startMyersBriggs() throws FileNotFoundException {
          Scanner console = new Scanner(System.in);
          File file;
          System.out.println("\nThis is the Myers-Briggs program.");
          do {
              System.out.print("Enter file name to process: ");
              String fileName = console.nextLine();
              file = new File(fileName);
          } while (!file.exists());    
          System.out.println();
          evaluateAnswerFile(file);
     }    

    /*
        Get the scores from the input file for Myers-Briggs
    */
     public static void evaluateAnswerFile(File f) throws FileNotFoundException  {
          Scanner input = new Scanner(f);
          String nameOne, answersOne, nameTwo, answersTwo;
          nameOne = input.nextLine();
          System.out.println(nameOne);
          answersOne = input.nextLine().toUpperCase();
          System.out.println("Input = " + answersOne);
          nameTwo = input.nextLine();
          answersTwo = input.nextLine().toUpperCase();
          calculateMyersBriggsResults(answersOne);
          displayResult();
          // calculate the second user
          resetScores();
          calculateMyersBriggsResults(answersTwo);
          System.out.println("\n" + nameTwo);
          System.out.println("Input = " + answersTwo);
          displayResult();
     }
     
     /*
        Update the global vars, the scores, and then display
     */
     public static void calculateMyersBriggsResults(String answer) {
                  for (int i = 0; i < answer.length(); i++)  {
                        if ((i == valueZero) || ((i % totalQuestSet == valueZero))) {
                             if (answer.charAt(i) == 'A') {
                                  set1_A++;
                             }
                             if (answer.charAt(i) == 'B') {
                                  set1_B++;
                             }
                        }
                        else if (checkFirstSet(i)) {
                             if (answer.charAt(i) == 'A'){
                                  set2_A++;
                             }
                             if (answer.charAt(i) == 'B') {
                                  set2_B++;
                             }
                        }
                        else if (checkSecondSet(i))  {
                             if (answer.charAt(i) == 'A')  {
                                  set3_A++;
                             }
                             if (answer.charAt(i) == 'B') {
                                  set3_B++;
                             }
                        }
                        else {
                             if (answer.charAt(i) == 'A') {
                                  set4_A++;
                             }
                             if (answer.charAt(i) == 'B') {
                                  set4_B++;
                             }
                        }
                    }     
     }

     /*
        Display the results of the Myers-Briggs conversion
     */
     public static void displayResult() {
          double set1Per, set2Per, set3Per, set4Per;
          String status = "";
          status += set1_A + "A-" + set1_B + "B ";
          status += set2_A + "A-" + set2_B + "B ";
          status += set3_A + "A-" + set3_B + "B ";
          status += set4_A + "A-" + set4_B + "B ";
          set1Per = (double) set1_B / (set1_A + set1_B) * 100;
          set2Per = (double) set2_B / (set2_A + set2_B) * 100;
          set3Per = (double) set3_B / (set3_A + set3_B) * 100;
          set4Per = (double) set4_B / (set4_A + set4_B) * 100;
          status += "[" + (int) set1Per + "%, " + (int) set2Per + "%, " + (int) set3Per + "%, " + (int) set4Per + "%] = ";
          status += getStatus(set1Per, 1) + getStatus(set2Per, 2) + getStatus(set3Per, 3) + getStatus(set4Per, 4);
          System.out.print("Myers-Briggs Score = ");
          System.out.print(status);
          System.out.println();
     }
     
     /*
        Check and return the status of the input scores 
     */
     public static String getStatus(double percent, int set) {
          // if it is set1
          if (set == 1) {
              if (percent > 50)
                   return "I";
              else if (percent < 50)
                   return "E";
              else
                   return "X";
          }
          if (set == 2) {
              if (percent > 50)
                   return "N";
              else if (percent < 50)
                   return "S";
              else
                   return "X";
          }
          if (set == 3) {
              if (percent > 50)
                   return "F";
              else if (percent < 50)
                   return "T";
              else
                   return "X";
          }
          if (set == 4) {
              if (percent > 50)
                   return "P";
              else if (percent < 50)
                   return "J";
              else
                   return "X";
          }
          return "";
     }    
     
     /*
        Reset the global vars to start another score conversion
     */
     public static void resetScores() {
            valueZero = 0; 
            set21 = 1; 
            set22 = 2; 
            set31 = 3; 
            set32 = 4; 
            totalQuestSet = 7; 
            set1_A = 0; 
            set1_B = 0; 
            set2_A = 0; 
            set2_B = 0; 
            set3_A = 0; 
            set3_B = 0; 
            set4_A = 0; 
            set4_B = 0; 
     }
     
     /*
        Check each input score with the first set
     */
     public static boolean checkFirstSet(int i) {
        return  (i - set21) == valueZero || (i - set22) == valueZero || (i - set21) % totalQuestSet == valueZero 
                    || (i - set22) % totalQuestSet == valueZero;        
     }
 
     /*
        Check each input score with the second set
     */
     public static boolean checkSecondSet(int i ) {
        return (i - set31) == valueZero || (i - set32) == valueZero || (i - set31) % totalQuestSet == valueZero 
                    || (i - set32) % totalQuestSet == valueZero;
     } 
     
}
