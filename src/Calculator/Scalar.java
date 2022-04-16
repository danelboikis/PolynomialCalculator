package Calculator;

public interface Scalar {
    public Scalar add(Scalar s);

    public Scalar add(Integer s);

    public Scalar add(Rational s);

    public Scalar mul(Scalar s);

    public Scalar mul(Integer s);

    public Scalar mul(Rational s);

    public Scalar neg();

    public Scalar power(int exponent);

    public int sign();

    public Scalar clone();
}
