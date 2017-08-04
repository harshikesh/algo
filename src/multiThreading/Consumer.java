package multiThreading;

/**
 * Created by harshikesh.kumar on 28/07/16.
 */
public class Consumer implements Runnable {
    private final BufferItem mBufferItem;

    public Consumer(BufferItem bi){
        mBufferItem = bi;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            consume();
        }
    }

    private void consume() {

        synchronized(mBufferItem){
            if(mBufferItem.buffer.size() == 0){
                try{
                    mBufferItem.wait();
                } catch (InterruptedException e){
                }
            }
            System.out.println("consuming item : "+Thread.currentThread().getName()+" eating : "+mBufferItem.buffer.get(0));
            mBufferItem.buffer.remove(0);
            mBufferItem.notifyAll();
        }
    }
}
