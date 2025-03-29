package com.dipendit;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingChar {
    public static void main(String[] args) {
        System.out.println("Result: " + characterReplacement("ABAB", 2));
        System.out.println("Result: " + characterReplacement("AABABBA", 1));
    }

    public static int characterReplacement(String s, int k) {
        int res = 0;

        Map<Character, Integer> charCounts = new HashMap<>();
        char[] chars = s.toCharArray();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            var ch = chars[r];
            charCounts.merge(ch, 1, Integer::sum);

            int numDiffChars = (r - l + 1) - maxChar(charCounts);
            if (numDiffChars > k) {
                charCounts.merge(chars[l], -1, Integer::sum);
                l++;
            }
            res = Math.max(res, r-l+1);
        }

        return res;
    }

    public static int maxChar(Map<Character, Integer> charCounts) {
        return charCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .orElse(0);
    }
/*
        charCounts.values()
                .stream()
                .max(Integer::compare)
                .orElseThrow();
*/
}
