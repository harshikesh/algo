package Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by harshikesh.kumar on 25/07/17.
 */
public class FIndSubstr {

    public static void main(String[] args) {
       // findSubStr("asghkjacc");
        findSubstrings("aacaadaaaab");
    }


   static int[] createSuffix(String str) {
        class Trip implements Comparable<Trip> {
            int oriIn;
            int fHalf;
            int sHalf;
            @Override
            public int compareTo(Trip arg) {
                if (arg.fHalf != fHalf)
                    return fHalf - arg.fHalf;
                return sHalf - arg.sHalf;
            }
            Trip(int id, int fh, int sh) {
                oriIn = id;
                fHalf = fh;
                sHalf = sh;
            }
        };
        int n = str.length();
        int suffRa[] = new int[n];
       Trip sa[] = new Trip[n];
        for (int i = 0; i < n;i++) {
            suffRa[i] = str.charAt(i) -'a';
            sa[i] = new Trip(i,suffRa[i],0);
        }
        for (int cnt = 1 ; cnt < n; cnt *= 2) {

            for(int i = 0; i < n; i++) {
                sa[i].fHalf = suffRa[i];
                sa[i].sHalf = i + cnt < n ? suffRa[i + cnt] : -1;
                sa[i].oriIn = i;
            }

            Arrays.sort(sa);

            suffRa[sa[0].oriIn] = 0;
            for(int i = 1, currRank = 0; i < n; i++) {
                if(sa[i - 1].fHalf != sa[i].fHalf || sa[i - 1].sHalf != sa[i].sHalf)
                    ++currRank;
                suffRa[sa[i].oriIn] = currRank;
            }
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++)
            res[i] = sa[i].oriIn;

        return res;
    }

   static void findSubstrings(String s) {
        if (s.length() >= 2) {

            Set<Character> vowelSet = new HashSet<>((Arrays.asList(new Character[] {'a', 'e', 'u', 'o', 'i'})));
            int last = s.length();

            for (int i = s.length() - 1; i >= 0; i--) {
                if (vowelSet.contains(s.charAt(i))) {
                    last --;
                } else
                    break;
            }

            s = s.substring(0, last);
            int[] sa = createSuffix(s);

            int i = 0;
            while (i < sa.length) {
                if (vowelSet.contains(s.charAt(sa[i]))) {
                    break;
                }
                i++;
            }
            if (i < sa.length) {
                String first = s.substring(sa[i]);
                for (i = 0; i < first.length(); i++) {
                    if (!vowelSet.contains(first.charAt(i)))
                        break;
                }
                System.out.println(first.substring(0, i + 1));

                for (i = sa.length - 1; i >= 0; i--) {
                    if (vowelSet.contains(s.substring(sa[i]).charAt(0))) {
                        break;
                    }
                }
                System.out.println(s.substring(sa[i]));
            }
        }
    }
}
