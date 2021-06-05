package main.ali;

/**
 * 题目:
 * 1.判定两个链表是否满足条件：
 * 1）每个链表均无环
 * 2）在满足每个链表均无环的情况下，判定两个链表是否相交
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 这是一个链表，提供是否有环以及跟另一个链表是否相交的判断功能
 * 1. 判断有环实现函数 isCycleExist函数
 * 2. 判断两个链表是否相交，前置条件是两个链表均无环，故不用考虑有环的情况，实现函数isIntersect
 */
public class LinkedList {

    /**
     * 链表节点
     */
    class Node {
        /** Node值，为一个整数 */
        int value;
        /** 指向下一个节点，最后一个节点指向null*/
        Node next;
    }

    /** 链表头 */
    private Node head;

    /**
     * 判斷链表是否有环
     *
     * @return
     */
    public boolean isCycleExist() {
        //TODO,实现该函数，判断链表是否有环
        Map<Node, Integer> map = new HashMap<>();
        Node now = head;
        while (now != null) {
            if (map.containsKey(now)) {//如果包含now，那就直接返回，有环
                return true;
            }
            map.put(now, 1);
            now = now.next;
        }
        return false;
    }

    /**
     * 判断两个链表是否相交
     * 前提为两个链表均无环
     * @param linkedList
     * @return
     */
    public boolean isIntersect(LinkedList linkedList) {
        //TODO 实现该函数，判断两个链表是否相交，两个链表均无环，无需考虑有环情况
        Node now = head;
        Node target = linkedList.getHead();
        //这个方法可以这么写，也就是
        int n1 = 0, n2 = 0;
        while (now != null) {
            n1++;
            now = now.next;
        }
        while (target != null) {
            n2++;
            target = target.next;
        }
        now = head;
        target = linkedList.getHead();
        int longLength = Math.abs(n1-n2);
        Node longList = n1>n2?now:target;
        Node shortList = n1<=n2?now:target;
        for (int i = 0;i<longLength;i++){
            longList = longList.next;
        }
        while (longList!=null&&shortList!=null){
            if(longList==shortList){
                return true;
            }
            longList = longList.next;
            shortList = shortList.next;
        }
        return false;
    }

    /**
     * Setter method for property head.
     *
     * @param head value to be assigned to property head
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * Getter method for property head.
     *
     * @return property value of head
     */
    public Node getHead() {
        return head;
    }

}
