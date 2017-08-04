package hackerearth;/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader */
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;


class TestClass1 {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
*/
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

		for (int i = 0; i < N; i++) {
        	String str = br.readLine();
           	char arr[] = str.toCharArray();
           	int ans=0;

			boolean a =false;
			for (int j = 0; j < arr.length-1; j++) {
				if(arr[j] != arr[j+1]){
					a =true;
					break;
				}
			}

			if(!a){
				System.out.println(1);
				continue;
			}


           		boolean flag = true;
           		if(str.substring(0,arr.length/2).equals(str.substring(arr.length/2))){
           			for(int j=0 ;j<arr.length/2;j++){
           				if(arr[j] != arr[j]+1){
           					flag =false;
           					break;
           				}
           			}
           				if( !flag ){
           			ans = arr.length/2;
           		} else {
           			ans =1;
           		}
           		} else {
           			ans = arr.length;
           		}

           	

           	System.out.println(ans);
        }
        

        
    }
}
