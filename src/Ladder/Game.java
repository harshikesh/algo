package Ladder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 01/04/17.
 */
public class Game {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        Queue<Player> playersQueue = new LinkedList();

        for (int i = 0; i < num; i++) {
            Player p = new Player("player : " +i);
            playersQueue.add(p);
        }
        play(playersQueue);

    }

    static void play(Queue<Player> players){

        while (!isFinished(players))
        {
            Player current = players.peek();

        }
    }

    private static boolean isFinished(Queue<Player> players) {
        for (Player p: players) {
            if(p.pos != 100){
                return false;
            }
        }
        return true;
    }

}
