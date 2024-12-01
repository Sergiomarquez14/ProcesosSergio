public class hilomask extends Thread{
    public hilomask(String name){
        super(name);
    }
    public void run(){
        for(int i=0;i<=30;i++){
            System.out.println(this.getName() + " el contador " + i);
            try{
                sleep((long)Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        hilomask minihilomask1 = new hilomask("tesla");
        hilomask minihilomask2 = new hilomask("cristiano");
        minihilomask1.setPriority(MAX_PRIORITY);
        minihilomask2.setPriority(MIN_PRIORITY);
        minihilomask1.start();
        minihilomask2.start();
    }
}