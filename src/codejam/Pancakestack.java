package codejam;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by harshikesh.kumar on 30/04/17.
 */
public class Pancakestack {

    static final String anstoken = "Case #";
    static final String anstoken2 = ": ";

    static class Pan {
        Pan(int i,int r,int h,BigDecimal a){
            in = i;
           rad = r;
            he = h;
            area =a;
        }
        int rad;
        int he;
        int in;
        BigDecimal area;

        @Override
        public int hashCode() {
            return in;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {

            int N = sc.nextInt();
            int K = sc.nextInt();

            Map<Pan,BigDecimal> hash = new HashMap<>();

            for (int j = 0; j < N; j++) {
                int radius = sc.nextInt();
                int height = sc.nextInt();
               BigDecimal area =  getArea(radius,height);
                Pan pan = new Pan(j,radius,height,area);
                hash.put(pan,area);
            }

            List<Pan> panArrayList = new ArrayList<Pan>(hash.keySet());

            Collections.sort(panArrayList, new Comparator<Pan>() {
                @Override
                public int compare(Pan o1, Pan o2) {
                    if(o2.rad-o1.rad != 0){
                        return o2.rad-o1.rad ;
                    } else {
                        return o2.he-o1.he ;
                    }
                }
            });

            ArrayList<Integer> ni = new ArrayList<>();
            int l =0;
            for (int j = K; j>0; j--) {
                BigDecimal max = BigDecimal.ZERO;
                for (int k = l; k <panArrayList.size()-j+1; k++) {
                    if(panArrayList.get(k).area.compareTo(max) > 0){
                        max = panArrayList.get(k).area;
                        l = k;
                    }
                }
                ni.add(l);
                l++;
            }

            BigDecimal ans = BigDecimal.ZERO;
            BigDecimal save =BigDecimal.ZERO;
            Collections.reverse(ni);
            for (Integer j : ni) {

              ans =  ans.add(getArea(panArrayList.get(j).rad,panArrayList.get(j).he).subtract(save));
                save = getRadiarea(panArrayList.get(j).rad);
            }
            System.out.println(anstoken+(i+1)+anstoken2+String.format("%.9f", ans));
        }

    }
    public static BigDecimal getRadiarea(int radius){
        BigDecimal ans;
        ans = BigDecimal.valueOf(radius).multiply(BigDecimal.valueOf(radius));
        return ans.multiply(BigDecimal.valueOf(Math.PI));
    }

    public static BigDecimal getArea(int radius, int height){
        BigDecimal ans;
        ans = (BigDecimal.valueOf(radius).multiply(BigDecimal.valueOf(radius))).add((BigDecimal.valueOf(radius).multiply(BigDecimal.valueOf(height).multiply(BigDecimal.valueOf(2)))));
       return ans.multiply(BigDecimal.valueOf(Math.PI));
    }
}

