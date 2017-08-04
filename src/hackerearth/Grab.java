package hackerearth;

/**
 * Created by harshikesh.kumar on 20/05/17.
 */
public class Grab {

    public static void main(String[] args) {
        int A[]={1,8,9,10,15,16,17,18,19,20,21};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        final int MONTHLY =25;
        final int WEEKLY =7;
        final int DAILY =2;
        // write your code in Java SE 8
        if(A.length > 23){
            return MONTHLY;
        }
        int amount = 0;
        for(int i=0 ; i<A.length;){
            int count =1;
            int j =i+1;
            for(;j<A.length;j++){
                if(A[j] -A[i] <= 6){
                    count++;
                } else{
                    if(count > 3){
                        amount += WEEKLY;
                    } else{
                        amount += DAILY*count;
                    }
                    count = 0;
                    break;
                }

            }
            i=j;
            if(count > 0 && count < 4){
                amount += DAILY*count;
            } else if(count >= 4){
                amount += WEEKLY;
            }
        }
        return amount;
    }
}
