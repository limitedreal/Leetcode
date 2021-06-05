package main.exam.tencent.exam1;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1);
        t1.left = t2;t1.right=t3;
        int[] b = {1,2,3};
        solve(t1,b);
    }
    public static ListNode[] solve(TreeNode root, int[] b) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Map<Integer, MyTreeNode> map = new HashMap<>();
        while (!stack.empty()) {
            TreeNode now = stack.pop();
            map.put(now.val, new MyTreeNode());
            if (now.left != null) {
                stack.push(now.left);
            }
            if (now.right != null) {
                stack.push(now.right);
            }
        }
        MyTreeNode head = rebuild(root, null, map);
        ListNode[] result = new ListNode[b.length];
        for (int i = 0; i < b.length; i++) {
            MyTreeNode myTreeNode = map.get(b[i]);
            Stack<ListNode> list = new Stack<>();
            while (myTreeNode != null) {
                list.push(new ListNode(myTreeNode.val));
                myTreeNode = myTreeNode.parent;
            }
            ListNode now = list.pop();
            result[i] = now;
            while (!list.empty()) {
                now.next = list.pop();
                now = now.next;
            }
        }
        return result;
    }

    public static MyTreeNode rebuild(TreeNode treeNode, MyTreeNode parent, Map<Integer, MyTreeNode> map) {
        MyTreeNode myTreeNode = map.get(treeNode.val);
        MyTreeNode left = null, right = null;
        if (treeNode.left != null) {
            left = rebuild(treeNode.left, myTreeNode, map);
        }
        if (treeNode.right != null) {
            right = rebuild(treeNode.right, myTreeNode, map);
        }
        myTreeNode.left = left;
        myTreeNode.right = right;
        myTreeNode.parent = parent;
        myTreeNode.val = treeNode.val;
        return myTreeNode;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

class MyTreeNode {
    int val = 0;
    MyTreeNode left = null;
    MyTreeNode right = null;
    MyTreeNode parent = null;

    public MyTreeNode() {
    }
}