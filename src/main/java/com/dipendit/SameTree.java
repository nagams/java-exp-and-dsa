package com.dipendit;

import java.util.LinkedHashMap;
import java.util.Map;

public class SameTree {
    public static void main(String[] args) {
        Map<Integer, BinarySearchTree.TNode> mappings1 = new LinkedHashMap<>();
        mappings1.put(3, new BinarySearchTree.TNode(1,5));
        mappings1.put(1, new BinarySearchTree.TNode(0,2));
        mappings1.put(5, new BinarySearchTree.TNode(4,6));
        TreeNode root1 = BinarySearchTree.createTrees(mappings1, 3);
        Map<Integer, BinarySearchTree.TNode> mappings2 = new LinkedHashMap<>();
        mappings2.put(3, new BinarySearchTree.TNode(1,5));
        mappings2.put(1, new BinarySearchTree.TNode(0,2));
        mappings2.put(5, new BinarySearchTree.TNode(4,6));
        TreeNode root2 = BinarySearchTree.createTrees(mappings2, 3);
        System.out.println("Same Tree: " + isSameTree(root1, root2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if ((p == null || q == null) || (p.val != q.val))
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
