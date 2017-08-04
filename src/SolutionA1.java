import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by harshikesh.kumar on 06/04/17.
 */
public class SolutionA1 {

    static final String anstoken= "Case #";
    static final String anstoken2= ": ";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        for (int i = 1; i <= test; i++) {

            TreeMap<Integer,Integer> tre = new TreeMap<>();
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            int n = scanner.nextInt();
            for (int j = 1; j < n * 2; j++) {
                for (int k = 0; k < n; k++) {
                    int g = scanner.nextInt();
                    if(hashMap.containsKey(g)) {
                        hashMap.put(g,hashMap.get(g)+1);
                    } else {
                        hashMap.put(g,1);
                    }
                }
            }

            for (Map.Entry entry:hashMap.entrySet()) {
                if((Integer)entry.getValue() % 2 != 0 ){
                    tre.put((Integer) entry.getKey(),1);
                }
            }
            System.out.print(anstoken+i+anstoken2);
            for (Map.Entry entry:tre.entrySet()) {
                System.out.print(entry.getKey()+" ");
            }

            System.out.println();
        }
    }
}
