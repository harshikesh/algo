package learnjava;

/**
 * Created by harshikesh.kumar on 19/08/16.
 */
public class OddEven {


    static Primer prime ;

    public static void main(String[] args) {
        prime = new Primer();
        Thread odd = new Thread(new Run(prime,10,true));
        Thread even = new Thread(new Run(prime,10,false));
        odd.start();
        even.start();

    }

}
class Run implements Runnable{

    private final int total;
    private final boolean flag;
    private final Primer primer;

    Run(Primer prime , int val, boolean t){
        primer  = prime;
        total =val;
        flag= t;
    }

    int val = 1;

    @Override
    public void run() {

        synchronized (primer){

            while (val < total) {
                if (val % 2 == 0 ) {
                    System.out.println("Thread even");
                    primer.printEven(val);
                }
                if (val % 2 != 0 ) {
                    System.out.println("Thread odd");
                    primer.printOdd(val);
                }
                val++;
            }

        }

    }
}


