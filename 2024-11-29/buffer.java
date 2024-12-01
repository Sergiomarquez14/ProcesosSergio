public class buffer {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        // Productor
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    buffer.put(i);
                    Thread.sleep(500); // Simula tiempo de producción
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumidor
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    buffer.get();
                    Thread.sleep(1000); // Simula tiempo de consumo
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
