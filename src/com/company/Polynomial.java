package com.company;

import java.util.TreeMap;

public class Polynomial {
    private TreeMap<String, Monomial> monomials;

    public Polynomial()
    {
        monomials = new TreeMap<>();
        monomials.put("0", new Monomial(0, new Integer(0)));
    }


}
