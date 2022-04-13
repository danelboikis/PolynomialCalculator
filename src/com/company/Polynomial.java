package com.company;

import java.util.Map;
import java.util.TreeMap;

public class Polynomial {
    private TreeMap<String, Monomial> monomials;

    public Polynomial()
    {
        monomials = new TreeMap<>();
        monomials.put("0", new Monomial(0, new Integer(0)));
    }

    public Polynomial add(Polynomial p) {
        Polynomial res = new Polynomial();

        for (Map.Entry<String, Monomial> entry:
             monomials.entrySet()) {
            if(res.monomials.containsKey(entry.getKey())) {
                //res.monomials.put(entry.getKey(), )
            }
        }

        return null;
    }


}
