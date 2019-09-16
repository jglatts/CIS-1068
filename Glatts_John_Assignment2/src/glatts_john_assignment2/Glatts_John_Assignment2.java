/*

#8) Write a method called quadratic that solves quadratic equations and
prints their roots. 

#16) Write a method called triangleArea that accepts the three side lengths
of a triangle as parameters and returns the area of a triangle with those
side lengths. For example, the call triangleArea(8, 5.2, 7.1) should
return 18.151176098258745. To compute the area, use Heron's formula.

#19) Write a method called printReverse that accepts a string as its parameter
and prints the characters in opposite order. For example, a call of
printReverse("hello there!") should print "!ereht olleh". If the empty
string is passed, the method should produce no output.

Programming Project 2) A certain bank offers 6.5% interest on savings accounts, compounded
annually. Create a table that shows how much money a person will
accumulate over a period of 25 years, assuming that the person makes an
initial investment of $1000 and deposits $100 each year after the first.
Your table should indicate for each year the current balance, the interest,
the new deposit, and the new balance.

 */
package glatts_john_assignment2;

/**
 *
 * @author John Glatts
 * @duedate 9/20/19
 */
public class Glatts_John_Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       quadratic(1, 5, 2); 
       quadratic(1, 3, -10);
       quadratic(10, 15, 12); 
       System.out.println("\nArea of Triangle: " + triangleArea(8, 5.2, 7.1));
       printReverse("hello there!");
       interestTable();
    }
    
    /* 
        Working
            -  Add extra if statements in case there are no roots of the equation
    */
    public static void quadratic(double a, double b, double c) {
        double radical = (b * b) - (4 * a * c);
        double divisor = 2 * a;
        
        System.out.println("\nSolving: " + a + "^2 + " + b + "x + " + c + " = 0");
        if (radical > 0.0) {
            double rootOne =( -b + Math.sqrt(radical)) / divisor;
            double rootTwo =( -b - Math.sqrt(radical)) / divisor;
            System.out.println("Root One: " + rootOne);
            System.out.println("Root Two: " + rootTwo);
        }
        else if (radical == 0.0) {
            double rootOne = -b / divisor;
            System.out.println("Root One: " + rootOne);
        }
        else System.out.println("The equation entered has no real roots");
    }
    
    /* 
        Working
            -  Test different cases to confirm
    */
    public static double triangleArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s-a) * (s-b) * (s-c));
        return area;
    }
    
    /* 
        Working
            -  Test different cases to confirm
    */
    public static void printReverse(String str) {
        System.out.println(" ");
        System.out.print("Reversed string: ");
        
        if (!str.isEmpty()) {
            for (int i = str.length() - 1; i >= 0; --i) {
                System.out.print(str.charAt(i));
            }        
        }
        
        System.out.println(" ");
    } 
    
     /* 
        Somewhat Working...
            - manually compute the outcomes and compare
            -  Test different cases to confirm
    */
    public static void interestTable() {
        double amount, interest_rate = 0.065, invest = 1000.0, deposit = 100.0;

        System.out.println("\n----------------------------------");
        System.out.println("\tThe Bank of Jupin");
        System.out.println("----------------------------------");
        for (int i = 1; i <= 25; ++i) {
            amount = Math.pow((1 + interest_rate), i);
            amount *= invest;   // should this be invest or the deposit?
            System.out.printf("\nYear: " + i + " -- Amount: " + "%.2f\n", amount);
        }
    }
    
}
