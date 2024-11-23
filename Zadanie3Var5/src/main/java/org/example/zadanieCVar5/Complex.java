package org.example.zadanieCVar5;

public class Complex {
    private RationalFraction real;
    private RationalFraction imaginary;

    // Конструктор
    public Complex(RationalFraction real, RationalFraction imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Сложение комплексных чисел
    public Complex add(Complex other) {
        RationalFraction newReal = this.real.add(other.real);
        RationalFraction newImaginary = this.imaginary.add(other.imaginary);
        return new Complex(newReal, newImaginary);
    }

    // Умножение комплексных чисел
    public Complex multiply(Complex other) {
        RationalFraction newReal = this.real.multiply(other.real)
                .add(this.imaginary.multiply(other.imaginary).multiply(new RationalFraction(-1, 1)));
        RationalFraction newImaginary = this.real.multiply(other.imaginary)
                .add(this.imaginary.multiply(other.real));
        return new Complex(newReal, newImaginary);
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}