

class Filosofo extends Thread {
    private int id;
    private Tenedor tenedorIzquierdo;
    private Tenedor tenedorDerecho;
    
    public Filosofo (int id, Tenedor tenedorIzquierdo, Tenedor tenedorDerecho){
       this.id = id;
       this.tenedorIzquierdo = tenedorIzquierdo;
       this.tenedorDerecho = tenedorDerecho;
    }
 
    @Override
    public void run() {
       try {
          while (true){
             pensar();
             tomarTenedores();
             comer();
             soltarTenedores();
          } 
       } catch (InterruptedException e){
          e.printStackTrace();
       }
    }
 
    private void pensar() throws InterruptedException {
          System.out.println ("filosofo: " + this.id + "está pensando");
          Thread.sleep((long) Math.random()*1000);
    }
  
    private void tomarTenedores() {
       System.out.println ("Filosofo: "+ this.id + "está intentando coger tenedores");
       synchronized (tenedorIzquierdo) {
          System.out.println ("Filosofo: "+ this.id + "ha pillado el tenedor izquierdo");
          System.out.println ("Filosofo: "+ this.id + "está intentando coger tenedor derecho");
          synchronized (tenedorDerecho) {
             System.out.println ("Filosofo: "+ this.id + "ha pillado el tenedor derecho");
          }
       }
    }
 
    private void comer () throws InterruptedException{
       System.out.println ("filosofo: " + this.id + "está papeando");
          Thread.sleep((long) Math.random()*1000);
    }
    
    private void soltarTenedores (){
       System.out.println ("filosofo: " + this.id + "está suelta tenedores");
    }
 
     
 }
 
 class Tenedor {}
 
 public class Filosofo_deadlock{
    public static void main(String[] args) {
       Filosofo[] filosofos = new Filosofo [5];
       Tenedor [] tenedores = new Tenedor [5];
 
       for (int i=0; i<5;i++) {
          tenedores[i] = new Tenedor();
       }
 
       for (int i=0; i<5; i++) {
          Tenedor tenedorIzquierdo = tenedores[i];
          Tenedor tenedorDerecho = tenedores [(i+1)%5];
          
          filosofos[i] = new Filosofo(i, tenedorIzquierdo, tenedorDerecho);
          filosofos[i].start();
       }
    }
 
 }
 
 
 
 