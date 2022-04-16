package Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalTest {
    private Scalar r;
    private Rational r2;

    @BeforeEach
    void setUp() {
        r = new Rational(1, 2);
        r2 = new Rational(1, 2);
    }

    @Test
    void add() {
        r = r.add(new Rational(0, 1));
        assertEquals(r ,new Rational(1, 2));

        r = r.add(r2);
        assertEquals(r, new Integer(1));

        r = r.add(new Rational(1, 12345));
        assertEquals(r, new Rational(12346, 12345));

        r = new Rational(1, 1);
        r = r.add(new Rational(1, 1000000));
        assertEquals(r, new Rational(1000001, 1000000));

        r2 = new Rational(-3, 2);
        r = r.add(r2);
        assertEquals(r, new Rational(-499999, 1000000));
    }

    @Test
    void mul() {
        r = r.mul(r2);
        assertEquals(r, new Rational(1, 4));

        r2 = new Rational(400,53);
        r = r.mul(r2);
        assertEquals(r, new Rational(100, 53));

        r = r.mul(new Rational(-13, 43));
        assertEquals(r, new Rational(-1300, 2279));

        r = r.mul(new Integer(0));
        assertEquals(r, new Integer(0));
    }

    @Test
    void neg() {
        r = r.neg();
        assertEquals(r, new Rational(-1, 2));

        r = r.neg();
        assertEquals(r, r2);

        r2 = new Rational(0, 111);
        r = r2.neg();
        assertEquals(r, new Integer(0));
    }

    @Test
    void power() {
        r = r.power(2);
        assertEquals(r, new Rational(1, 4));

        r = r.power(13);
        assertEquals(r, new Rational(1, 67108864));

        r = r.power(0);
        assertEquals(r, new Integer(1));
    }

    @Test
    void sign() {
        assertEquals(r.sign(), 1);

        r = new Rational(-3, -4);
        assertEquals(r.sign(), 1);

        r = new Rational(3, -4);
        assertEquals(r.sign(), -1);

        r = new Rational(0, 127);
        assertEquals(r.sign(), 0);
    }

    @Test
    void reduce() {
        assertEquals(r2.reduce(), r);

        r2 = new Rational(3, 6);
        assertEquals(r2, r);

        r2 = new Rational(-27, 36);
        assertEquals(r2.reduce(), new Rational(-3, 4));

        r2 = new Rational(0,4);
        assertEquals(r2.reduce(), new Integer(0));
    }

    @Test
    void testToString() {
        assertEquals(r.toString(), "1/2");

        r = new Rational(-1, -3);
        assertEquals(r.toString(), "1/3");

        r = new Rational(3, -9);
        assertEquals(r.toString(), "-1/3");

        r = new Rational(0, 327);
        assertEquals(r.toString(), "0");

        r = new Rational(14, 7);
        assertEquals(r.toString(), "2");
    }
}