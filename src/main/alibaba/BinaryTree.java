package main.alibaba;

/**
 * 题目:
 * 二叉树每个节点的value为整数值，判定每层的节点value相加是否递增？
 * <p>
 * 注：
 * 1.请注意编码风格，符合模板整体风格
 * 2.利用buildBinaryTree函数构造二叉树
 * 3.在实现过程中，请按层打印出每一个节点的值
 * 4.实现isSumByLayerIncrease函数，判断是否按层递增
 */

import java.util.*;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 这是一个二叉树结构
 * 1. 提供按层遍历能力
 * 2. 按层求和能力，且判断是否递增
 */
public class BinaryTree {
    /**
     * 二叉树节点
     */
    class Node {
        /**
         * 节点值
         */
        private int value;
        /**
         * 左子节点
         */
        private Node leftNode;
        /**
         * 右子节点
         */
        private Node rightNode;

        /**
         * Setter method for property value.
         *
         * @param value value to be assigned to property value
         */
        public void setValue(int value) {
            this.value = value;
        }

        /**
         * Getter method for property value.
         *
         * @return property value of value
         */
        public int getValue() {
            return value;
        }

        /**
         * Setter method for property leftNode.
         *
         * @param leftNode value to be assigned to property leftNode
         */
        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        /**
         * Getter method for property leftNode.
         *
         * @return property value of leftNode
         */
        public Node getLeftNode() {
            return leftNode;
        }

        /**
         * Setter method for property rightNode.
         *
         * @param rightNode value to be assigned to property rightNode
         */
        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        /**
         * Getter method for property rightNode.
         *
         * @return property value of rightNode
         */
        public Node getRightNode() {
            return rightNode;
        }
    }

    /**
     * 二叉树根节点
     */
    private Node root;

    /**
     * @param nodeCount 该树的节点数目
     *                  这是一个二叉树构建方法
     *                  1. 每一个节点随机产生左节点，或者右节点，或者都产生
     *                  2. 每个节点的值随机产生一个整数(0-100)
     */
    private void buildBinaryTree(int nodeCount) {
        if (nodeCount < 1) {
            return;
        }
        // 产生随机数
        Random random = new Random();

        // 用来存储节点，用于构建二叉树
        Queue<Node> nodes = new ConcurrentLinkedQueue<Node>();

        // 构建根节点
        root = new Node();
        root.value = random.nextInt(100);
        nodes.add(root);

        // 由于已经有了根节点，故从1开始计数
        int count = 1;
        while (count < nodeCount) {
            // 从队列里移除父节点
            Node parentNode = nodes.remove();

            // 构建左节点,随机生成一个数，若为偶数，则添加左节点，保证随机决定是否有左子节点
            int isAddLeft = random.nextInt();
            // 在队列为空的情况下，必然加入一个左节点
            if (isEven(isAddLeft) || nodes.isEmpty()) {
                // 构建左节点
                Node leftNode = new Node();
                leftNode.value = random.nextInt(100);
                parentNode.leftNode = leftNode;
                // 将左节点放入队列中
                nodes.add(leftNode);
                count++;
            }

            // 构建右节点,随机生成一个数，若为偶数，则添加右节点，保证随机决定是否有右子节点
            int isAddRight = random.nextInt();
            if (isEven(isAddRight) && count < nodeCount) {
                // 构建左节点
                Node rightNode = new Node();
                rightNode.value = random.nextInt(100);
                parentNode.rightNode = rightNode;
                // 将右节点放入队列中
                nodes.add(rightNode);
                count++;
            }
        }
    }

    /**
     * 判断是否为偶数
     *
     * @param num
     * @return
     */
    private boolean isEven(int num) {
        return num % 2 == 0;
    }

    /**
     * 1. 将二叉树的每一层节点值相加
     * 2. 判断从根节点到叶子节点所在的层，每一层相加后的值是否非递减
     * 3. 方便判断，将会打印出树结构
     *
     * @return
     */
    public boolean isSumByLayerIncrease() {
        //TODO 请实现该方法，要求如下
        // 1. 注意二叉树的构建必须使用 buildBinaryTree(int nodeCount)
        // 2. 按层打印出二叉树value值，每层独立一行，每行两个数字之间用空格隔开
        // 3. 判断二叉树是否按层非递减
        buildBinaryTree(88);//因为自己生成的，所以不会产生root为null的情况
        Node rootNow = root;
        //队列
        Queue<Node> queue = new LinkedList<Node>();
        //Queue<Node> k = new LinkedList<Node>();
        queue.add(rootNow);
        int floorCount = 1;//这一层结点数量
        int preCount = Integer.MIN_VALUE;
        int n = 1;//层数
        boolean flag = true;
        while (!queue.isEmpty()) {//不空就一直循环下去
            int nextFloorCount = 0;//下一层的结点数量
            int nowCount = 0;
            for (int i = 0; i < floorCount; i++) {
                Node now = queue.poll();
                int value = now.getValue();
                nowCount += value;
                System.out.print(value + " ");
                Node left = now.getLeftNode(), right = now.getRightNode();
                if (left != null) {
                    nextFloorCount++;
                    queue.add(left);
                }
                if (right != null) {
                    nextFloorCount++;
                    queue.add(right);
                }
            }
            System.out.print("和为:"+nowCount+"\n");
            floorCount = nextFloorCount;
            n++;
            if(nowCount<preCount){
               flag = false;
            }
            preCount = nowCount;
        }
        return flag;
    }
}

