package com.jzf.code;

import com.jzf.definition.ListNode;

public class Reverse {
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode tail=head;
        ListNode pnext;
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        while(head.next!=null){
            pnext = head.next;
            head.next = pnext.next;
            pnext.next = tail;
            tail = pnext;
        }
        return tail;
    }
}
