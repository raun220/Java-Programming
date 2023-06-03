package MultiThreading;

public class ThreadByRunnableEasy implements Runnable{

    public void run() {
        try{
            for(int i =0; i<5; i++){
                System.out.println("Child thread2: "+i);
                Thread.sleep(500);

            }
        } catch (InterruptedException e){
            System.out.println("Child2 Interrupted");
        }
        System.out.println("Child2 Exiting");
    }
}

class Main2{
    public static void main(String[] args) {
        JoinExample ob1 = new JoinExample();
        Thread t1 = new Thread(ob1);
        t1.start();

// Creating Multiple thread
        JoinExample ob2 = new JoinExample();
        Thread t2 = new Thread(ob2);
        t2.start();

        JoinExample ob3 = new JoinExample();
        Thread t3 = new Thread(ob3);
        t3.start();
//  isAlive() and join()   : Both use to know whether thread finished or not
// boolean isAlive()  : return T if still running F otherwise
        System.out.println("Thread 1: "+ t1.isAlive());
        System.out.println("Thread 2: "+ t2.isAlive());
        System.out.println("Thread 3: "+ t3.isAlive());

// void join() : it waits until the thread on which it called is terminates
        try{
            System.out.println("waiting for thread to finish");
            t1.join();;
            t2.join();
            t3.join();
        } catch (InterruptedException e){
            System.out.println("Main thread interrupted"+e);
        }


// boolean isAlive()  : once terminate see isAlive() status, it should be F now
        System.out.println("Thread 1: "+ t1.isAlive());
        System.out.println("Thread 2: "+ t2.isAlive());
        System.out.println("Thread 3: "+ t3.isAlive());

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
