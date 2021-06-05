package main.LeetCode.l2;

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

public class Solution {
    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = 0, n2 = 0;
        ListNode head1 = l1, head2 = l2;
        while (head1 != null) {
            n1++;
            head1 = head1.next;
        }
        while (head2 != null) {
            n2++;
            head2 = head2.next;
        }
        //比如n1=2，n2=4;bigger = 4,resultArr[5]
        int bigger = n1 > n2 ? n1 : n2;
        ListNode bigList = n1 > n2 ? l1 : l2;
        ListNode smallList = n1 > n2 ? l2 : l1;
        int[] resultArr = new int[bigger + 1];
        int i = 0;
        for (i = 1; i <= n2 - n1; i++) {
            resultArr[bigger - i] = bigList.val;
            bigList = bigList.next;
        }
        //此时i=3
        short s = 1;
        s+=1;

        for (; i < bigger; i++) {
            resultArr[bigger - i] = bigList.val + smallList.val;
            bigList = bigList.next;
            smallList = smallList.next;
        }
        ListNode pre = null, now = null;
        for (i = 0; i < resultArr.length; i++) {
            if (resultArr[i] > 10) {
                resultArr[i + 1]++;
                resultArr[i] -= 10;
            }
            now = new ListNode();
            now.val = resultArr[i];
            now.next = pre;
            pre = now;
        }
        if(bigger==1){
            return now;
        }
        if(now.val==0){
            now = now.next;
        }
        return now;
    }
}