package com.dipendit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreeSerializeDeserialize {

    public static void main(String[] args) {
//        String tree = "1,2,3,null,null,4,5";
        String tree = "1,2,N,N,3,4,N,N,5,N,N";

        TreeNode root = deserialize(tree);
        System.out.println("serialized: " + serialize(root));
        /*
                  1
                /  \
               2    3
              / \  /  \
             N  N 4    5
                 / \  / \
                N  N  N  N
         */
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        List<String> nodes = new ArrayList<>();
        dfs(root, nodes);
        return String.join(",", nodes);
    }
    public static void dfs(TreeNode root, List<String> nodes) {
        if (root == null) {
            nodes.add("N");
            return;
        }
        nodes.add(String.valueOf(root.val));
        dfs(root.left, nodes);
        dfs(root.right, nodes);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        List<Integer> iList = new ArrayList<>();
        iList.add(0);
        return dfs(nodes, iList);
    }
    //"1,2,N,N,3,4,N,N,5,N,N"
    public static TreeNode dfs(String[] nodes, List<Integer> iList) {
        if (nodes[iList.get(0)].equals("N")) {
            iList.set(0, iList.get(0)+1);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[iList.get(0)]));
        iList.set(0, iList.get(0)+1);
        node.left = dfs(nodes, iList);
        node.right = dfs(nodes, iList);
        return node;
    }
}
