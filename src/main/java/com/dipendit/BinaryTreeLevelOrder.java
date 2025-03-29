package com.dipendit;

import java.util.*;

public class BinaryTreeLevelOrder {
    public static void main(String[] args) {
        Map<Integer, BinarySearchTree.TNode> mappings1 = new LinkedHashMap<>();
        mappings1.put(3, new BinarySearchTree.TNode(1,5));
        mappings1.put(1, new BinarySearchTree.TNode(0,2));
        mappings1.put(5, new BinarySearchTree.TNode(4,6));
        TreeNode root = BinarySearchTree.createTrees(mappings1, 3);

        System.out.println(levelOrder(root));

    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodeList = new ArrayList<>();

        if (root == null)
            return nodeList;
        Deque<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.addFirst(root);

        while (!nodeQueue.isEmpty()) {
            var size = nodeQueue.size();
            List<Integer> tl = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                var node = nodeQueue.removeFirst();
                tl.add(node.val);
                if (node.left != null)
                    nodeQueue.addLast(node.left);
                if (node.right != null)
                    nodeQueue.addLast(node.right);
            }
            if (!tl.isEmpty())
                nodeList.add(tl);
        }
        return nodeList;
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> nodeList = new ArrayList<>();

        if (root == null)
            return nodeList;
        Deque<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.addFirst(root);

        nodeList.add(List.of(root.val));

        while (!nodeQueue.isEmpty()) {
            var size = nodeQueue.size();
            List<Integer> tl = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                var node = nodeQueue.removeFirst();
                if ((node.left != null) && (node.right != null)) {
                    tl.add(node.left.val);
                    tl.add(node.right.val);
                } else if (node.left != null)
                    tl.add(node.left.val);
                else if (node.right != null)
                    tl.add(node.right.val);

                if (node.left != null)
                    nodeQueue.addLast(node.left);
                if (node.right != null)
                    nodeQueue.addLast(node.right);
            }
            if (!tl.isEmpty())
                nodeList.add(tl);
        }
        return nodeList;
    }

}
