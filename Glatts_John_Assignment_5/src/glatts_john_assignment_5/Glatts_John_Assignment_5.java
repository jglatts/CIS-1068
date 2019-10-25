package glatts_john_assignment_5;

public class Glatts_John_Assignment_5 {

    /*
        Main driver function
    */
    public static void main(String[] args) {
        // Chp 8, 14 - 17
        Point pointOne = new Point(5, 10);
        Point pointTwo = new Point(9, 40);
        Line line = new Line(pointOne, pointTwo);
        System.out.println("\nCreated a new line segment at points: " + line.getP1() + " and " + line.getP2());
        System.out.println("The slope of the line is: " + line.getSlope());
        checkColinear(line);
        
        // Chp 8, PP1
        RationalNumber r = new RationalNumber(40, 10);
        System.out.println("\nThe rational number is: " + r.toString());
        r.factorRational();
        System.out.println("The factored version: " + r.toString());
        checkRationalArithimetic();
    }

    /*
        Testing the isCollinear() method
    */    
    public static void checkColinear(Line line) {
        Point testPoint = new Point(6, 9);
        if (line.isCollinear(testPoint))
            System.out.println("The point: " + testPoint.toString() + " is colinear" + " to the line " + line.toString());
        else
            System.out.println("The point: " + testPoint.toString() + " is not colinear" + " to the line " + line.toString());
    }

    /*
        Testing the rational arithmetic methods
    */       
    public static void checkRationalArithimetic() {
        RationalNumber rOne = new RationalNumber(5, 3);
        RationalNumber rTwo = new RationalNumber(8, 7);
        RationalNumber add = RationalNumber.addRational(rOne, rTwo);
        RationalNumber subtract = RationalNumber.subtractRational(rOne, rTwo);
        RationalNumber multiply = RationalNumber.multiplyRational(rOne, rTwo);
        RationalNumber divide = RationalNumber.divideRational(rOne, rTwo);
        System.out.println("\nAdding the rational numbers: " + rOne.toString() + " and " + rTwo.toString());
        System.out.println("Value: " + add.toString());
        System.out.println("\nSubtracting the rational numbers: " + rOne.toString() + " and " + rTwo.toString());
        System.out.println("Value: " + subtract.toString());
        System.out.println("\nMultiplying the rational numbers: " + rOne.toString() + " and " + rTwo.toString());
        System.out.println("Value: " + multiply.toString());
        System.out.println("\nDividing the rational numbers: " + rOne.toString() + " and " + rTwo.toString());
        System.out.println("Value: " + divide.toString());
    }
    
}
