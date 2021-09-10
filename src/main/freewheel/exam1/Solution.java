package main.freewheel.exam1;

import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root     TreeNode类
     * @param failId   int整型
     * @param timeCost int整型一维数组
     * @return int整型
     */
    public int GetMinTimeCost(TreeNode root, int failId, int[] timeCost) {
        //首先要层序遍历，一方面是赋值，一方面是找到故障节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode fail = null;
        while (!queue.isEmpty()) {
            TreeNode now = queue.poll();
            if (now.val == failId) {
                fail = now;
                break;
            }
            if (now.left != null) {
                queue.add(now.left);
            }
            if (now.right != null) {
                queue.add(now.right);
            }
        }
        if (fail == null) {
            return 0;
        }
        //然后从now开始层序遍历
        queue.clear();
        queue.add(fail);
        Queue<TreeNode> next = new LinkedList<>();
        int result=0;
        while (!queue.isEmpty()) {
            int min = Integer.MAX_VALUE;
            while (!queue.isEmpty()) {
                TreeNode now = queue.poll();
                if (now.left != null) {
                    next.add(now.left);
                }
                if (now.right != null) {
                    next.add(now.right);
                }
                if(now.right!=null||now.left!=null){
                    min = Math.min(timeCost[now.val], min);
                }

            }
            Queue<TreeNode> t=next;
            next=queue;
            queue=t;
            if(min!=Integer.MAX_VALUE){
                result+=min;
            }

        }
        return result;
    }
}