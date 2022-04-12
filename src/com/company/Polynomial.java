package com.company;

import java.util.LinkedList;

public class Polynomial {
    private LinkedList<Monomial> monomials;

    public Polynomial()
    {
        monomials = new LinkedList<>();
        monomials.add(new Monomial(0, new Integer(0)));
    }

    }

