package main.TME.exam1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public TreeNode cyclicShiftTree(TreeNode root, int k) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> list = new ArrayList<>();
        boolean flag=true;
        while (flag) {
            for (int i = 0; i < k; i++) {
                TreeNode treeNode = queue.pollLast();
                queue.add(0, treeNode);
            }
            //首先要恢复和上一层的联系
            for (int i = 0; i < list.size(); i++) {
                TreeNode treeNode = list.get(i);
                if (i * 2 < queue.size()) {
                    treeNode.left = queue.get(i * 2);
                }
                if (i * 2 + 1 < queue.size()) {
                    treeNode.right = queue.get(i * 2 + 1);
                }
            }
            list.clear();
            list.addAll(queue);
            queue.clear();
            for (TreeNode treeNode : list) {
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }
            flag=false;
            for (TreeNode treeNode : queue) {
                if(treeNode!=null){
                    flag=true;
                }
            }
        }
        return root;
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
