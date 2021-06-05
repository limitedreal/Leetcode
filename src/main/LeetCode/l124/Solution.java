package main.LeetCode.l124;

import static java.lang.Math.max;

public class Solution {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node4 = new TreeNode();
        node1.val = -3;
        //node2.val = -2;
        //node3.val = 3;
        //node4.val = 4;
        //node1.left = node2;
        //node1.right = node3;
        //node2.left = node4;
        Solution s = new Solution();
        System.out.println(s.maxPathSum(node1));
    }

    int result = Integer.MIN_VALUE/2;

    public int maxPathSum(TreeNode root) {
        //应该是左子树的最大路径和、右子树的最大路径和
        dfs(root);
        return result;
    }

    public int dfs(TreeNode target) {
        if (target == null) {
            return Integer.MIN_VALUE/2;
        }
        int left = max(dfs(target.left),0), right = max(dfs(target.right),0);
        int temp = left+ target.val+right;
        if (temp > result) {
            result = temp;
        }
        return target.val+max(left,right);
    }
}

