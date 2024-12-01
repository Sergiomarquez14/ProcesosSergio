public class hilomaskrunnable implements Runnable {

    private Thread hilo;

    public hilomaskrunnable(String name) {
        this.hilo = new Thread(this, name);
        this.hilo.start();
    }

    public void run() {
        for (int i = 0; i <= 30; i++) {
            System.out.println(this.hilo.getName() + " el contador " + i);
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        hilo.start();
    }

    // public void ejecutarhilo(){
    //     this.hilo.start();
    // }

    public static void main(String[] args) {
        hilomaskrunnable minihilo1 = new hilomaskrunnable("Tesla");
        hilomaskrunnable minihilo2 = new hilomaskrunnable("Cristiano");
        minihilo1.hilo.setPriority(Thread.MAX_PRIORITY);
        minihilo2.hilo.setPriority(Thread.MIN_PRIORITY);
        minihilo1.start();
        minihilo2.start();
    }
}
