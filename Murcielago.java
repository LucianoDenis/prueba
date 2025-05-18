package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Murcielago {
    private int x, y;
    private int velocidad;
    private boolean haciaDerecha;
    private Image imgIzquierda;
    private Image imgDerecha;

    public Murcielago(int x, int y) {
        this.x = x;
        this.y = y;
        this.velocidad = 2;
        this.haciaDerecha = true;

        this.imgIzquierda = Herramientas.cargarImagen("murcielago_izq.jpg");
        this.imgDerecha = Herramientas.cargarImagen("murcielago_der.jpg");
    }

    public void mover() {
        if (haciaDerecha) {
            x += velocidad;
            if (x >= 610 - 20) { // Rebotar al llegar a la derecha
                haciaDerecha = false;
            }
        } else {
            x -= velocidad;
            if (x <= 60) { // Rebotar al llegar a la izquierda
                haciaDerecha = true;
            }
        }
    }

    public void dibujar(Entorno e) {
        Image imgActual = haciaDerecha ? imgDerecha : imgIzquierda;
        e.dibujarImagen(imgActual, x, y, 0, 0.19); // 0.3 es escala para hacerlo más chico
    }
}