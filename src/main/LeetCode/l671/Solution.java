package main.LeetCode.l671;


public class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        return finSecondRecursive(root, root.val);
    }

    public int finSecondRecursive(TreeNode root, int val) {
        if (root == null) {
            return -1;
        }
        if (root.val > val) {
            return root.val;
        }
        int l = finSecondRecursive(root.left, val);
        int r = finSecondRecursive(root.right, val);
        if (l > val && r > val) {
            return Math.min(l,r);
        }
        return Math.max(l,r);
    }

}

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
