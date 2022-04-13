package Calculator;

public class Main {

    public static void main(String[] args) {
        Scalar s1 = new Rational(-30, 13);
        Scalar s2 = new Integer(-5);

        Monomial m1 = new Monomial(3, s1);
        Monomial m2 = new Monomial(3, s2);


        System.out.println(m1.toString());
        System.out.println(m1.mul(m2).toString());
        System.out.println(m1.add(m2).toString());
        System.out.println(m1.derivative().toString());

    }
}
