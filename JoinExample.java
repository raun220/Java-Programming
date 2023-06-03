package MultiThreading;


public class JoinExample implements Runnable{

    public void run() {
        try{
                System.out.println("Child thread2: ");
                Thread.sleep(500);

        } catch (InterruptedException e){
            System.out.println("Child2 Interrupted");
        }
        System.out.println("Child2 Exiting");
    }
}

class MainJoin{
    public static void main(String[] args) {
        JoinExample ob1 = new JoinExample();
        Thread t1 = new Thread(ob1);
        t1.start();
        try {
            t1.join();
        } catch(InterruptedException e) {
            System.out.println("Join 1 interrupted");
        }
        System.out.println("Thread 1: "+ t1.isAlive());


        JoinExample ob3 = new JoinExample();
        Thread t3 = new Thread(ob3);
        t3.start();
        try {
            t3.join();
        } catch(InterruptedException e) {
            System.out.println("Join 3 interrupted");
        }
        System.out.println("Thread 3: "+ t3.isAlive());

        JoinExample ob2 = new JoinExample();
        Thread t2 = new Thread(ob2);
        t2.start();
        try {
            t2.join();
        } catch(InterruptedException e) {
            System.out.println("Join 2 interrupted");
        }
        System.out.println("Thread 2: "+ t2.isAlive());

//  isAlive() and join()   : Both use to know whether thread finished or not
// void join() : it waits until the thread on which it called is terminates
// boolean isAlive()  : once terminate see isAlive() status, it should be F now

// main thread
        try{
            for(int i =0; i<5; i++){
                System.out.println("Main thread2: "+i);
                Thread.sleep(1000);

            }
        } catch (InterruptedException e){
            System.out.println("Main2 Interrupted");
        }
        System.out.println("Main2 Exiting");
    }

}
