package codejam;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by harshikesh.kumar on 22/04/17.
 */
public class Horse {

    static final String anstoken = "Case #";
    static final String anstoken2 = ": ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int i = 1; i <= test; i++) {

            long D = sc.nextLong();
            long N = sc.nextInt();
            double distance = Long.MAX_VALUE;
            double currentSpeed = Long.MAX_VALUE;
            Map<Long,Long> hash = new TreeMap<>(Collections.reverseOrder());
            for (int j = 0; j < N; j++) {

                long d = sc.nextInt();
                long s = sc.nextInt();
                hash.put(d,s);
            }
            Set set = hash.entrySet();
            Iterator iterator = set.iterator();
            double speed =0.0;
            double tot=0.0;
            while(iterator.hasNext()) {
                Map.Entry me = (Map.Entry)iterator.next();
                if((Long)me.getValue() < currentSpeed){
                    distance = (Long)me.getKey();
                    currentSpeed = (Long)me.getValue();
                } else {
                    double time = (distance - (Long)me.getKey())/((Long)me.getValue()-currentSpeed);
                    tot += time;
                    distance = distance + (currentSpeed * time);
                    if(distance >= D){
                        distance = (Long)me.getKey();
                        currentSpeed = (Long)me.getValue();
                        tot = 0;
                    }
                }
            }
            tot += ((D-distance)*1.0)/(currentSpeed*1.0);
            currentSpeed = (D/(tot));

            System.out.println(anstoken+(i)+anstoken2+String.format("%.6f", currentSpeed));
        }
    }

}
