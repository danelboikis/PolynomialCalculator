package Calculator;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Polynomial {
    private TreeMap<java.lang.Integer, Monomial> monomials;

    public Polynomial() {
        monomials = new TreeMap<>();
    }

    private Polynomial(Monomial m){
        this();
        if (!monoIsZero(m))
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
        String[] s = input.trim().replaceAll("( )+", " ").split(" ");

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

        return res;
    }

    private void addToTreeMap(TreeMap<java.lang.Integer, Monomial> add) {
        for (Map.Entry<java.lang.Integer, Monomial> entry:
             add.entrySet()) {
            Monomial m = entry.getValue();
            if(this.monomials.containsKey(entry.getKey())) {
                m = m.add(this.monomials.get(entry.getKey()));
            }

            if(!monoIsZero(m))
                this.monomials.put(entry.getKey(), m);
            else
                this.monomials.remove(entry.getKey());
        }
    }

    public Polynomial mul(Polynomial p) {
        Polynomial res = new Polynomial();

        for (Map.Entry<java.lang.Integer, Monomial> entry1:
             p.monomials.entrySet()) {
            for (Map.Entry<java.lang.Integer, Monomial> entry2:
                 this.monomials.entrySet()) {
                Monomial multiplied = entry1.getValue().mul(entry2.getValue());
                if (!monoIsZero(multiplied))
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

    public Polynomial derivative()
    {
        Polynomial p = new Polynomial();
        for (Map.Entry<java.lang.Integer, Monomial> entry:
                this.monomials.entrySet())
        {
            Monomial m = entry.getValue().derivative();
            if(!monoIsZero(m)) {
                p = p.add(new Polynomial(m));
            }
        }

        return p;
    }

    private static boolean monoIsZero(Monomial m) {
        return m.sign() == 0;
    }

    public TreeMap<java.lang.Integer, Monomial> getMonomials() {
        return monomials;
    }

    public boolean equals(Object p)
    {
        if(!(p instanceof Polynomial))
            return false;
        boolean output = true;
        Set<java.lang.Integer> keyset = this.monomials.keySet();
        for(Map.Entry<java.lang.Integer, Monomial> entry:
                ((Polynomial)p).monomials.entrySet())
        {

            output = this.monomials.containsKey(entry.getKey()) && this.monomials.get(entry.getKey()).equals(entry.getValue());
            if(!output) {
                return false;
            }
            keyset.remove(entry.getKey());

        }

        return keyset.isEmpty();
    }

    @Override
    public String toString()
    {
        String s = "";
        boolean first = true;

        for (Map.Entry<java.lang.Integer, Monomial> entry:
                this.monomials.entrySet()) {
            //s = s + entry.getValue().toString();
            Monomial m = entry.getValue();

            if (m.sign() == 1) {
                if (first)
                    first = false;
                else
                    s += "+";
                s +=  m.toString();
            }
            if (m.sign() == -1) {
                if (first)
                    first = false;
                s += m.toString();
            }
        }

        if(s.equals(""))
            return "0";

        return s;
    }
}

