package com.dipendit;

import java.util.LinkedHashMap;
import java.util.Map;

public class InvertTree {
    public static void main(String[] args) {
        Map<Integer, BinarySearchTree.TNode> mappings1 = new LinkedHashMap<>();
        mappings1.put(3, new BinarySearchTree.TNode(1,5));
        mappings1.put(1, new BinarySearchTree.TNode(0,2));
        mappings1.put(5, new BinarySearchTree.TNode(4,6));
        TreeNode root = BinarySearchTree.createTrees(mappings1, 3);
        System.out.println("bfsItMaxDepth: " + invertTree(root));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
