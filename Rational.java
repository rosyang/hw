//Joanne Yang
//Period 8
//HW27
//2013-11-19

public class Rational {

    //Instance Variables
    private int _n;
    private int _d;

    //Default constructor
    public Rational() {
	_n = 0;
	_d = 1;
    }

    //Overloaded constructor
    public Rational( int n, int d ) {

	if( d == 0 ) {
	    System.out.println( "Sorry, the denominator cannot be zero." );
	    _n = 0;
	    _d = 1;
	}
	else {
	    _n = n;
	    _d = d;
	}

    }

    //Overwriting toString()
    public String toString() {
	return "Rational number: " + _n + "/" + _d;
    }

    //Method floatValue() returns a floating point value of the number
    public double floatValue() {
        return (double) _n / (double) _d;
    }

    //Method multiply(Rational) multiplies two Rational objects and modifies this object
    public void multiply( Rational num ) {
	_n = _n * num._n;
	_d = _d * num._d;
    }

    //Method divide(Rational) divides two Rational objects and modifies this object
    public void divide( Rational num ) {
	_n = _n * num._d;
	_d = _d * num._n;
    }

    //Method add(Rational) adds two Rational objects and modifies this object
    public void add( Rational num ) {
	
	if( _d == num._d ) {
	    _n = _n + num._n;
	}
	else {
	    _n = ( _n * num._d ) + ( num._n * _d );
	    _d = _d * num._d;
	}

    }

    //Method subtract(Rational) subtracts two Rational objects and modifies this object
    public void subtract( Rational num ) {

	if( _d == num._d ) {
	    _n = _n - num._n;
	}
	else {
	    _n = ( _n * num._d ) - ( num._n * _d );
	    _d = _d * num._d;
	}

    }

    //Method reduce() changes this Rational to reduced form
    public void reduce() {
	int gcd = gcd( _n, _d );
	_n = _n / gcd;
	_d = _d / gcd;
    }

    //Method gcd() finds the greatest common divisor of the numerator and denominator
    public int gcd() {

	while ( _d != 0 ) {
	    int r = _n % _d;
	    _n = _d;
	    _d = r;
	}
	return _n;

    }

    //Static method gcd( int, int ) finds the greatest common divisor of the numerator and denominator
    public static int gcd( int n, int d ) {

	while ( d != 0 ) {
	    int r = n % d;
	    n = d;
	    d = r;
	}
	return n;

    }

    //Method compareTo(Rational) compares two Rational objects and returns a number depending on if this object is equal, larger, or smaller than the parameter
    public int compareTo( Rational num ) {
	
	double thisNum = floatValue();
	double thatNum = num.floatValue();

	if( thisNum == thatNum ) { return 0; }
	else if( thisNum > thatNum ) { return 1; }
	else if( thisNum < thatNum ) { return -1; }

	return 0; 
    }

    /*
    //testing...
    public static void main( String[] args ) {

	Rational num1 = new Rational();
	Rational num2 = new Rational( 1, 3 );
	Rational num3 = new Rational( 5, 10 );
	Rational num4 = new Rational( 1, 0 );
	
	System.out.println( num1 );
	System.out.println( num2 );
	System.out.println( num3 );
	System.out.println( num4 );
	
	System.out.println( num2 + " = " + num2.floatValue() );
	System.out.println( num3 + " = " + num3.floatValue() );
	
	num2.multiply( num3 );
	System.out.println( "After multiplying, " + num2 );
	num2.divide( num3 );
	System.out.println( "After dividing, " + num2 );
	num2.add( num3 );
	System.out.println( "After adding, " + num2 );
	num2.subtract( num3 );
	System.out.println( "After subtracting, " + num2 );

	num2.reduce();
	System.out.println( "After reducing, " + num2 );
	num3.reduce();
	System.out.println( "After reducing, " + num3 );
	
	System.out.println( num2.gcd() );
	System.out.println( num2.gcd( num2._n, num2._d ) );
	System.out.println( num3.gcd() );
	System.out.println( num3.gcd( num3._n, num3._d ) );
	
	System.out.println( num2.compareTo( num3 ) );
	
    }
    */
}
