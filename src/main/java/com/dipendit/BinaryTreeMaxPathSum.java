package com.dipendit;

import java.util.*;

public class BinaryTreeMaxPathSum {
    public static void main(String[] args) {
        Map<Integer, BinarySearchTree.TNode> mappings1 = new LinkedHashMap<>();
        mappings1.put(3, new BinarySearchTree.TNode(1,5));
        mappings1.put(1, new BinarySearchTree.TNode(0,2));
        mappings1.put(5, new BinarySearchTree.TNode(4,6));
        TreeNode root = BinarySearchTree.createTrees(mappings1, 3);

        Stack<Integer> maxSum = new Stack<>();
        maxSum.push(root.val);
        dfs(root, maxSum);
        System.out.println("MaxPathSum: " + maxSum.pop());
    }

    public static int dfs(TreeNode root, Stack<Integer> maxSum) {
        if (root == null)
            return 0;

        int leftMax = dfs(root.left, maxSum);
        int rightMax = dfs(root.right, maxSum);
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);

        // sum with split
        maxSum.push(Math.max(maxSum.pop(), root.val + leftMax + rightMax));

        return root.val + Math.max(leftMax, rightMax);
    }

}
