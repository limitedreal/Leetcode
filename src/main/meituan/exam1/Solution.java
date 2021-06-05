package main.meituan.exam1;

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head,slow = head;
        if(head == null){
            //如果一开始就是null，认为算是没有环
            return false;
        }
        while (fast!=null&&slow!=null){
            slow = slow.next;
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }else{
                return false;
            }
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
