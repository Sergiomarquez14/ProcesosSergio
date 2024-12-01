import java.util.Random;

public class ejercicio3 implements Runnable {

    public void run() {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(1000));
            System.out.println("Thread is running.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ejercicio3 runnable = new ejercicio3();
        Thread h1 = new Thread(runnable);
        h1.start();
        System.out.println("Estado despues del start: " + h1.getState());
        try {
            Thread.sleep(500);
            System.out.println("Estado despues de 500ms: " + h1.getState());
            Thread.sleep(1000);
            System.out.println("Estado despues de 1500ms: " + h1.getState());
            h1.join();
            System.out.println("Estado fin " + h1.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
