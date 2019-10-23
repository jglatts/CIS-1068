package glatts_john_assignment5;

public class Glatts_John_Assignment5 {

    public static void main(String[] args) {
        Point pointOne = new Point(5, 10);
        Point pointTwo = new Point(10, 40);
        Line line = new Line(pointOne, pointTwo);
        RationalNumber r = new RationalNumber(123846, 48);
        System.out.println("\nCreated a new line segment at points: " + line.getP1() + " and " + line.getP2());
        System.out.println("The slope of the line is: " + line.getSlope());
        checkColinear(line);
        System.out.println("\nThe rational number, in lowest terms, is: " + r.toString());
    }
    
    public static void checkColinear(Line line) {
        Point testPoint = new Point(6, 9);
        if (line.isCollinear(testPoint))
            System.out.println("The point: " + testPoint.toString() + " is colinear" + " to the line " + line.toString());
        else
            System.out.println("The point: " + testPoint.toString() + " is not colinear" + " to the line " + line.toString());
    }
    
}
