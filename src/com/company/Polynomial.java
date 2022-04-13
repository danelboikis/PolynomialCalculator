package com.company;

import java.util.Map;
import java.util.TreeMap;

public class Polynomial {
    private TreeMap<java.lang.Integer, Monomial> monomials;

    public Polynomial() {
        monomials = new TreeMap<>();
        monomials.put(new java.lang.Integer(0), new Monomial(0, new Integer(0)));
    }

    private Scalar stringToScalar(String s) {
        if (s.contains("/")) {
            return (new Rational(java.lang.Integer.parseInt(s.split("/")[0]), java.lang.Integer.parseInt(s.split("/")[1])));
        }
        return (new Integer(java.lang.Integer.parseInt(s)));
    }

    private boolean inKeys(int i) {
        return (monomials.keySet().contains(i));
    }

    public static Polynomial build(String input)
    {
        String[] s = input.trim().split(" ");
        Polynomial p = new Polynomial();
        for (int i = 0; i < s.length; i = i + 1)
        {
            if (!s[i].equals("0"))
            {
                Scalar scalar = p.stringToScalar(s[i]);
                if (p.inKeys(i))
                {
                    p.monomials.put(i, p.monomials.get(i).add(new Monomial(i, scalar)));
                } else
                {
                    p.monomials.put(i, new Monomial(i, scalar));
                }
            }


        }
        return p;
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

