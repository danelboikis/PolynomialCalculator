package Calculator;

public class Rational implements Scalar{
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public boolean equals(Object r)
    {
        if (r instanceof Rational) {
            Rational r2 = this.reduce();
            Rational r3 = ((Rational)r).reduce();

            return r2.numerator == r3.numerator && r2.denominator == r3.denominator;
        }
        else if (r instanceof Integer) {
            Rational r2 = this.reduce();
            return r2.denominator == 1 && r2.numerator == ((Integer)r).getNumber();
        }
        else
            return false;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.add(this);
    }

    @Override
    public Scalar add(Integer s) {
        return ((Rational)add(new Rational(s.getNumber(), 1))).reduce();
    }

    @Override
    public Scalar add(Rational s) {
        return (new Rational(this.numerator * s.denominator + s.numerator * this.denominator,
                this.denominator * s.denominator)).reduce();
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mul(this);
    }

    @Override
    public Scalar mul(Rational s) {
        return (new Rational(this.numerator * s.numerator, this.denominator * s.denominator)).reduce();
    }

    @Override
    public Scalar mul(Integer s) {
        return ((Rational)mul(new Rational(s.getNumber(), 1))).reduce();
    }

    @Override
    public Scalar neg() {
        return new Rational(-1 * this.numerator, this.denominator);
    }

    @Override
    public Scalar power(int exponent) {
        Scalar res = new Rational(1, 1);
        Scalar reduced = reduce();

        for(int i = 0; i < exponent; i++) {
            res = res.mul(reduced);
        }

        return res;
    }

    @Override
    public int sign() {
        int s1 = (int) Math.signum(this.numerator);
        int s2 = (int) Math.signum(this.denominator);
        return s1 * s2;
    }

    private static int gcd(int n, int m) {
        int r = n % m;

        while(r != 0) {
            n = m;
            m = r;
            r = n % m;
        }

        return m;
    }

    public Rational reduce() {
        int numerator = Math.abs(this.numerator);
        int denominator = Math.abs(this.denominator);

        int gcd = gcd(numerator, denominator);

        numerator /= gcd;
        denominator /= gcd;

        numerator *= sign();

        return new Rational(numerator, denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        Rational reduced = reduce();

        if(reduced.denominator == 1) {
            return "" + reduced.numerator;
        }
        else {
            return reduced.numerator + "/" + reduced.denominator;
        }
    }

    @Override
    public Scalar clone() {
        return new Rational(this.numerator, this.denominator);
    }
}
