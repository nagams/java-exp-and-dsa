package com.dipendit;

import java.util.*;

public class MaxDepthBinaryTree {
    public static void main(String[] args) {
        Map<Integer, BinarySearchTree.TNode> mappings1 = new LinkedHashMap<>();
        mappings1.put(3, new BinarySearchTree.TNode(1,5));
        mappings1.put(1, new BinarySearchTree.TNode(0,2));
        mappings1.put(5, new BinarySearchTree.TNode(4,6));
        TreeNode root = BinarySearchTree.createTrees(mappings1, 3);
        //System.out.println("maxDepth: " + maxDepth(root));
        //System.out.println("bfsMaxDepth: " + bfsDepth(root));
        System.out.println("bfsItMaxDepth: " + bfsItDepth(root));
    }

    public static int maxDepth(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    public static int bfsDepth(TreeNode root) {
        if (root == null)
            return 0;
        int level = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                var node = queue.removeFirst();
                if (node.left != null)
                    queue.addLast(node.left);
                if (node.right != null)
                    queue.addLast(node.right);
            }
            level++;
        }
        return level;
    }

    public static int bfsItDepth(TreeNode root) {
        int level = 0;
        Stack<DepthNode> nodeStack = new Stack<>();
        nodeStack.add(new DepthNode(root, 1));
        while (!nodeStack.isEmpty()) {
            DepthNode top = nodeStack.pop();
            if (top.node() != null) {
                level = Math.max(level, top.depth());
                nodeStack.add(new DepthNode(top.node().right, top.depth() + 1));
                nodeStack.add(new DepthNode(top.node().left, top.depth() + 1));
            }
            System.out.println(nodeStack);
        }

        return level;
    }
}

record DepthNode(TreeNode node, int depth) {}

