package com.company;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        Monomial m1 = new Monomial(3, new Rational(4, 5));
        Monomial m2 = new Monomial(2, new Integer(4));
        Monomial m3 = new Monomial(1, new Integer(69));

        System.out.println(m1.add(m2));
        System.out.println(m2.evaluate(new Integer(3)));
        System.out.println(m3.derivative());
    }
}
