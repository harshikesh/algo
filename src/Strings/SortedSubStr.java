package Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by harshikesh.kumar on 25/07/17.
 */


public class SortedSubStr {

    public static void main(String[] args) {
        findSubstrings("adbaac");
    }
    static int[] createSuffixArray(String str) {
        class SuffixTriplet implements Comparable<SuffixTriplet> {

            int rootIndex;
            int firstIndex;
            int length;

            @Override
            public int compareTo(SuffixTriplet arg) {
                if (arg.firstIndex != firstIndex)
                    return firstIndex - arg.firstIndex;
                return length - arg.length;
            }
            SuffixTriplet(int id, int fh, int sh) {
                rootIndex = id;
                firstIndex = fh;
                length = sh;
            }
        };


        int n = str.length();


        int rank[] = new int[n];


        SuffixTriplet suffixTriplets[] = new SuffixTriplet[n];
        for (int i = 0; i < n;i++) {
            rank[i] = str.charAt(i) -'a';
            suffixTriplets[i] = new SuffixTriplet(i,rank[i],0);
        }

        for (int count = 1 ; count < n; count *= 2) {

            for(int i = 0; i < n; i++) {
                suffixTriplets[i].firstIndex = rank[i];
                suffixTriplets[i].length = i + count < n ? rank[i + count] : -1;
                suffixTriplets[i].rootIndex = i;
            }


            Arrays.sort(suffixTriplets);


            rank[suffixTriplets[0].rootIndex] = 0;

            for(int i = 1, currRank = 0; i < n; i++) {
                if(suffixTriplets[i - 1].firstIndex != suffixTriplets[i].firstIndex || suffixTriplets[i - 1].length != suffixTriplets[i].length)
                    ++currRank;
                rank[suffixTriplets[i].rootIndex] = currRank;
            }
        }


        int[] res = new int[n];
        for(int i = 0; i < n; i++)
            res[i] = suffixTriplets[i].rootIndex;

        return res;
    }

   static void findSubstrings(String s) {

       List<Character> characterList = Arrays.asList(new Character[]{'a', 'e', 'u', 'o', 'i'});

       HashSet<Character> vowelSet = new HashSet<>(characterList);
       int last = s.length();
       for (int i = s.length() - 1; i >= 0; i--) {
           if (vowelSet.contains(s.charAt(i))) {
               last--;
           } else
               break;
       }
       s = s.substring(0, last);
       int[] resultArray = createSuffixArray(s);

       int i = 0;

       while (i < resultArray.length) {
           if (vowelSet.contains(s.charAt(resultArray[i]))) {
               break;
           }
           i++;
       }

       if (i < resultArray.length) {

           String firstSubString = s.substring(resultArray[i]);

           for (i = 0; i < firstSubString.length(); i++) {
               if (!vowelSet.contains(firstSubString.charAt(i)))
                   break;
           }

           System.out.println(firstSubString.substring(0, i + 1));

           for (i = resultArray.length - 1; i >= 0; i--) {
               if (vowelSet.contains(s.substring(resultArray[i]).charAt(0))) {
                   break;
               }
           }
           System.out.println(s.substring(resultArray[i]));
       }
   }

}
