package com.dipendit.codeinterview;

import com.dipendit.Node;
import com.dipendit.NthElementLinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = NthElementLinkedList.generateLinkedList(5);
        NthElementLinkedList.printLinkedList(head);
        NthElementLinkedList.printLinkedList(reverseList(head));
    }

    // 1 -> 2 -> 3 -> 4 -> 5
    public static Node reverseList(Node head) {
        Node prvNode = null;
        Node t=null;
        while (head != null) {
            t = head.getNode();
            head.setNode(prvNode);
            prvNode = head;
            head = t;
        }
        return prvNode;
    }
}
