import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by harshikesh.kumar on 09/03/17.
 */
public class Learning {

    private static ExecutorService executorService;

    public static void main(String[] args) {

        executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // System.out.println("calling again");
            checkstatus();
        }

    }

    private static void checkstatus() {

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "begin");
                doHardAllocations();
            }

        });
    }

    private static void doHardAllocations() {

        System.out.println(Thread.currentThread().getName() + "end");
    }
}
