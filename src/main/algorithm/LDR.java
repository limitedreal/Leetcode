package main.algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LDR {

    class Node {

        int val;
        Node left;
        Node right;
    }

    //非递归中序遍历二叉树
    public List<Node> inorderTraversal(Node root) {
        List<Node> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Deque<Node> stack = new LinkedList<>();
        Node now = root;
        while (now != null || !stack.isEmpty()) {
            while (now != null) {
                stack.addFirst(now);
                now = now.left;
            }
            if (!stack.isEmpty()) {
                now = stack.removeFirst();
                list.add(now);
                now=now.right;
            }
        }
        return list;
    }

}
