package com.dipendit;

import java.util.PriorityQueue;

public class MinHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add elements
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(20);
        minHeap.add(1);

        // Remove and print elements in priority order
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()); // Output: 1, 5, 10, 20
        }
    }}
