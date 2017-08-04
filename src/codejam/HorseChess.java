package codejam;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by harshikesh.kumar on 07/06/17.
 */
public class HorseChess {

    public static void main(String[] args) {

       int ans = answer(0,63);
        System.out.println(ans);
    }

    static int answer(int src,int dest){
        Node node1 =new Node(src,0);
        Node node2 =new Node(dest,-1);
       return bfs(node1,node2);
    }
  static int row[] = { 2, 2, -2, -2, 1, 1, -1, -1 };
   static int col[] = { -8, 8, 8, -8, 16, -16, 16, -16 };
 static int N = 64;
   static boolean valid(int x)
    {
        if (x < 0 || x >= N )
            return false;

        return true;
    }
    static class Node {
        int x, dist;
        Node(int a,int d){
             x=a;
            dist=d;
        }
    }

    static int bfs(Node src, Node dest)
    {
        Map<Node, Boolean> visited = new HashMap<>();

        Queue<Node> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty())
        {
            Node node = q.peek();
            q.remove();

            int x = node.x;
            int dist = node.dist;
            if (x == dest.x)
                return dist;

            if (!visited.containsKey(node))
            {
                visited.put(node,true);

                for (int i = 0; i < 8; ++i)
                {
                    int x1 = x + row[i]+col[i];
                    if (valid(x1))
                        q.add(new Node(x1, dist + 1));
                }
            } else {
                for (int i = 0; i < 8; ++i)
                {
                    int x1 = x + row[i]+col[i];
                    if (valid(x1))
                    {
                       // if(node.dist)
                        q.add(new Node(x1, dist + 1));
                    }
                }
            }
        }
        return -1;
    }

}
