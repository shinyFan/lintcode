package com.jzf.code;

import com.jzf.definition.ListNode;

public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){ //快慢指针相遇，说明环存在
                //first代表着链表的起始点
                //slow代表着相遇点
                ListNode first = head;
                while(first != slow){//从相遇点和链表起始点同时循环两个指针，直到二者相遇，相遇点就是环起始点
                    first = first.next;
                    slow = slow.next;
                }
                return first;
            }
        }
        return null;
    }
}
