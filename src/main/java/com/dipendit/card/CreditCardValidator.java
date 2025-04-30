package com.dipendit.card;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreditCardValidator {
    private static final Map<Integer, CardValidationStrategy> strategies = Map.of(
            0, new LengthValidation(),
            1, new NoLeadingZeroValidation(),
            2, new SumDivisibleByTenValidation(),
            3, new NoRepeatsValidation(),
            4, new EndsInEvenDigitValidation(),
            5, new SameMiddleDigitsValidation(),
            6, new NoAdjacentSameDigitsValidation(),
            7, new EqualHalfSumValidation()
    );

    public static boolean validate(String cardNumber) {
        for (char c : cardNumber.toCharArray()) {
            int digit = c - '0';
            CardValidationStrategy strategy = strategies.get(digit);
            if (strategy != null && !strategy.validate(cardNumber)) {
                System.out.println("Validation failed for rule: " + digit);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String cardNumber = "12453678";
        System.out.println("Card is valid: " + validate(cardNumber));
    }
}

interface CardValidationStrategy {
    boolean validate(String cardNumber);
}

class LengthValidation implements CardValidationStrategy {

    @Override
    public boolean validate(String cardNumber) {
        return cardNumber.length() == 8;
    }
}

class NoLeadingZeroValidation implements CardValidationStrategy {

    @Override
    public boolean validate(String cardNumber) {
        return !cardNumber.startsWith("0");
    }
}

class SumDivisibleByTenValidation implements CardValidationStrategy {

    @Override
    public boolean validate(String cardNumber) {
        return cardNumber.chars().map(c -> c - '0').sum() % 10 == 0;
    }
}

class NoRepeatsValidation implements CardValidationStrategy {

    @Override
    public boolean validate(String cardNumber) {
        Set<Character> seen = new HashSet<>();
        for (char c : cardNumber.toCharArray()) {
            if (!seen.add(c)) return false;
        }
        return true;
    }
}

class EndsInEvenDigitValidation implements CardValidationStrategy {

    @Override
    public boolean validate(String cardNumber) {
        char last = cardNumber.charAt(cardNumber.length() - 1);
        return (last - '0') % 2 == 0;
    }
}

class SameMiddleDigitsValidation implements CardValidationStrategy {
    @Override
    public boolean validate(String cardNumber) {
        return cardNumber.charAt(3) == cardNumber.charAt(4);
    }
}

class NoAdjacentSameDigitsValidation implements CardValidationStrategy {
    @Override
    public boolean validate(String cardNumber) {
        for (int i = 1; i < cardNumber.length(); i++) {
            if (cardNumber.charAt(i-1) == cardNumber.charAt(i))
                return false;
        }
        return true;
    }
}

class EqualHalfSumValidation implements CardValidationStrategy {
    @Override
    public boolean validate(String cardNumber) {
        int half = cardNumber.length() / 2;
        int firstHalf = 0, secondHalf = 0;
        for (int i = 0; i < half; i++) {
            firstHalf += cardNumber.charAt(i) - '0';
            secondHalf += cardNumber.charAt(i + half) - '0';
        }
        return firstHalf == secondHalf;
    }
}
