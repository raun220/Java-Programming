package MultiThreading;

public class SynchronizedMethod {
    synchronized void call(String msg){
        System.out.print("["+msg);
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]"+msg);
    }
}
class Caller1 implements Runnable{
    String msg;
    SynchronizedMethod target;
  //  Thread t;

    public Caller1(SynchronizedMethod t, String m) {
        target = t;
        msg = m;
      // t = new Thread(this);
      // t.start();
    }
    public void run(){
        target.call(msg);
    }
}
 class Main4{
     public static void main(String[] args) {
        SynchronizedMethod synchronizedMethod = new SynchronizedMethod();

        Caller1 ob1 = new Caller1(synchronizedMethod, "Hello");
      //  ob1.t.start();
        Thread t1 = new Thread(ob1);
        t1.start();

        Caller1 ob2 = new Caller1(synchronizedMethod, "World");
      //  ob2.t.start();
        Thread t2 = new Thread(ob2);
        t2.start();

         // wait for threads to end
         try {
             t1.join();
             t2.join();
         } catch(InterruptedException e) {
             System.out.println("Interrupted");
         }


     }
 }



