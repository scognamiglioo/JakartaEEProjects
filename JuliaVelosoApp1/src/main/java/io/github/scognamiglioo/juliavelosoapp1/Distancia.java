
package io.github.scognamiglioo.juliavelosoapp1;


public class Distancia {
    public static double calcular(Ponto p1, Ponto p2) {
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
