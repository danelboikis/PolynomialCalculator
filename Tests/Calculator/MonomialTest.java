package Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {
    private Monomial m;

    @BeforeEach
    void setUp() {
        m = new Monomial(1, new Integer(1));
    }

    @Test
    void add() {
        assertEquals(m.add(new Monomial(1, new Rational(3, 10))), new Monomial(1, new Rational(13, 10)));

        m = new Monomial(3, new Integer(3));
        assertEquals(m.add(new Monomial(3, new Integer(-4))), new Monomial(3, new Integer(-1)));

        assertEquals(m.add(new Monomial(3, new Rational(0, 123))), m);

        assertEquals(m.add(new Monomial(4, new Integer(0))), m);

        assertEquals(m.add(new Monomial(4, new Integer(17))), null);
    }

    @Test
    void mul() {
        assertEquals(m.mul(new Monomial(3, new Rational(1, 2))), new Monomial(4, new Rational(1, 2)));

        m = new Monomial(3, new Rational(3, 10));
        assertEquals(m.mul(new Monomial(0, new Integer(32))), new Monomial(3, new Rational(96, 10)));

        assertEquals(m.mul(new Monomial(43, new Integer(0))), new Monomial(46, new Integer(0)));
    }

    @Test
    void evaluate() {
        assertEquals(m.evaluate(new Integer(7)), new Integer(7));

        m = new Monomial(3, new Rational(7, 10));
        assertEquals(m.evaluate(new Rational(7, 10)), new Rational(2401, 10000));

        assertEquals(m.evaluate(new Integer(0)), new Integer(0));

        m = new Monomial(0, new Integer(33));
        assertEquals(m.evaluate(new Rational(327488, 2389)), new Integer(33));
    }

    @Test
    void derivative() {
        m = m.derivative();
        assertEquals(m, new Monomial(0, new Integer(1)));

        assertEquals(m.derivative(), new Monomial(0, new Integer(0)));

        m = new Monomial(14, new Rational(16, 14));
        assertEquals(m.derivative(), new Monomial(13, new Integer(16)));
    }

    @Test
    void sign() {
        assertEquals(m.sign(), 1);

        m = new Monomial(3, new Rational(-1, 2));
        assertEquals(m.sign(), -1);

        assertEquals(m.mul(new Monomial(123, new Integer(-12334))).sign(), 1);

        assertEquals(m.mul(new Monomial(123, new Integer(0))).sign(), 0);
    }

    @Test
    void testToString() {
        assertEquals(m.toString(), "x");

        m = new Monomial(1, new Integer(-1));
        assertEquals(m.toString(), "-x");

        m = new Monomial(3, new Integer(-1));
        assertEquals(m.toString(), "-x^3");

        m = new Monomial(32, new Integer(0));
        assertEquals(m.toString(), "0");

        m = new Monomial(0, new Integer(32));
        assertEquals(m.toString(), "32");

        m = new Monomial(1, new Integer(-1));
        assertEquals(m.toString(), "-x");

        m = new Monomial(3, new Integer(34));
        assertEquals(m.toString(), "34x^3");

        m = new Monomial(0, new Integer(-1));
        assertEquals(m.toString(), "-1");

        m = new Monomial(0, new Rational(3, 3));
        assertEquals(m.toString(), "1");

        m = new Monomial(1, new Rational(9, 3));
        assertEquals(m.toString(), "3x");
    }
}