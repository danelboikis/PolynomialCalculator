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
        assertEquals(r ,new Rational(0, 1));
    }

    @Test
    void mul() {
    }

    @Test
    void neg() {
    }

    @Test
    void power() {
    }

    @Test
    void sign() {
    }

    @Test
    void reduce() {
    }

    @Test
    void testToString() {
    }
}