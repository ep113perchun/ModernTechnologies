package ru.home.app.types;

public class TFrac {
    private int numerator;
    private int denominator;

    public TFrac(int numerator, int denominator) throws Exception {
        if (denominator == 0) {
            throw new Exception("ERROR: Denominator == 0");
        };
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public TFrac(String frac) throws Exception {
        String[] words = frac.split("/");
        this.numerator = Integer.parseInt(words[0]);
        this.denominator = Integer.parseInt(words[1]);

        if (denominator == 0) {
            throw new Exception("ERROR: Denominator == 0");
        };
        simplify();
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    private void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public TFrac copy() throws Exception { // копировать
        return new TFrac(numerator, denominator);
    }

    public TFrac addUp(TFrac value) throws Exception { // прибавить
        TFrac temp = new TFrac(
                this.numerator * value.denominator + this.denominator * value.numerator,
                this.denominator * value.denominator
        );
        temp.simplify();
        return temp;
    }

    public TFrac subtract(TFrac value) throws Exception { // вычесть
        TFrac temp = new TFrac(
                this.numerator * value.denominator - this.denominator * value.numerator,
                this.denominator * value.denominator
        );
        temp.simplify();
        return temp;
    }

    public TFrac multiplyBy(TFrac value) throws Exception { // умножить на
        return new TFrac(this.numerator * value.numerator, this.denominator * value.denominator);
    }

    public TFrac divideBy(TFrac value) throws Exception{ // делить на
        if (value.denominator == 0) {
            throw new Exception("ERROR:  Value denominator == 0");
        };
        return new TFrac(this.numerator * value.denominator, this.denominator * value.numerator);
    }

    public TFrac squared() throws Exception {
        int newNumerator = numerator * numerator;
        int newDenominator = denominator * denominator;

        return new TFrac(newNumerator, newDenominator);
    }


    public TFrac reverse() throws Exception { // обратное
        return new TFrac(denominator, numerator);
    }

    public TFrac minus() throws Exception { // минус
        return new TFrac(-this.numerator, this.denominator) ;
    }

    public boolean isEqually(TFrac value) { // равно
        this.simplify();
        value.simplify();
        return this.numerator == value.numerator && this.denominator == value.denominator;
    }

    public boolean isMore(TFrac value) { // больше
        return this.numerator * value.denominator > value.numerator * this.denominator;
    }

    public int takeNumeratorNumber() {
        return numerator;
    }

    public int takeDenominatorNumber() {
        return denominator;
    }

    public String takeNumeratorString() {
        return numerator + "";
    }

    public String takeDenominatorString() {
        return denominator + "";
    }

    public String takeFracString() {
        return numerator + "/" + denominator;
    }
}