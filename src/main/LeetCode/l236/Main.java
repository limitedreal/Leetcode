package main.LeetCode.l236;

public class Main {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        node3.left=node5;
        node3.right=node1;
        node5.left=node6;
        node5.right=node2;
        node1.left=node0;
        node1.right=node8;
        node2.left=node7;
        node2.right=node4;
        Solution s = new Solution();
        TreeNode treeNode = s.lowestCommonAncestor(node3, node5, node1);
        System.out.println(treeNode.val);
    }
}
