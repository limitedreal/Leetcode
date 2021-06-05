package main.LeetCode.m0207;


public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null|headB==null){
            return null;
        }
        int n1=1,n2=1;
        ListNode nowA=headA,nowB=headB;
        while (nowA.next!=null){
            nowA=nowA.next;
            n1++;
        }
        while (nowB.next!=null){
            nowB=nowB.next;
            n2++;
        }
        if(nowA!=nowB){
            return null;
        }
        ListNode ls = n1>n2?headB:headA,ll=n1>n2?headA:headB;
        int is=n1>n2?n2:n1,il=n1>n2?n1:n2;
        while (il>is){
            ll=ll.next;
            il--;
        }
        while (ls!=null&&ll!=null){
            if(ls==ll){
                return ls;
            } else{
                ls=ls.next;
                ll=ll.next;
            }
        }
        return null;

    }
}