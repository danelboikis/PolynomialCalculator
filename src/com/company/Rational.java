package com.company;

public class Rational implements Scalar{
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.add(this);
    }

    public Scalar add(Rational s) {
        return new Rational(this.numerator * s.denominator + s.numerator * this.denominator,
                this.denominator * s.denominator);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mul(this);
    }

    public Scalar mul(Rational s) {
        return new Rational(this.numerator * s.numerator, this.denominator * s.denominator);
    }

    @Override
    public Scalar neg() {
        return new Rational(-1 * this.numerator, this.denominator);
    }

    @Override
    public Scalar power(int exponent) {
        Scalar res = new Rational(1, 1);

        for(int i = 0; i < exponent; i++) {
            res = res.mul(this);
        }

        return res;
    }

    @Override
    public int sign() {
        if(this.numerator * this.denominator > 0) {
            return 1;
        }
        else if(this.numerator == 0) {
            return 0;
        }
        else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Rational{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
