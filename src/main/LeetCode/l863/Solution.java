package main.LeetCode.l863;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

    }

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> list;
    Set<Integer> set;
    Map<TreeNode, TreeNode> map;
    int max = 0;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //使用一个map记录pre，这样可以小代价重建树结构
        //先遍历树
        map = new HashMap<>();
        list = new LinkedList<>();
        set = new HashSet<>();//控制哪些访问过哪些没访问过
        max = k;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode now = root;
        stack.push(now);
        while (!stack.isEmpty()) {
            now = stack.poll();
            if (now.left != null) {
                stack.push(now.left);
                map.put(now.left, now);
            }
            if (now.right != null) {
                stack.push(now.right);
                map.put(now.right, now);
            }
        }
        checkDistance(target, 0);
        return list;
    }

    private void checkDistance(TreeNode now, int length) {
        if (length > max) {
            return;
        }
        if (length == max) {
            list.add(now.val);
        }
        set.add(now.val);
        if (now.left != null) {
            if (!set.contains(now.left.val)) {
                checkDistance(now.left, length + 1);
            }
        }
        if (now.right != null) {
            if (!set.contains(now.right.val)) {
                checkDistance(now.right, length + 1);
            }
        }
        if (map.containsKey(now)) {
            TreeNode pre = map.get(now);
            if (!set.contains(pre.val)) {
                checkDistance(pre, length + 1);
            }
        }
    }

}
