package com.dipendit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
  Given an array of strings strs, group the anagrams together. You can return the answer in any order.

  Input: strs = ["eat","tea","tan","ate","nat","bat"]
  Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

  # WORKS for all good cases,
    didn't work for {"", "", ""}
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = { "eat","tea","tan","ate","nat","bat" };
        List<List<String>> anagrams = groupAnagrams(strs);
        for (List<String> anagram : anagrams) {
            System.out.print("[");
            for (String s : anagram) {
                System.out.print(" " + s);
            }
            System.out.println("]");
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> as = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];

            if (!as.contains(s)) {
                List<String> anagramList = new ArrayList<>();
                anagramList.add(s);
                //as.add(s);
                for (int j = i + 1; j < strs.length; j++) {
                    String t = strs[j]; //is t anagram of s?
                    if (!as.contains(t)) {
                        if (t.length() == s.length()) {
                            boolean isAnagram = true;
                            char[] chars = t.toCharArray();
                            int k = 0;
                            while (k < chars.length && isAnagram) {
                                if (s.indexOf(chars[k++]) == -1)
                                    isAnagram = false;
                            }
                            if (isAnagram) {
                                anagramList.add(t);
                                as.add(t);
                            }
                        }
                    }
                }
                result.add(anagramList);
            }
        }

        return result;
    }
}
