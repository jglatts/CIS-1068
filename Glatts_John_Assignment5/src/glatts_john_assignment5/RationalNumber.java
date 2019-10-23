package glatts_john_assignment5;

public class RationalNumber {
    
    private final int numerator;
    private final int denominator;
    private int gcd;
    
    /*
        Default constructor
    */
    public RationalNumber() {
        this.gcd = 0;
        this.numerator = 0;
        this.denominator = 1;
    }
    
    /*
        Default constructor
    */    
    public RationalNumber(int numerator, int denominator) throws IllegalArgumentException {
        if (denominator == 0) throw new IllegalArgumentException("\n\tcan't  have 0 in denominator") ;    
        this.gcd = 0;
        this.gcd = this.greatestCommonDivisor(numerator, denominator);    
        this.numerator = numerator / this.gcd;
        this.denominator = denominator / this.gcd;            
    }
    
    public int getDenominator() {
        return this.denominator;
    }
    
    public int getNumerator() {
        return this.numerator;
    }    
    
    @Override
    public String toString() {
        return this.numerator + " / " + this.denominator + " ";
    }
    
    private int greatestCommonDivisor(int m, int n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        if (0 == n) return m;
        else return greatestCommonDivisor(n, m % n);    
    }
        
}
