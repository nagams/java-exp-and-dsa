package com.dipendit;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        System.out.println("abc: " + countSubstrings("abc"));
        System.out.println("aaa: " + countSubstrings("aaa"));
        System.out.println("aaaa: " + countSubstrings("aaaa"));

        //a,a,a,a,a,aa,aa,aa,aa,aaa,aaa,aaa,aaaa,aaaa,aaaaa
        System.out.println("aaaaa: " + countSubstrings("aaaaa"));

    }

    //WORKS
    public static int countSubstrings(String s) {
        int sLength = s.length();
        int count = 0;

        for (int i = 0; i < sLength; i++) {
            int l = i, r = i;
            while (l >= 0 && r < sLength && s.charAt(l) == s.charAt(r)) {
                count++;
                l--; r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < sLength && s.charAt(l) == s.charAt(r)) {
                count++;
                l--; r++;
            }
        }
        return count;
    }

    //First attempt, DOES NOT WORK
    public static int countSubstrings2(String s) {
        int sLength = s.length();
        int count = sLength;
        List<String> takenList = new ArrayList<>();

        System.out.println(s);
        for (int i = 0; i < sLength; i++) {
            System.out.println(i);
            int l = i, r = i;
            while (l >= 0 && r < sLength && s.charAt(l) == s.charAt(r)) {
                l--; r++;
            }
            if (s.substring(l+1, r).length() > 1) {
                takenList.add(""+(l+1)+(r-1));
                count++;
            }
            System.out.println(s.substring(l+1, r) + ": " + count);

            l = i;
            r = i + 1;
            while (l >= 0 && r < sLength && s.charAt(l) == s.charAt(r)) {
                l--; r++;
            }
            if (s.substring(l+1, r).length() > 1) {
                takenList.add(""+(l+1)+(r-1));
                count++;
            }
            System.out.println(s.substring(l+1, r) + ": " + count);

            l = i - 1;
            r = i;
            while (l >= 0 && r < sLength && s.charAt(l) == s.charAt(r)) {
                l--; r++;
            }
            if (s.substring(l+1, r).length() > 1) {
                if (!takenList.contains(""+(l+1)+(r-1)))
                    count++;
            }
            System.out.println(takenList);
            System.out.println(s.substring(l+1, r) + ": " + count);
        }
        return count;
    }
}
