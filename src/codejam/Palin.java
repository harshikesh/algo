package codejam;

/**
 * Created by harshikesh.kumar on 06/06/17.
 */
public class Palin {

    public static void main(String[] args) {
      String str = "arddra";
        print(str);
    }

    static void print(String str){

        int i =0 ;
        int j = i+1;
        boolean flag = false;
        while (j<str.length()-1){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j++;
                flag =true;
            } else{
                if(flag)
                {i=0;
                    flag = false;
                } else {
                    j++;
                }
            }
        }
        System.out.println(str.length()/(j-i));
    }

}
