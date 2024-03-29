package glatts_john_assignment_5;

public class Point {
    private int x;
    private int y;
    private static int count = 0;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
        count++;
    }

    public Point(double x, int y){
        this.x = (int)x;
        this.y = y;
        count++;
    }

    public Point(){
        this(0,0); 
    }
    
    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    public int getX(){
        return x;
    }

    public void setX(int newX){
        x = newX;
    }

    public int getY(){
        return y;
    }

    public void setY(int newY){
        y = newY;
    }

    static int getCount(){
        return count;
    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double distance(Point p){
        return Math.sqrt((double)(x-p.x)*(x-p.x) + (double)(y-p.y)*(y-p.y));
    
    }

}
