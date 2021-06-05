package main.LeetCode.l124;

import java.util.*;

public class Wrong {
    //错误的做法！
    static int maxRoad = 0;
    static Set<MyTreeNode> couldBeStart;//是否能作为开始结点

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        //TreeNode node3 = new TreeNode();
        //TreeNode node4 = new TreeNode();
        node1.val = -2;
        node2.val = -1;
        //node3.val = 3;
        //node4.val = 3;
        node1.left = node2;
        //node1.right = node3;
        //node2.left = node4;
        System.out.println(maxPathSum(node1));
    }

    public static int maxPathSum(TreeNode root) {
        maxRoad = Integer.MIN_VALUE;
        couldBeStart = new HashSet<>();
        //第一项工作是重建树
        MyTreeNode head = rebuild(root);
        //然后深度优先搜索
        Set<MyTreeNode> set = new HashSet<>();
        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.add(head);
        int minW = Integer.MIN_VALUE;
        MyTreeNode t = head;
        while (!queue.isEmpty()){
            MyTreeNode now = queue.poll();
            if(now.val>minW){
                minW = now.val;
                t = now;
            }
            if(now.val>0){
                dfs(now, 0, set);
                return maxRoad;
            }
            if(now.left!=null){
                queue.add(now.left);
            }
            if(now.right!=null){
                queue.add(now.right);
            }
        }
        dfs(t, 0, set);
        return maxRoad;
    }

    public static void dfs(MyTreeNode now, int preWeight, Set<MyTreeNode> road) {
        //now是现在要遍历的结点，preweight是之前已经累计的路径和
        //要有三个主要操作，第一个是pre加上当前的val，
        // 作为之前路径的路径和，传下去给左右孩子，然后还要从自己这里开始找，三步
        int weight = now.val + preWeight;
        if (weight > maxRoad) {
            maxRoad = weight;
        }
        boolean flag = couldBeStart.contains(now);
        couldBeStart.add(now);
        road.add(now);
        if (now.left != null && !road.contains(now.left)) {
            //如果不包含在路径里，也就是在这条路径中没访问过的话
            Set<MyTreeNode> set = new HashSet<>(road);
            dfs(now.left, weight, set);

        }
        if (now.right != null && !road.contains(now.right)) {
            //如果不包含在路径里，也就是在这条路径中没访问过的话
            Set<MyTreeNode> set = new HashSet<>(road);
            dfs(now.right, weight, set);

        }
        if (now.parent != null && !road.contains(now.parent)) {
            //如果不包含在路径里，也就是在这条路径中没访问过的话
            Set<MyTreeNode> set = new HashSet<>(road);
            dfs(now.parent, weight, set);
        }
        if(!flag&&now.val>0){//如果没有作为过开始结点的话
            Set<MyTreeNode> set = new HashSet<>();
            dfs(now,0,set);
        }

    }

    public static MyTreeNode rebuild(TreeNode treeNode) {
        MyTreeNode myTreeNode = new MyTreeNode();
        MyTreeNode left = null, right = null;
        if (treeNode.left != null) {
            left = rebuild(treeNode.left);
            left.parent = myTreeNode;
        }
        if (treeNode.right != null) {
            right = rebuild(treeNode.right);
            right.parent = myTreeNode;
        }
        myTreeNode.left = left;
        myTreeNode.right = right;
        myTreeNode.val = treeNode.val;
        return myTreeNode;
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


