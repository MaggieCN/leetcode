package com.leetcode.no141;

/**
 * @Author MaggieCN
 * @Date 2021/11/30
 * @Description
 */
public class RIghtAnswer {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next !=null){
            slow = slow.next;
            if(fast.next.next == null) return false;
            else {
                fast = fast.next.next;
            }
            if(slow == fast) return true;
        }
        return false;
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
