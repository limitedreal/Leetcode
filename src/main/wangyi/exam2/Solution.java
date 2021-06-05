package main.wangyi.exam2;

import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) {
        ListNode x1=new ListNode(-1);
        ListNode x2=new ListNode(2);
        ListNode x3=new ListNode(4);
        x1.next=x2;
        x2.next=x3;
        ListNode x4=new ListNode(1);
        ListNode x5=new ListNode(2);
        ListNode x6=new ListNode(3);
        x4.next=x5;
        x5.next=x6;
        Solution s = new Solution();
        s.minusList(x1,x4);
        int i = 0;

    }
    public ListNode minusList(ListNode minuendList, ListNode subtrahendList) {
        StringBuilder minuendStr = new StringBuilder(),subtrahendStr = new StringBuilder();
        ListNode head = minuendList;
        while (head!=null){
            minuendStr.append(head.val);
            head= head.next;
        }
        //minuendStr.reverse();
        head = subtrahendList;
        while (head!=null){
            subtrahendStr.append(head.val);
            head = head.next;
        }
        //subtrahendStr.reverse();
        BigDecimal minuend = new BigDecimal(minuendStr.toString())
                ,subtrahend = new BigDecimal(subtrahendStr.toString())
                ,resultDecimal = minuend.add(subtrahend.multiply(new BigDecimal(-1)));
        String s = resultDecimal.toString();
        int n = s.length();
        ListNode result;
        int i = 0;
        if(s.charAt(i)=='-'){
            i++;
            result = new ListNode(-(s.charAt(i)-'0'));
        }else{
            result = new ListNode(s.charAt(i)-'0');
        }
        i++;
        head = result;
        for (;i<n;i++){
            result.next= new ListNode(s.charAt(i)-'0');
            result=result.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
