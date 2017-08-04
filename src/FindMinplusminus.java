/**
 * Created by harshikesh.kumar on 20/02/17.
 */
public class FindMinplusminus {

    public static void main(String[] args) {
        int a = 4;
        getMinimum(a);
    }

    private static void getMinimum(int a) {
        System.out.println(getMinimumUtil(1,a,0,0));
    }

    private static int getMinimumUtil(int i, int a, int count,int sum) {

        if (sum > a || sum < -a) {
            return Integer.MAX_VALUE;
        }

        if (sum - i == a || sum + i == a) {
            return count + 1;
        }

        int k = Math.min(getMinimumUtil(i + 1, a, count + 1, sum - i), getMinimumUtil(i + 1, a, count + 1, sum + i));
        return k;
    }
}
