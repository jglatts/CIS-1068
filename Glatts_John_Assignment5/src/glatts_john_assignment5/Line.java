package glatts_john_assignment5;

public class Line {
    
    private Point pointOne = new Point();
    private Point pointTwo = new Point();
    
    /*
        Line Constructor
                - Set up a new line with the given two points
    */
    public Line(Point p1, Point p2) {
        this.pointOne = p1;
        this.pointTwo = p2;
    }
    
    /*
        Line Constructor, using only x-y cordinates
    */
    public Line(int x1, int x2, int y1, int y2) {
        // set up the point objects
        pointOne.setX(x1);
        pointOne.setY(y1);
        pointTwo.setX(x2);
        pointTwo.setX(y2);
    }    
    
    /* 
        Find and return the line's first endpoint 
    */
    public Point getP1() {
        return this.pointOne;
    }
    
     /* 
        Find and return the line's second endpoint 
    */
    public Point getP2() {
        return this.pointTwo;
    }   
    
    /*
        Format and return the line segments
    */
    @Override
    public String toString() {
        return "[(" + pointOne.getX() + ", " + pointOne.getY() + "), " + "(" + pointTwo.getX() + ", " + pointTwo.getY() + ")]";
    }
    
    /*
        Find and return the slope of the two lines
    */
    public double getSlope() {
       double slope = 0.0;
       try {
                slope =  (pointTwo.getY() - pointOne.getY()) / (pointTwo.getX() - pointOne.getX());
       } catch (ArithmeticException  e) {
           System.out.println("Can't Divide by 0 - " + e);
       }      
       return slope;
    }
    
    /*
        Check between a point and the given points
        to see if the line is collinear
    */
    public boolean isCollinear(Point p) {
        return p.getX() == pointOne.getX() && p.getX() == pointTwo.getX()  || 
                   p.getY() == pointOne.getY() && p.getY() == pointTwo.getY();
    }    
    
}
