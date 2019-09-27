    package glatts_john_assignment_3;

    import java.util.Scanner;

    public class Glatts_John_Assignment_3 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Scanner plScanner = new Scanner(System.in);

            // Chapter 4 Exercise 1
            startFractionSum(scanner);

            // Chapter 4 Exercise 8
            smallestLargest(scanner); 

            // Chapter 4 Programming Project 7
            pascalsTriangle();  

            // Chapter 5 Exercise 1
            showTwos(7);
            showTwos(18);
            showTwos(68);
            showTwos(120);

            // Chapter 5 Exercise 3
            System.out.println("\nBinary represention of: " + 44 + " is " + toBinary(44));

            // Chapter 5 Programming Project 1
            pigLatin(plScanner);
    }

    /*
        Prompt the user to enter a value to be used as a fraction sum
    */     
    public static void startFractionSum(Scanner scanner) {
            System.out.print("\nThis is the fractionSum program. What does n = ? ");
            int n = scanner.nextInt();
            System.out.println("\nFraction sum of " + n + " = " + fractionSum(n));
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
        System.out.print("\nHow many numbers would you like to enter? ");
        int numberLimit = scanner.nextInt();
        int[] inputArray = new int[numberLimit];
        
        for (int i = 0; i < numberLimit; ++i) {
            System.out.print("Enter number ----->  ");
            inputArray[i] = scanner.nextInt();
            System.out.println("");
        }
        
        System.out.println("Smallest Number = " + getSmallestValue(inputArray));
        System.out.println("Largest Number = " +   getLargestValue(inputArray));
        
    }    
    
     /*  
        Find and return the smallest integer from the given array
    */     
    public static int getSmallestValue(int arr[]) {
        int value = arr[0]; 
        
        for (int i = 0; i < arr.length; ++i) {
                    if (arr[i] < value) value = arr[i];              
        }    
        
        return value;
    }
    
     /*  
        Find and return the largest integer from the given array
    */     
     public static int getLargestValue(int arr[]) {
        int value = arr[0];
        
        for (int i = 0; i < arr.length; ++i) {
                if (arr[i] > value) value = arr[i]; 
        }    
        
        return value;
    }
    
     /*  
          Accept an integer parameter and return the binary value in a string 
    */         
    public static String toBinary(int intValue) {
        String returnStr = "";
        while(intValue > 0) {
            returnStr = ((intValue % 2 == 0) ? "0" : "1") + returnStr;
            intValue /= 2;
        }
        return returnStr;
    }
    
     /*  
           Prompt the user and ask how many rows of pascals triangle they would like to print
           Once a value is scanned, format and print pascals triangle 
    */   
    public static void pascalsTriangle() {
        Scanner pascalScanner = new Scanner(System.in); 
        int  lineNumbers, count = 1;
        
        System.out.print("\nThis is the pascalsTriangle program. How many lines of the triangle would you like? ");
        lineNumbers = pascalScanner.nextInt();
        
        for(int i = 0; i < lineNumbers; i++) {
            for(int x = 1; x < lineNumbers - i; x++) {
                System.out.printf("  "); 
            }
            for(int j = 0; j <= i; ++j)  {
                if (j == 0 || i == 0) {
                    count = 1;
                }    
                else {
                    // compute new value 
                    count = (count * (i - j + 1))  /  j;
                }
                // print new value
                System.out.printf("%4d",  count);
            }
           System.out.print("\n");
        }  
        // new line after triangle is printed
        System.out.println("\n");
    }
    
     /*  
          Compute the factors of 2 for an integer parameter  
    */      
    public static void showTwos(int value) {
        System.out.print("Factors of 2 for: " + value + " = ");
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
        String str = "";
        // only perform conversion if string is not empty 
        do {
                 System.out.print("\nEnter a string to be converted to pig latin: ");
                 str = scanner.nextLine();       
                 System.out.println("String converted to pig latin = " + translateToPigLatin(str));
        } while (!str.equals(""));
        System.out.println("Empty string passed in.\nProgram Terminated.");
    }
    
    /* 
        Translate the given string to to piglatin
        Return the converted string 
    */
    public static String translateToPigLatin(String str) {
        String outPut = " ";
        String segment[] = str.split(" ");
        char segmentIndex;

        for (int i = 0; i < segment.length; ++i) {
                for (int y = 0; y < segment[i].length(); ++y) {
                     segmentIndex = segment[i].charAt(y);
                     if (checkForVowel(segmentIndex)) 
                         if (y != 0) {
                                String toMove = segment[i].substring(0, y);     
                                String cutHere = segment[i].substring(y, segment[i].length()); 
                                outPut += cutHere + "-"+ toMove + "ay ";
                                break;   
                        }
                        else 
                            outPut += segment[i] + "-ay ";
                }
           }
        return outPut += "\n";   
    }  

    /*
        Check if a given letter is a vowel 
    */
    public static boolean checkForVowel(char charSegment) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        
        for (int i = 0; i < vowels.length; ++i) {
            if (charSegment == vowels[i]) 
                return true;
        }
        return false;
    }

}
