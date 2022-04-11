package com.company;

public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial(int exp, Scalar coef)
    {
        exponent = exp;
        coefficient = coef;
    }

    public Monomial add(Monomial m)
    {
        if(m.exponent == exponent)
            return new Monomial(exponent, coefficient.add(m.coefficient));
        return null;
    }

    public Monomial mul(Monomial m)
    {
        return new Monomial(exponent + m.exponent, coefficient.mul(m.coefficient));
    }

    public Scalar evaluate(Scalar s)
    {
        return((s.power(exponent)).mul(coefficient));
    }

    public Monomial derivative()
    {
        if(exponent == 0)
            return(new Monomial(0, coefficient.mul(new Integer(0))));
        return(new Monomial(exponent - 1, coefficient.mul(new Integer(exponent))));
    }

    public int sign()
    {
        return coefficient.sign();
    }

    public String toString()
    {
        if(coefficient.sign() == 0)
            return("0");
        if(exponent == 0)
            return(coefficient.toString());
        if(exponent == 1)
            return(coefficient.toString() + "x");
        else
            return(coefficient.toString() + "x^" + exponent);
    }





}
