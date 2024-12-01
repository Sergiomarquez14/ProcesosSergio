public class ejercicio2 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Este es el hilo run: " + i);
            try {
                sleep((long) (Math.random() * 1000)); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ejercicio2 hilo = new ejercicio2();
        hilo.start();
    }
}
