package com.dipendit;

import java.util.HashMap;
import java.util.Map;

/*
    Have the function MinWindowSubstring(strArr) take the array of strings stored in strArr, which will contain only two strings,
    the first parameter being the string N and the second parameter being a string K of some characters, and your goal is to determine
    the smallest substring of N that contains all the characters in K. For example: if strArr is ["aaabaaddae", "aed"] then the smallest
    substring of N that contains the characters a, e, and d is "dae" located at the end of the string. So for this example your program
    should return the string dae.

    #WORKS
 */
public class MinWindowSubstring {

    public static void main(String[] args) {
//        System.out.println("MinWindowSubstring: " + minWindowSubstring("aaabaaddae", "dae"));
        System.out.println("MinWindowSubstring: " + minWindowSubstring("a", "aa"));
    }

    // #WORKS
    public static String minWindowSubstring(String s, String t) {
        if (s == null) return null;

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = countT.size();
        int[] res = new int[2];
        int resLen = Integer.MAX_VALUE;
        int L = 0;
        char c;
        for (int r = 0; r < s.length(); r++) {
            c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && window.get(c) == countT.get(c))
                have++;

            while (have == need) {
                //Update result
                if (r - L + 1 < resLen) {
                    res[0] = L;
                    res[1] = r;
                    resLen = Math.min(resLen, r - L + 1);
                }
                //Pop characters from the left of our window
                Character lChar = s.charAt(L++);
                window.put(lChar, window.get(lChar) - 1);
                if (countT.containsKey(lChar) && window.get(lChar) < countT.get(lChar))
                    have--;
            }
        }

        if (resLen != Integer.MAX_VALUE)
            return s.substring(res[0], res[1]+1);
        else return "";
    }
}
