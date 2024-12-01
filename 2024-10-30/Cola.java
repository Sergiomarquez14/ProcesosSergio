public class Cola {
    private int[] buffer;
    private int capacidad;
    private int count = 0;
    private int in = 0;
    private int out = 0;

    public Cola(int capacidad) {
        this.capacidad = capacidad;
        buffer = new int[capacidad];
    }

    public synchronized void put(int valor) throws InterruptedException {
        while (count == capacidad) {
            wait();
        }
        buffer[in] = valor;
        in = (in + 1) % capacidad;
        count++;
        notifyAll();
    }

    public synchronized int take() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        int valor = buffer[out];
        out = (out + 1) % capacidad;
        count--;
        notifyAll();
        return valor;
    }

    public static class Productor implements Runnable {
        private Cola cola;

        public Productor(Cola cola) {
            this.cola = cola;
        }

        @Override
        public void run() {
            int valor = 0;
            try {
                while (true) {
                    Thread.sleep(500);
                    cola.put(valor);
                    System.out.println("Productor produjo: " + valor);
                    valor++;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static class Consumidor implements Runnable {
        private Cola cola;

        public Consumidor(Cola cola) {
            this.cola = cola;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);
                    int valor = cola.take();
                    System.out.println("Consumidor consumió: " + valor);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        Cola cola = new Cola(10);
        Thread productorThread = new Thread(new Productor(cola));
        Thread consumidorThread = new Thread(new Consumidor(cola));
        
        productorThread.start();
        consumidorThread.start();
    }
}
