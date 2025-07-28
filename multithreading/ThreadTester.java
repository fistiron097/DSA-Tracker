// If any of our user thread is there our program will run it will terminate only when no user thread is left

public class ThreadTester{
    public static void main(String[]args){
        MyRunnable myRunnable = new MyRunnable();

        Thread thread1 = new Thread(myRunnable, "Thread-1");
        thread1.start();
        Thread thread2 = new Thread(myRunnable, "Thread-2");
        thread2.start();
    }
}