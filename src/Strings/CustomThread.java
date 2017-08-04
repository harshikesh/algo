package Strings;

/**
 * Created by harshikesh.kumar on 31/03/17.
 */
public class CustomThread implements Runnable  {

    private final Object mLock;
    private final int line;
    private final String mName;
    private final String mMessage;

    public CustomThread(String name,int li,Object lock,String message){
        mName = name;
        mLock = lock;
        line = li;
        mMessage = message;

    }

    @Override
    public void run() {
        FileHelper.writeToFile(mMessage,line,mLock);
    }
}
