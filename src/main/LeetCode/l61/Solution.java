package main.LeetCode.l61;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //将每个节点向右移动k个位置，实际上是让倒数第k位的结点作为新的头结点，这样子把原链表连起来
        //当然要考虑到1. k的长度可能大于链表长度
        //我想可以先使用list存起来每个节点，然后施行
        if(head==null){
            return null;
        }
        List<ListNode> nodeList = new ArrayList<>();
        ListNode now = head;
        while (now!=null){
            nodeList.add(now);
            now = now.next;
        }
        int n = nodeList.size();
        for (int i = 0;i<k%n;i++){
            ListNode last = nodeList.get(n - 1);//得到最后一个
            nodeList.add(0,last);
        }
        for (int i = 0;i<n-1;i++){
            nodeList.get(i).next = nodeList.get(i+1);
        }
        nodeList.get(n-1).next = null;
        return nodeList.get(0);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}