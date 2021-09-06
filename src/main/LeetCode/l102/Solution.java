package main.LeetCode.l102;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<TreeNode> floor = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<Integer> r = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            r.add(poll.val);

            if (poll.left != null) {
                floor.add(poll.left);
            }
            if (poll.right != null) {
                floor.add(poll.right);
            }
            if (deque.isEmpty()) {
                Deque<TreeNode> t = deque;
                deque = floor;
                floor = t;
                result.add(r);
                r = new LinkedList<>();
            }
        }
        return result;
    }
}
