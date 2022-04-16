package Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {
    private Polynomial p;

    @BeforeEach
    void setUp() {
        p = new Polynomial();
        p = Polynomial.build("1");
    }

    @Test
    void build() {
        TreeMap<java.lang.Integer, Monomial> monomials = new TreeMap<>();

        p = Polynomial.build("1 2 3 4");
        monomials.put(0, new Monomial(0, new Integer(1)));
        monomials.put(1, new Monomial(1, new Integer(2)));
        monomials.put(2, new Monomial(2, new Integer(3)));
        monomials.put(3, new Monomial(3, new Integer(4)));
        assertEquals(p.getMonomials(), monomials);

        p = Polynomial.build("13/2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -34/13");
        monomials = new TreeMap<>();
        monomials.put(0, new Monomial(0, new Rational(13, 2)));
        monomials.put(15, new Monomial(15, new Rational(-34, 13)));
        assertEquals(p.getMonomials(), monomials);

        p = Polynomial.build("   0 0 0 0 0 0 0 0 0 0 0 0 0          0 0 0 0 0 0 0 0 0 40 0 0 0 0   ");
        monomials = new TreeMap<>();
        monomials.put(22, new Monomial(22, new Rational(80, 2)));
        assertEquals(p.getMonomials(), monomials);

        //assertEquals(Polynomial.build(""));
    }

    @Test
    void add() {
        assertEquals(p.add(Polynomial.build("1 0 0 3")), Polynomial.build("2 0 0 3 0 0"));

        p = Polynomial.build("0 0 0 3 5 0");
        assertEquals(p.add(Polynomial.build("0 0 0")), p);

        assertEquals(p.add(Polynomial.build("3 0 0 3 7 9 0 0 0")), Polynomial.build("3 0 0 6 12 9"));

        assertEquals(p.add(Polynomial.build("0 0 0 -3 5")), Polynomial.build("0 0 0 0 10"));

        assertEquals(p.add(Polynomial.build("0 0 0 -3 -5")), Polynomial.build("0"));
    }

    @Test
    void mul() {
        assertEquals(p.mul(Polynomial.build("1 3 0 4")), Polynomial.build("1 3 0 4"));

        p = Polynomial.build("2 0 3 -8 -3");
        assertEquals(p.mul(Polynomial.build("3 0 -3 4")), Polynomial.build("6 0 3 -16 -18 36 -23 -12"));
    }

    @Test
    void evaluate() {
        p = Polynomial.build("9 5 4 1");
        assertEquals(p.evaluate(new Integer(3)), new Integer(87));

        p = Polynomial.build("15 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1");
        assertEquals(p.evaluate(new Integer(2)), new Integer(2097167));

        p = Polynomial.build("-920847 400000 0 0 0 0 0 0 0 1");
        assertEquals(p.evaluate(new Rational(7, 2)), new Rational(285679943, 512));
    }

    @Test
    void derivate() {
        assertEquals(p.derivate(), Polynomial.build("0"));

        p = Polynomial.build("1 1 1/2 1/3 1/4 0 1/6");
        assertEquals(p.derivate(), Polynomial.build("1 1 1 1 0 1"));

        p = Polynomial.build("0 50 0 0 0 0 0 0 0 13 1/100");
        assertEquals(p.derivate(), Polynomial.build("50 0 0 0 0 0 0 0 117 1/10"));
    }

    @Test
    void testToString() {
        assertEquals(p.toString(), "1");

        p = Polynomial.build("13 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0");
        assertEquals(p.toString(), "13");

        p = Polynomial.build("1 2 3 0 0 -4/5 -7 7/8");
        assertEquals(p.toString(), "1+2x+3x^2-4/5x^5-7x^6+7/8x^7");

        p = Polynomial.build("-4/8 3 -3/9");
        assertEquals(p.toString(), "-1/2+3x-1/3x^2");
    }
}