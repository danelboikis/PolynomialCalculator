package Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerTest {

    private Scalar i;

    @BeforeEach
    void setUp() {
        i = new Integer(0);
    }

    @Test
    void add() {
        i = i.add(new Integer(0));
        assertTrue(i.equals(new Integer(0)));

        i = i.add(new Integer(8));
        assertTrue(i.equals(new Integer(8)));

        i = i.add(new Integer(-11));
        assertTrue(i.equals(new Integer(-3)));

        i = i.add(new Rational(13, 2));
        assertTrue(i.equals(new Rational(7, 2)));
    }

    @Test
    void mul() {
        i = new Integer(1);

        i = i.mul(new Integer(8));
        assertTrue(i.equals(new Integer(8)));

        i = i.mul(new Integer(-3));
        assertTrue(i.equals(new Integer(-24)));

        i = i.mul(new Rational(3, 4));
        assertTrue(i.equals(new Integer(-18)));

        i = i.mul(new Integer(0));
        assertTrue(i.equals(new Integer(0)));
    }

    @Test
    void neg() {
        assertTrue(i.neg().equals(new Integer(0)));

        i = new Integer(8);
        assertTrue(i.neg().equals(new Integer(-8)));

        assertTrue(i.neg().neg().equals(new Integer(8)));


    }

    @Test
    void power() {
        assertTrue(i.power(0).equals(new Integer(1)));

        assertTrue(i.power(12345).equals(new Integer(0)));

        i = new Integer(5);
        assertTrue(i.power(4).equals(new Integer(625)));

        i = new Integer(2);
        assertTrue(i.power(26).equals(new Integer(67108864)));

        assertTrue(i.power(0).equals(new Integer(1)));
    }

    @Test
    void sign() {
        assertTrue(i.sign() == 0);

        i = new Integer(20);
        assertTrue(i.sign() == 1);

        i = new Integer(-12);
        assertTrue(i.sign() == -1);
    }

    @Test
    void testToString() {
        assertTrue(i.toString().equals("0"));

        i = new Integer(-8);
        assertTrue(i.toString().equals("-8"));

        i = new Integer(20);
        assertTrue(i.toString().equals("20"));

        i = new Integer(234568900);
        assertTrue(i.toString().equals("234568900"));
    }
}