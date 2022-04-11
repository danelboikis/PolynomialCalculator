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

        return(new Monomial(exponent - 1, coefficient.mul(new Integer(exponent))));
    }





}
