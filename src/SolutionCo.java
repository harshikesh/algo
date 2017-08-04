import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by harshikesh.kumar on 06/04/17.
 */
public class SolutionCo {

    static final String anstoken= "Case #";
    static final String anstoken2= ": ";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        for (int i = 1; i <= test; i++) {
            int n = scanner.nextInt();

            int[] numberOfPeople = new int[n+1];
            String num =scanner.next();
            String str[] = String.valueOf(num).split("");
            for (int j = 0; j <= n ; j++) {
                numberOfPeople[j] = Integer.parseInt(str[j]);
            }

            int totalShyness = numberOfPeople[0];
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (j > totalShyness){
                    if((j - totalShyness)/(j*1.0) == 0){
                        sum =+ (j - totalShyness)/j;
                        totalShyness += ((j - totalShyness)/j)*j;
                    } else {
                        sum =+ ((j - totalShyness)/j)+1;
                        totalShyness += (((j - totalShyness)/j)+1)*j-1;
                    }
                } else {
                    totalShyness += numberOfPeople[j];
                }
            }
            System.out.print(anstoken+i+anstoken2 + sum);
            System.out.println();
        }
    }
}
