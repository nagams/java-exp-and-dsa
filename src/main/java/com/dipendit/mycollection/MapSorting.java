package com.dipendit.mycollection;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSorting {
    public static void main(String[] args) {
        Map<String, Integer> fruits = Map.of(
                "banana", 5,
                "Orange", 3,
                "Apple", 1
        );

        //Sort using old method
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(fruits.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        LinkedHashMap<String, Integer> vFruits = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> e : entryList) {
            vFruits.put(e.getKey(), e.getValue());
        }
        System.out.println("Sorted old way: " + vFruits);

        //Sort by values
        Map<String, Integer> vsFruits = fruits.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        System.out.println("Sorted with streams: " + vsFruits);
    }
}
