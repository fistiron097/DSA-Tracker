public class Thread1 extends Thread{
    @Override
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println("main thread"+i);
        }
    }
}