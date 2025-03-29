package com.dipendit;

import java.util.*;

public class BinarySearchTree {
    public static void main(String[] args) {
        /*
                 3
               /   \
              1     5
             / \   / \
            0  2  4   6
         */
        Map<Integer, TNode> mappings1 = new LinkedHashMap<>();
        mappings1.put(3, new TNode(1,5));
        mappings1.put(1, new TNode(0,2));
        mappings1.put(5, new TNode(4,6));
        TreeNode root4 = createTrees(mappings1, 3);
        System.out.println("isBst: " + isBst(root4));

    }

    public static boolean isBst(TreeNode treeNode) {
        List<Integer> valList = new ArrayList<>();
        inOrderTraversal(treeNode, valList);
        //valList.forEach(System.out::print);
/*
        valList.forEach(v -> {
            System.out.print(v + " ");
        });
*/
        //Collections.sort(valList);
        valList.toString();
        List<Integer> sortedList = valList.stream()
                                          .sorted()
                                          .toList();
        System.out.println("Original List: " + valList);
        System.out.println("Sorted List: " + sortedList);
        return valList.equals(sortedList);
    }

    //left -> root -> right
    public static void inOrderTraversal(TreeNode tnode, List<Integer> valList) {
        if (tnode.left != null)
            inOrderTraversal(tnode.left, valList);
        valList.add(tnode.val);
        if (tnode.right != null)
            inOrderTraversal(tnode.right, valList);
    }

    public static TreeNode createTrees(Map<Integer, TNode> mappings, int rootV) {
        TreeNode root = new TreeNode(rootV);

        Iterator<Map.Entry<Integer, TNode>> iterator = mappings.entrySet().iterator();

        TNode nodes = null;
        Map.Entry<Integer, TNode> mapEntry = null;
        //Root Node
        TreeNode fLeftNode = null;
        TreeNode fRightNode = null;
        if (iterator.hasNext()) {
            mapEntry = iterator.next();
            nodes = mapEntry.getValue();
            fLeftNode = new TreeNode(nodes.lv());
            fRightNode = new TreeNode(nodes.rv());
            root.left = fLeftNode;
            root.right = fRightNode;
        }

        // Level 2 node
        if (iterator.hasNext()) {
            mapEntry = iterator.next();
            nodes = mapEntry.getValue();
            TreeNode ltn = new TreeNode(nodes.lv());
            TreeNode rtn = new TreeNode(nodes.rv());
            fLeftNode.left = ltn;
            fLeftNode.right = rtn;
        }
        if (iterator.hasNext()) {
            mapEntry = iterator.next();
            nodes = mapEntry.getValue();
            TreeNode ltn = new TreeNode(nodes.lv());
            TreeNode rtn = new TreeNode(nodes.rv());
            fRightNode.left = ltn;
            fRightNode.right = rtn;
        }
        return root;

    }

    public record TNode(int lv, int rv) {}
}
