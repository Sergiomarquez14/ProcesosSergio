import java.util.Random;

public class juego extends Thread {

    public static final int META = 100;
    private String name = "";
    private int posicion;

    public juego(String name) {
        this.name = name;
    }

    public void run() {
        Random random = new Random();
        while (posicion < META) {
            int avance = random.nextInt(10);
            posicion += avance;
            mostrarposicion();
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void mostrarposicion() {
        StringBuilder hipodromo = new StringBuilder();
        for (int i = 0; i < META; i++) {
            if (i == posicion) {
                hipodromo.append(name);
            } else {
                hipodromo.append("-");
            }
        }
        System.out.println(hipodromo.toString());
    }

    public static void main(String[] args) {
        juego caballo1 = new juego("C1");
        juego caballo2 = new juego("C2");
        caballo1.start();
        caballo2.start();
    }
}

