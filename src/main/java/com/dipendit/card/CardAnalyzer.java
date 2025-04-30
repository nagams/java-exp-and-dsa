package com.dipendit.card;

public class CardAnalyzer {

    public static String analyzeCard(String cardNumber) {
        if (cardNumber == null || cardNumber.length() != 16)
            throw new IllegalArgumentException("Card number must be 16 digits long");

        StringBuilder report = new StringBuilder();

        switch (cardNumber.charAt(0)) {
            case '1' -> report.append("User Type: New User\n");
            case '2' -> report.append("User Type: Returning\n");
            case '3' -> report.append("User Type: VIP\n");
        }

        switch (cardNumber.charAt(1)) {
            case '1' -> report.append("Region: US\n");
            case '2' -> report.append("Region: EU\n");
            case '3' -> report.append("Region: Asia\n");
        }

        switch (cardNumber.charAt(2)) {
            case '0' -> report.append("Fraud Risk: Low\n");
            case '1' -> report.append("Fraud Risk: Medium\n");
            case '2' -> report.append("Fraud Risk: High\n");
        }

        var transactionCount = Integer.parseInt(cardNumber.substring(3, 6));
        report.append("Transaction Count Today: ").append(transactionCount).append("\n");

        var transactionHour = Integer.parseInt(cardNumber.substring(10, 12));
        report.append("Transaction Hour: ").append(transactionHour).append("\n");

        report.append("Contactless: ").append(cardNumber.charAt(12) == 1 ? "Yes" : "No").append("\n");
        report.append("NFC: ").append(cardNumber.charAt(13) == 1 ? "Yes" : "No").append("\n");
        report.append("PIN Required: ").append(cardNumber.charAt(14) == 1 ? "Yes" : "No").append("\n");

        switch (cardNumber.charAt(15)) {
            case '0' -> report.append("Account Status: Blocked");
            case '1' -> report.append("Account Status: Active");
            case '2' -> report.append("Account Status: Suspended");
        }

        return report.toString();
    }

    public static void main(String[] args) {
        String cardNumber = "2311234567891012";
        System.out.println(analyzeCard(cardNumber));

        System.out.println(cardNumber.chars().map(c -> c - '0').sum());
    }
}
