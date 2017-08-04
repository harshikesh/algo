package Strings;

/**
 * Created by harshikesh.kumar on 02/06/16.
 */
public class RemoveSpaces {

    static void removeSpace(String str){
        String temp =new String();
        int len = str.length();
        int flag =0;
        for(int i =0 ;i<len;i++){

            if(str.charAt(i) == ' ' ){
                if(flag ==0){
                    temp = temp +str.charAt(i);
                }
                flag=1;
                continue;
            }else{
                flag = 0;
                temp = temp +str.charAt(i);
            }
        }
        System.out.println(temp.trim());
    }

//    static char removeSpaceWithRecursion(String str,int val,char c){
//        String temp =new String();
//        int len = str.length();
//        int flag =0;
//
//        if(c == ' '){
//            return;
//        }
//        for(int i =0 ;i<len;i++){
//
//           temp = removeSpaceWithRecursion(str,i,str.charAt(i));
//        }
//        System.out.println(temp.trim());
//    }

    public static void main(String[] args) {
        String str = "Hi  I am   a B  oy  ";
        removeSpace(str);
    }
}
