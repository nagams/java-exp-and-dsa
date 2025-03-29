package com.dipendit;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println("valid: " + isAnagram("anagram", "nageram"));
    }

    public static boolean isAnagram(String s, String t) {
        //s - anagram t - nagaram
        /*
           a - 3
           n - 1
           g - 1
           r - 1
           m - 1
         */
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charCountMap.merge(ch, 1, Integer::sum);
        }
        for (char ch : t.toCharArray()) {
            if (!charCountMap.containsKey(ch)) {
                return false;
            } else {
                charCountMap.merge(ch, -1, Integer::sum);
            }
        }
        return
                charCountMap.entrySet()
                            .stream()
                            .filter(e -> e.getValue() != 0)
                            .findFirst()
                            .isEmpty();
    }

}
