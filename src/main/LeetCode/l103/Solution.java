package main.LeetCode.l103;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

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


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> floor = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if(root==null){
            return result;
        }
        boolean left = true;
        queue.add(root);
        LinkedList<Integer> r = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                floor.add(poll.left);
            }
            if (poll.right != null) {
                floor.add(poll.right);
            }
            r.add(poll.val);
            if (queue.isEmpty()) {
                if (!left) {
                    Collections.reverse(r);
                }
                result.add(r);
                r = new LinkedList<>();
                Deque<TreeNode> temp = queue;
                queue = floor;
                floor = temp;
                left = !left;
            }
        }
        return result;
    }

}
