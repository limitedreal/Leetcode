package main.LeetCode.l146;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache l=new LRUCache(3);
        l.put(1,1);
        l.put(2,2);
        l.put(3,3);
        l.put(4,4);
        System.out.println(l.get(4));
        System.out.println(l.get(3));
        System.out.println(l.get(2));
        System.out.println(l.get(1));
        l.put(5,5);
        System.out.println(l.get(1));
        System.out.println(l.get(2));
        System.out.println(l.get(3));
        System.out.println(l.get(4));
        System.out.println(l.get(5));

    }

    //map里面嵌套链表的设计
    class Node {

        Node pre = null;
        Node next = null;
        int value;
        int key;

        public Node(int key) {
            this.key = key;
        }
    }

    Map<Integer, Node> map;
    Node head = null;
    Node last = null;
    int cnt = 0;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity + 1);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node now = map.get(key);
        if (now == null) {
            return -1;
        }
        //把访问的借点移动到头部
        if (now == head) {
            //如果now是头结点
            //nothing
        } else if (now == last) {
            //如果now是尾结点
            last = now.pre;
            last.next = null;
            now.pre = null;
            now.next = head;
            head.pre=now;
            head = now;
        } else {
            //如果now是中间节点
            Node t = now.pre;
            t.next = now.next;
            t = now.next;
            t.pre = now.pre;
            now.pre = null;
            now.next = head;
            head.pre=now;
            head = now;
        }
        return now.value;
    }

    public void put(int key, int value) {
        Node now = map.get(key);
        if (now == null) {
            now = new Node(key);
            cnt++;
            now.next = head;
            if (head != null) {
                head.pre = now;
            }
            head = now;
            if (last == null) {
                last = now;
            }
            map.put(key, now);
        }
        now.value = value;
        if (cnt > capacity) {
            map.remove(last.key);
            last = last.pre;
            last.next=null;
        }
        get(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
