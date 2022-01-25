package com.leetcode.no142;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/16
 * @description:
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null){return null;}
        if(head.next==head){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next !=null){
            slow = slow.next;
            if(fast.next.next== null) return null;
            else fast = fast.next.next;
            if(fast == slow){
                fast = head;
                while(fast !=slow){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}


