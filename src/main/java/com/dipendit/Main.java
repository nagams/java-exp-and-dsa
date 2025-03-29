package com.dipendit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println( "Max: " +
                Arrays.stream(new int[] {1,2,3,4,5})
                        .max()
                        .orElseThrow()
        );

        int[] sortDsc =
                Arrays.stream(new int[] {5, 2, 8, 1})
                        .boxed()
                        .sorted(Comparator.reverseOrder())
                        .mapToInt(Integer::intValue)
                        .toArray();
        System.out.println("Reverse sort: " + Arrays.toString(sortDsc));

        int[] sortAsc = Arrays.stream(new int[] {5, 2, 8, 1})
                              .sorted()
                              .toArray();
        System.out.println("Sorted: " + Arrays.toString(sortAsc));

        List<Integer> evens = Arrays.stream(new int[] {5, 2, 8, 1})
                .filter(e -> e % 2 == 0)
                .boxed()
                .toList();
        System.out.println("Evens: " + evens);

        List<Integer> nums = List.of(1, 2, 2, 3, 3, 3, 4);
        Map<Integer, Long> freqMap =
                nums.stream()
                    .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        System.out.println("Grouping: " + freqMap);

        String joined = Arrays.stream(new int[] {3, 4, 2, 7})
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Joined: " + joined);

        boolean hasEven = Arrays.stream(new int[] {3, 4, 2, 1})
                                .anyMatch(e -> e % 2 == 0);
        System.out.println("hasEven: " + hasEven);
        boolean allEven = Arrays.stream(new int[] {3, 4, 2, 1})
                                .allMatch(e -> e % 2 == 0);
        System.out.println("allEven: " + allEven);
        boolean noneEven = Arrays.stream(new int[] {3, 4, 2, 1})
                                 .noneMatch(e -> e % 2 == 0);
        System.out.println("noneEven: " + noneEven);
    }
}