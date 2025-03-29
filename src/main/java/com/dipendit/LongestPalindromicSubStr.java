package com.dipendit;

public class LongestPalindromicSubStr {
    public static void main(String[] args) {
        System.out.println("babad: " + longestPalindrome("babad"));
        System.out.println("cbbd: " + longestPalindrome("cbbd"));

    }
    public static String longestPalindrome(String s) {
        String res = "";
        int resLen = 0;

        for (int i = 0; i < s.length(); i++) {
            var str = findPaliFromi(s, i, resLen, true);
            if ( str.length() > resLen) {
                res = str;
                resLen = str.length();
            }

            str = findPaliFromi(s, i, resLen, false);
            if ( str.length() > resLen) {
                res = str;
                resLen = str.length();
            }
        }
        return res;
    }

    public static String findPaliFromi(String s, int i, int resLen, boolean isOdd) {
        String res = "";
        int l = i, r;
        if (isOdd)
            r = i;
        else
            r = i+1;

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if ((r - l + 1) > resLen) {
                res = s.substring(l, r + 1);
                resLen = r - l + 1;
            }
            l--;
            r++;
        }
        return res;
    }

}
