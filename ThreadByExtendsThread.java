package MultiThreading;

public class ThreadByExtendsThread extends Thread{
    public void run() {
        try{
            for(int i =0; i<5; i++){
                System.out.println("Child3 thread: "+i);
                Thread.sleep(500);

            }
        } catch (InterruptedException e){
            System.out.println("Child3 Interrupted");
        }
        System.out.println("Child3 Exiting");
    }
}
class Main3{
    public static void main(String[] args) {
        ThreadByExtendsThread ob1 = new ThreadByExtendsThread();
        ob1.start();

// Creating Multiple thread
        ThreadByExtendsThread ob2 = new ThreadByExtendsThread();
        ob2.start();

        ThreadByExtendsThread ob3 = new ThreadByExtendsThread();
        ob3.start();

        try{
            for(int i =0; i<5; i++){
                System.out.println("Main3 thread: "+i);
                Thread.sleep(1000);

            }
        } catch (InterruptedException e){
            System.out.println("Main3 Interrupted");
        }
        System.out.println("Main3 Exiting");
    }

}
