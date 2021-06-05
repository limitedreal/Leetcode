package main.LeetCode.l142;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        //快慢指针法
        if(head==null){
            return null;
        }
        ListNode slow = head,fast = head;
        while (true){
            if(slow==null||fast==null){
                return null;
            }
            slow = slow.next;
            fast = fast.next;
            if(fast==null){
                return null;
            }else{
                fast = fast.next;
            }
            if(fast==slow){
                break;
            }
        }
        ListNode result = head;
        while (result!=slow){
            result=result.next;
            slow= slow.next;
        }
        return result;
    }
}