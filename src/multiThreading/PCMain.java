package multiThreading;

/**
 * Created by harshikesh.kumar on 28/07/16.
 */
public class PCMain {

    public static void main(String[] args) {
        BufferItem bt =new BufferItem();

        Producer producer = new Producer(bt);
        Thread t1 = new Thread(producer);
        t1.setName("Producer");
        Consumer consumer = new Consumer(bt);
        Consumer consumer2 = new Consumer(bt);
        Thread t2 = new Thread(consumer);
        t2.setName("Harsh");
        Thread t3 = new Thread(consumer2);
        t3.setName("Risabh");
        t1.start();
        t2.start();
        t3.start();

    }
}
