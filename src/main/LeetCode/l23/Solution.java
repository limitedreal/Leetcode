package main.LeetCode.l23;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        Solution s=new Solution();
        ListNode[] lists=new ListNode[2];
        lists[0]=new ListNode(0);
        lists[1]=new ListNode(1);
        s.mergeKLists(lists);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        lists=new ListNode[0];
        PriorityQueue<ListNode> queue=new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if(list!=null){
                queue.add(list);
            }
        }

        ListNode head=new ListNode();
        ListNode now=head;
        while (!queue.isEmpty()){
            now.next=queue.poll();
            now=now.next;
            if(now.next!=null){
                queue.add(now.next);
            }
        }
        System.out.println("");
        return head.next;
    }
}

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