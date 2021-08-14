package main.LeetCode.l138;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        List<Node> list = new ArrayList();
        Node now = head;
        Map<Node,Node> map=new HashMap<>();
        while (now!=null){
            Node temp=new Node(now.val);
            map.put(now,temp);
            now=now.next;
        }
        now=head;
        while (now!=null){
            Node t=map.get(now);
            if(now.next!=null){
                t.next=map.get(now.next);
            }
            if(now.random!=null){
                t.random=map.get(now.random);
            }
            now=now.next;
        }
        return map.get(head);
    }
}
