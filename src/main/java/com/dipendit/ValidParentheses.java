package com.dipendit;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println("Valid: " + isValid("()[]{}"));
        System.out.println("Valid: " + isValid("()]]{}"));
        System.out.println("Valid: " + isValid(""));
        System.out.println("Valid: " + isValid("([{("));
    }

    // ()[]{}  true
    // (]  false
    // ([]) true
    public static boolean isValid(String s) {
        if (s.length() % 2 > 0)
            return false;

        Deque<Character> pStack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                pStack.addFirst(ch);
            } else {
                if (pStack.isEmpty())
                    return false;

                char popCh = pStack.removeFirst();
                if ((ch == ')' && popCh != '(') ||
                        (ch == '}' && popCh != '{') ||
                        (ch == ']' && popCh != '['))
                    return false;
            }
        }
        return pStack.isEmpty();
    }
}
