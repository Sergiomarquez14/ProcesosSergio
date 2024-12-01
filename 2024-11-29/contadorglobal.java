class Contador {
    private int contador = 0;

    public synchronized void incrementar() {
        contador++;
    }

    public int getContador() {
        return contador;
    }
}

    class HiloContador extends Thread {
    private Contador contador;

    public HiloContador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            contador.incrementar();
        }
    }
}

public class contadorglobal {
    public static void main(String[] args) {
        Contador contador = new Contador();

        HiloContador hilo1 = new HiloContador(contador);
        HiloContador hilo2 = new HiloContador(contador);
        HiloContador hilo3 = new HiloContador(contador);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(contador.getContador());
    }
}
