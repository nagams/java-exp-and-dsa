package com.dipendit.codeinterview;

import java.util.PriorityQueue;

public class MinHeapExample {
    public static void main(String[] args) {
        // Create a Min-Heap using PriorityQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add elements
        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(10);
        minHeap.add(1);

        // Print elements in sorted (heap order) fashion
        System.out.println("Heap Elements: " + minHeap);

        // Retrieve and remove elements (sorted order)
        while (!minHeap.isEmpty()) {
            System.out.println("Removed: " + minHeap.poll());
        }

        System.out.println(findKthLargest(new int[] {5, 2, 10, 1}, 3));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
