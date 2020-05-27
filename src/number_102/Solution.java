package number_102;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> tmp = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            res.add(tmp);

        }
        return res;

    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','b','c'};
        System.out.println(String.valueOf(chars));
        System.out.println(String.copyValueOf(chars));
        System.out.println("hello world".endsWith("ld"));
        System.out.println("hello world!".indexOf(""));
        System.out.println("hello world!".lastIndexOf("l"));
        System.out.println("hello world!".substring(2));
        System.out.println("hello world!".toCharArray());
        System.out.println(String.valueOf(1));
        System.out.println("hello world!".charAt(9));
        String[] strings = {"hni", "jda"};
        System.out.println(String.join(", ", strings));
        StringBuilder sb = new StringBuilder("hello world");
        System.out.println(sb.append("hubaile").insert(1, "l"));


    }
}
