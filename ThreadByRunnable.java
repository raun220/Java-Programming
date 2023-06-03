package MultiThreading;

public class ThreadByRunnable implements Runnable{
    Thread thread;
    ThreadByRunnable() {
        thread = new Thread(this, "Demo thread");
        System.out.println("Child thread: "+thread);
    }
    public void run() {
        try{
            for(int i =0; i<5; i++){
                System.out.println("Child thread: "+i);
                thread.sleep(500);

            }
        } catch (InterruptedException e){
            System.out.println("Child Interrupted");
        }
        System.out.println("Child Exiting");
    }
}
class Main{
    public static void main(String[] args) {
        ThreadByRunnable ob1 = new ThreadByRunnable();
        ob1.thread.start(); // start the thread


        try{
            for(int i =0; i<5; i++){
                System.out.println("Main thread: "+i);
               Thread.sleep(1000);

            }
        } catch (InterruptedException e){
            System.out.println("Main Interrupted");
        }
        System.out.println("Main Exiting");
    }

}
