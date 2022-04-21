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
        assertEquals(i, new Integer(0));

        i = i.add(new Integer(8));
        assertEquals(i, new Integer(8));

        i = i.add(new Integer(-11));
        assertEquals(i, new Integer(-3));

        i = i.add(new Rational(13, 2));
        assertEquals(i, new Rational(7, 2));
    }

    @Test
    void mul() {
        i = new Integer(1);

        i = i.mul(new Integer(8));
        assertEquals(i, new Integer(8));

        i = i.mul(new Integer(-3));
        assertEquals(i, new Integer(-24));

        i = i.mul(new Rational(3, 4));
        assertEquals(i, new Integer(-18));

        i = i.mul(new Integer(0));
        assertEquals(i, new Integer(0));
    }

    @Test
    void neg() {
        assertEquals(i.neg(), new Integer(0));

        i = new Integer(8);
        assertEquals(i.neg(), new Integer(-8));

        assertEquals(i.neg().neg(), new Integer(8));


    }

    @Test
    void power() {
        assertEquals(i.power(0), new Integer(1));

        assertEquals(i.power(12345), new Integer(0));

        i = new Integer(5);
        assertEquals(i.power(4), new Integer(625));

        i = new Integer(2);
        assertEquals(i.power(26), new Integer(67108864));

        assertEquals(i.power(0), new Integer(1));
    }

    @Test
    void sign() {
        assertEquals(0, i.sign());

        i = new Integer(20);
        assertEquals(1, i.sign());

        i = new Integer(-12);
        assertEquals(-1, i.sign());
    }

    @Test
    void testToString() {
        assertEquals("0", i.toString());

        i = new Integer(-8);
        assertEquals("-8", i.toString());

        i = new Integer(20);
        assertEquals("20", i.toString());

        i = new Integer(234568900);
        assertEquals("234568900", i.toString());
    }
}