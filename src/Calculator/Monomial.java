package Calculator;

public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial(int exp, Scalar coef)
    {
        exponent = exp;
        coefficient = coef;
    }

    public boolean equals(Object m) {
        if (m instanceof Monomial)
            return(((Monomial)m).coefficient.equals(this.coefficient) && ((Monomial)m).exponent == this.exponent);
        else
            return false;
    }

    public Scalar getCoefficient() {
        return coefficient;
    }

    public Monomial add(Monomial m)
    {
        if(m.exponent == exponent)
            return new Monomial(exponent, coefficient.add(m.coefficient));
        else if (m.coefficient.equals(new Integer(0)))
            return this.clone();
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
            return(new Monomial(0, new Integer(0)));
        return(new Monomial(exponent - 1, coefficient.mul(new Integer(exponent))));
    }

    public int sign()
    {
        return coefficient.sign();
    }

    public String toString()
    {
        String output = "";

        if (exponent == 0)
            return  coefficient.toString();
        if(coefficient.sign() == 0)
            return "0";
        if(!coefficient.equals(new Integer(1))) {
            if (coefficient.equals(new Integer(-1)))
                output += "-";
            else
                output += coefficient.toString();
        }
        if (exponent == 1)
            return output + "x";
        return output + "x^" + exponent;
    }

    public Monomial clone() {
        return new Monomial(this.exponent, this.coefficient.clone());
    }

    public int getExponent() {
        return exponent;
    }
}
