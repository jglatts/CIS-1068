package glatts_john_assignment_5;

public class RationalNumber {
    
    private int numerator;
    private int denominator;
    
    /*
        Default constructor
    */
    public RationalNumber() {
        this.numerator = 0;
        this.denominator = 1;

    }
    
    /*
        Constructor with integer parameters
    */    
    public RationalNumber(int numerator, int denominator) throws IllegalArgumentException {
            if (denominator == 0) throw new IllegalArgumentException("\n\tInvalid input: can't divide by 0") ;    
            this.denominator = denominator;
            this.numerator = numerator;     
            if (denominator < 0) {
                this.denominator *= -1;
                this.numerator *= -1;
            }           
    }
    
    /*
        Factor the rational to lowest terms
    */    
    public void factorRational() {
        int gcd = greatestCommonDivisor(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }
    
    /*
        Return the denominator
    */    
    public int getDenominator() {
        return denominator;
    }

    /*
        Return the numerator
    */     
    public int getNumerator() {
        return numerator;
    }    
    
    @Override
    public String toString() {
        if (denominator == 1) return numerator + " ";  
        return numerator + " / " + denominator + " ";
    }
    
    /*
        Find the GCD of a given rational
    */     
    private int greatestCommonDivisor(int m, int n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        if (0 == n) return m;
        else return greatestCommonDivisor(n, m % n);    
    }
    
    /*
        Add two rationals and return value
    */
    public static RationalNumber addRational(RationalNumber ratOne, RationalNumber ratTwo) {
        int newDenominator = ratOne.denominator * ratTwo.denominator;
        int numeratorOne = ratOne.numerator * ratTwo.denominator;
        int numeratorTwo = ratTwo.numerator * ratOne.denominator;
        int addNumerator = numeratorOne + numeratorTwo;
        RationalNumber r = new RationalNumber(addNumerator, newDenominator);
        r.factorRational();
        return r;
    }
 
    /*
        Subtract two rationals and return value
    */    
    public static RationalNumber subtractRational(RationalNumber ratOne, RationalNumber ratTwo) {
        int newDenominator = ratOne.denominator * ratTwo.denominator;
        int numeratorOne = ratOne.numerator * ratTwo.denominator;
        int numeratorTwo = ratTwo.numerator * ratOne.denominator;
        int addNumerator = numeratorOne - numeratorTwo;
        RationalNumber r = new RationalNumber(addNumerator, newDenominator);
        r.factorRational();
        return r;
    }    

    /*
        Multiply two rationals and return value
    */   
    public static RationalNumber multiplyRational(RationalNumber ratOne, RationalNumber ratTwo) {
        int newDenominator = ratOne.denominator * ratTwo.denominator;
        int newNumerator = ratOne.numerator * ratTwo.numerator;
        RationalNumber r = new RationalNumber(newNumerator, newDenominator);
        r.factorRational();
        return r;
    }       
    
    /*
        Divide two rationals and return value
    */    
    public static RationalNumber divideRational(RationalNumber ratOne, RationalNumber ratTwo) {
        int newDenominator = ratOne.denominator * ratTwo.numerator;
        int newNumerator = ratOne.numerator * ratTwo.denominator;
        RationalNumber r = new RationalNumber(newNumerator, newDenominator);
        r.factorRational();
        return r;
    }     
        
}
