import java.util.Random;
 
class ejercicio1 extends Thread {
   
    public ejercicio1(String nombre) {
        super(nombre);
    }
   
    @Override
    public void run() {
        Random random = new Random();
       
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("Este es el hilo " + getName());
                Thread.sleep(random.nextInt(1000) + 500);
            } catch (InterruptedException e) {
                System.out.println("El hilo " + getName() + " fue interrumpido.");
            }
        }
    }
 
    public static void main(String[] args) {
        // Crea y empieza dos hilos
        ejercicio1 hilo1 = new ejercicio1("Barcelona");
        ejercicio1 hilo2 = new ejercicio1("Madrid");
 
        hilo1.start();
        hilo2.start();
    }
}