package datastructure;

import java.util.LinkedList;

/**
 * Created by harshikesh.kumar on 15/06/16.
 */
public class FirstNonRepeating {

    static LinkedList<Character> list = new LinkedList<>();
    static boolean vis[ ] = new boolean[256];
    static void firstNonRepeating(char a){
        if(!vis[a-'a']){
            if(!list.contains(a)){
                list.add(a);
            }else{
                list.remove(list.indexOf(a));
                vis[a-'a'] = true;
            }
        }
        System.out.println(list.get(0));
    }

    public static void main(String[] args) {
        firstNonRepeating('a');
        firstNonRepeating('c');
        firstNonRepeating('c');
        firstNonRepeating('d');
        firstNonRepeating('a');
        firstNonRepeating('k');
        firstNonRepeating('d');

    }
}
