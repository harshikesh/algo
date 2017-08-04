package Ladder;

/**
 * Created by harshikesh.kumar on 01/04/17.
 */
public class Player implements Runnable {

    final String name;

    Integer pos = 0;

    public Player(String n){
        name = n;
    }

    @Override
    public void run() {

    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

}
