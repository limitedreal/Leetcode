package main.beike.exam4;

import java.util.*;

public class Solution {
    class decor {
        TreeNode node;
        int left = 0;
        int right = 0;

        public decor(TreeNode node, int left, int right) {
            this.node = node;
        }
    }

    static Map<TreeNode, TreeNode> map;

    public int maxSubTree(TreeNode root) {
        //从叶子结点不断往上找
        //在诸多的叶子节点中，必然会存在同构的树，
        // 每一轮都比较这些叶子结点回溯的路径是否相同，对他们进行分类
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        Stack<TreeNode> k = new Stack<>();
        map = new HashMap<>();
        List<TreeNode> left = new ArrayList<>();
        List<TreeNode> right = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode now = stack.pop();
            if (now.left != null) {
                stack.push(now.left);
                map.put(now.left, now);
            }
            if (now.right != null) {
                stack.push(now.right);
                map.put(now.right, now);
            }
            if (now.left == null && now.right == null) {
                TreeNode pre = map.get(now);
                if (pre.left == now) {
                    left.add(now);
                } else {
                    right.add(now);
                }
            }
        }
        //遍历结束

        //现在我们要使用分治法，对于左右两种非常适合分治法

        return Math.max(merge(left, 0), merge(right, 0));
    }

    public static int merge(List<TreeNode> list, int count) {
        if (list.size() < 2) {
            return count;
        }
        List<TreeNode> left = new ArrayList<>();
        List<TreeNode> right = new ArrayList<>();
        for (TreeNode node : list) {
            TreeNode pre = map.getOrDefault(node,null);
            if(pre==null){
                return count;
            }
            if (pre.left == node) {
                left.add(pre);
            } else {
                right.add(pre);
            }
        }
        return Math.max(merge(left, count + 1), merge(right, count + 1));
    }

}
