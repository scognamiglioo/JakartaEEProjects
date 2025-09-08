
package io.github.scognamiglioo.juliavelosoapp1;

public class Calculadora {
    private double a;
    private double b;

    public Calculadora(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double somar() {
        return a + b;
    }

    public double subtrair() {
        return a - b;
    }

    public double multiplicar() {
        return a * b;
    }

    public double dividir() throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida!");
        }
        return a / b;
    }
}
