package main.TME;

import java.util.*;


class ListNode {
    int val;
    ListNode next = null;
}


public class Main {
    public static void main(String[] args) {

    }
    /**
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        ListNode myHead=new ListNode();
        myHead.next=head;
        ListNode pre;
        ListNode last;
        ListNode now=myHead;
        for(int i=0;i<m-1;i++){
            if(now.next==null){
                return head;
            }
            now=now.next;
        }
        pre=now;
        //TODO
        System.out.println(pre.val);
        for(int i=m;i<n;i++){
            if(now.next==null){
                return head;
            }
            now=now.next;
        }
        last=now;
        //TODO
        System.out.println(last.val);
        ListNode node = reverse(pre,n-m);
        //TODO
        System.out.println(node.val);
        pre.next=node;
        for(int i=0;i<n-m;i++){
            node=node.next;
        }
        node.next=last;
        return myHead.next;
    }
    public ListNode reverse(ListNode head,int length){
        ListNode pre= head;
        ListNode now=pre.next;
        ListNode next=now.next;
        for(int i=0;i<length;i++){
            next=now.next;
            now.next=pre;
            pre=now;
            now=next;
        }
        return now;
    }
}