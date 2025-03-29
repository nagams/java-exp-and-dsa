package com.dipendit;

import java.util.Optional;

public class NthElementLinkedList {
    public static void main(String[] args) {
        Node ll = generateLinkedList(5);
        printLinkedList(ll);
        System.out.println("Nth: " + findNth(ll, 4));

        System.out.println("Nth from last: " + findNthFromTail(ll, 2));
        System.out.println("Nth from last-v2: " + findNthFromTail2(ll, 6).orElseGet(() -> null));
    }

    public static Optional<Node> findNthFromTail2(Node head, int n) {
        int size = 1;
        Node np = head;
        while (np.node != null) {
            size++;
            np = np.node;
        }

        if (n > size) return Optional.empty();
        else {
            int newN = size - n;
            np = head;
            for (int i = 0; i < newN; i++) {
                np = np.node;
            }
            return Optional.ofNullable(np);
        }
    }
    //nth from tail
    public static Node findNthFromTail(Node head, int n) {
        //1. find number of nodes in the list, k
        int k = 1;
        Node np = head;
        while (np.node != null) {
            k++;
            np = np.node;
        }
        System.out.println("Number of nodes: " + k);

        //2. Go to k-n+1 for nth from tail
        int i = 1;
        int newN = k - n + 1;
        np = head;
        while (np.node != null && i <= newN) {
            if (i == newN) {
                return np;
            } else {
                np = np.node;
                i++;
            }
        }
        if (i == newN) return np;
        else return null;
    }
    // O(n)  for nth from the head
    public static Node findNth(Node head, int n) {
        if (n <= 0) return null;
        if (head == null) return null;

        Node np = head;
        int i = 1;
        while (np.node != null && i <= n) {
            if (i == n) {
                return np;
            } else {
                np = np.node;
                i++;
            }
        }
        if (i == n) return np;
        else return null;
    }

    public static Node generateLinkedList(int numNodes) {
        if (numNodes == 0) return null;
        Node head = new Node();
        head.value = 1;
        head.node =  null;
        Node newNode = null;
        Node prevNode = head;
        for (int val = 2; val <= numNodes; val++) {
            newNode = new Node();
            newNode.value = val;
            newNode.node = null;

            prevNode.node = newNode;
            prevNode = newNode;
        }
        return head;
    }

    public static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("Empty linked list!");
        }
        Node nextNode = head;
        while (nextNode != null) {
            System.out.print(" -> " + nextNode.value);
            nextNode = nextNode.node;
        }
        System.out.println();
    }

}
