package com.dipendit.codeinterview;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println("Longest substr: " + findLongestSubStr2("abcdaxj"));
        System.out.println("Longest substr: " + findLongestSubStr2("aaaa"));
    }

    public static int findLongestSubStr(String str) {
        //abcdaxj
        int longestStr = 1;
        int l = 0, r = 1;
        while (r < str.length()) {
            String subStr = str.substring(l, r);
            while ((subStr.indexOf(str.charAt(r)) != -1) && (l < r)) {
                l++;
            }
            if (subStr.length() > longestStr)
                longestStr = subStr.length();
            r++;
        }
        return longestStr;
    }

    public static int findLongestSubStr2(String str) {
        int maxLen = 1;
        Set<Character> chars = new HashSet<>();
        int l = 0;

        for (int r = 0; r < str.length(); r++) {
            while (chars.contains(str.charAt(r))) {
                chars.remove(str.charAt(r));
                l++;
            }

            chars.add(str.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
