package com.company;

import java.util.Map;
import java.util.TreeMap;

public class Polynomial {
    private TreeMap<java.lang.Integer, Monomial> monomials;

    public Polynomial() {
        monomials = new TreeMap<>();
        monomials.put(0, new Monomial(0, new Integer(0)));
    }

    public Polynomial(Monomial m){
        this();
        monomials.put(m.getExponent(), m.clone());
    }

    private Scalar stringToScalar(String s) {
        if (s.contains("/")) {
            return (new Rational(java.lang.Integer.parseInt(s.split("/")[0]), java.lang.Integer.parseInt(s.split("/")[1])));
        }
        return (new Integer(java.lang.Integer.parseInt(s)));
    }

    private boolean inKeys(int i) {
        return (monomials.containsKey(i));
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
                }
                else
                {
                    p.monomials.put(i, new Monomial(i, scalar));
                }
            }
        }
        return p;
    }

    public Polynomial add(Polynomial p) {
        Polynomial res = new Polynomial();

        res.addToTreeMap(this.monomials);

        res.addToTreeMap(p.monomials);

        return null;
    }

    private void addToTreeMap(TreeMap<java.lang.Integer, Monomial> add) {
        for (Map.Entry<java.lang.Integer, Monomial> entry:
             add.entrySet()) {
            if(this.monomials.containsKey(entry.getKey())) {
                this.monomials.put(entry.getKey(), entry.getValue().add(this.monomials.get(entry.getKey())));
            }
            else {
                this.monomials.put(entry.getKey(), entry.getValue().clone());
            }
        }
    }

    public Polynomial mul(Polynomial p) {
        Polynomial res = new Polynomial();

        for (Map.Entry<java.lang.Integer, Monomial> entry1:
             p.monomials.entrySet()) {
            for (Map.Entry<java.lang.Integer, Monomial> entry2:
                 this.monomials.entrySet()) {
                Monomial multiplied = entry1.getValue().mul(entry2.getValue());
                res = res.add(new Polynomial(multiplied));
            }
        }

        return res;
    }

    public Scalar evaluate(Scalar s) {
        Scalar res = new Integer(0);

        for (Map.Entry<java.lang.Integer, Monomial> entry:
             monomials.entrySet()) {
            res = res.add(entry.getValue().evaluate(s));
        }

        return res;
    }

}

