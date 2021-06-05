package main.LeetCode.l19;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        Queue<ListNode> queue = new LinkedList();
        ListNode now = head,pre=null;
        int i=0;
        while (now!=null){
            if(i>=n){
                //说明已经塞了n个了
                pre = queue.poll();
                queue.add(now);
            }else{
                queue.add(now);
                i++;
            }
            now=now.next;
        }
        if(pre==null){
            //那就说明没有进入i>=n的环节，说明要删除是头结点
            return head.next;
        }else{
            pre.next=pre.next.next;
            return head;
        }


    }
}
