package learnjava;

/**
 * Created by harshikesh.kumar on 19/08/16.
 */
public class Primer {

    public boolean flagOdd = true;

   void printOdd(int i){
       synchronized (this){
           System.out.println(i);
           try {
               wait();
           } catch (InterruptedException e) {
           }
           flagOdd = true;
           notifyAll();
       }

    }
    void printEven(int i){
        synchronized (this){
            System.out.println(i);
            try {
                wait();
            } catch (InterruptedException e) {

            }
            flagOdd = false;
            notifyAll();
        }
    }
}

