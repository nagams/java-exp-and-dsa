package com.dipendit;

import java.util.OptionalInt;

public class PalindromeRecursive {
    public static void main(String[] args) {
        System.out.println("Palindrome String: " + palindrome("malayalam"));

        OptionalInt opt1 = OptionalInt.empty();
        opt1 = OptionalInt.of(2);
        System.out.println("Has Value: " + opt1.isPresent());

        System.out.println("Palindrome String-2: " + palindrome2("abcd"));
        System.out.println("isPalindrome: " + isPalindrome("abbbba"));
        System.out.println("isPalindrome: " + isPalindrome("axbbba"));
    }

    //aba  ab
    public static String palindrome(String str) {

        if (str == null || str.isEmpty())
            return "";
        if (str.length() == 1)
            return str;
        return str.substring(str.length()-1).concat(palindrome(str.substring(0, str.length()-1)));
    }

    public static String palindrome2(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = str.length()-1; i>=0; i--) {
            res.append(str.charAt(i));
        }
        System.out.println("palindrome2: " + res);
        return res.toString();
    }

    public static boolean isPalindrome(String str) {
        int sl = str.length();
        int l, r = 0;
        if (sl % 2 == 0)
            l = sl / 2 - 1;
        else
            l = sl / 2;
        r = sl / 2;

        while ( l >= 0 && r < sl && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }
        if (l > 0 || r < sl)
            return false;
        return true;
    }
}
