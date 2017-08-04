package learnjava;

import java.util.concurrent.locks.Lock;

/**
 * Created by harshikesh.kumar on 20/08/16.
 */
public class StaticSync {
    public static void main(String[] args) {
        LockingClass l1= new LockingClass();
        LockingClass l2 = new LockingClass();

        Thread t2 = new Thread(new Runna(l2));
        Thread t1 = new Thread(new Runna(l1));

        t1.start();
        t2.start();

    }

}
class Runna implements Runnable{
    LockingClass l1 ;
    Runna(LockingClass l){
        l1 = l;
    }
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {

            l1.inc();
        }

    }
}
