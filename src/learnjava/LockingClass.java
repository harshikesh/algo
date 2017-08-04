package learnjava;

/**
 * Created by harshikesh.kumar on 20/08/16.
 */
public class LockingClass {
    static int a;

     synchronized void inc(){
        a = a+1;
        System.out.println(Thread.currentThread().getName() + " " +a);
         try {
             Thread.sleep(100);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

     }
}
