package main.LeetCode.l25;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static class ListNode {

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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Solution s = new Solution();
        s.reverseKGroup(l1, 2);
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode now = head;
        while (now != null) {
            list.add(now);
            now = now.next;
        }
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            cnt++;
            if (cnt == k) {
                reverse(list, i - cnt + 1, i);
                cnt = 0;
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        list.get(list.size() - 1).next = null;
        return list.get(0);
    }

    public void reverse(List<ListNode> list, int start, int end) {
        while (start < end) {
            ListNode t = list.get(start);
            list.set(start, list.get(end));
            list.set(end, t);
            start++;
            end--;
        }
    }
}
