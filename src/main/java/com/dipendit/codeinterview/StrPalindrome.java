package com.dipendit.codeinterview;

public class StrPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome2("malayalam"));
        System.out.println(isPalindrome2("malyalam"));
        System.out.println(isPalindrome2("abba"));
    }

    //malayalam
    //abba
    public static boolean isPalindrome(String str) {
        //find if length is odd or even
        //if odd, set l = m-1, r = m+1
        //if even, set l = m, r = m+1
        int length = str.length();
        int m = length / 2;
        int l = m - 1;
        int r;
        if (length % 2 == 0) {
            r = m;
        } else {
            r = m + 1;
        }

        while (l >= 0 && r < length && str.charAt(l) == str.charAt(r)) {
            l--; r++;
        }

        return l < 0 && r == length;
    }

    //abba
    public static boolean isPalindrome2(String str) {
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r))
                return false;
            l++; r--;
        }
        return true;
    }
}
