package main.LeetCode.o52;


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
        int na=0;
        int nb=0;
        ListNode nowa=headA;
        ListNode nowb=headB;
        while (nowa!=null){
            na++;
            nowa=nowa.next;
        }
        while (nowb != null) {
            nb++;
            nowb=nowb.next;
        }
        ListNode l;
        ListNode s;
        int lo;
        int sh;
        if(na>nb){
            sh=nb;
            lo=na;
            l=headA;
            s=headB;
        }else{
            sh=na;
            lo=nb;
            l=headB;
            s=headA;
        }
        for (int i = 0; i < lo-sh; i++) {
            l=l.next;
        }
        for (int i = 0; i < sh; i++) {
            if(l==s&&l!=null){
                return l;
            }
            l=l.next;
            s=s.next;
        }
        return null;

    }
}
