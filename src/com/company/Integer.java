package com.company;

public class Integer implements Scalar{
    private int number;

    public Integer(int number) {
        this.number = number;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.add(this);
    }

    @Override
    public Scalar add(Integer s) {
        return new Integer(s.number + this.number);
    }

    @Override
    public Scalar add(Rational s) {
        return null;
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mul(this);
    }

    @Override
    public Scalar mul(Integer s) {
        return new Integer(s.number * this.number);
    }

    @Override
    public Scalar mul(Rational s) {
        return null;
    }

    @Override
    public Scalar neg() {
        return new Integer(-1 * this.number);
    }

    @Override
    public Scalar power(int exponent) {
        Scalar res = new Integer(1);

        for (int i = 0; i < exponent; i++) {
            res = res.mul(this);
        }

        return res;
    }

    @Override
    public int sign() {
        return (int) Math.signum(this.number);
    }

    @Override
    public String toString() {
        return "Integer{" +
                "number=" + number +
                '}';
    }
}
