package com.jzf.code;

import com.jzf.definition.ListNode;

public class ReverseBetween {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        new ReverseBetween().reverseBetween(node1,2,3);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        ListNode oldHead = head;
        ListNode newHead = head;
        int i = 1;
        while (i<m){
            newHead = newHead.next;
            i++;
        }
        ListNode newTail = newHead;
        while (i<n){
            newTail = newTail.next;
            i++;
        }
        newTail.next = null;
        while(newHead!=null){
            System.out.println(newHead.getVal());
            newHead = newHead.next;
        }
        return null;
    }
}
