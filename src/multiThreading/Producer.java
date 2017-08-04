package multiThreading;

/**
 * Created by harshikesh.kumar on 28/07/16.
 */
public class Producer implements  Runnable {


    BufferItem mBufferItem ;
    public  Producer(BufferItem bi){
        mBufferItem =bi;
    }

    @Override
    public void run() {

        for (int i = 0; i < 50; i++) {

            produce(i);
        }
    }

    private void produce(int i) {

        synchronized (mBufferItem) {
            try {
                if(mBufferItem.buffer.size() == 1)
                    mBufferItem.wait();
            } catch (InterruptedException e) {
            }

            mBufferItem.buffer.add(i);
            System.out.println("adding one item " + i);
            mBufferItem.notifyAll();

        }



    }

}
