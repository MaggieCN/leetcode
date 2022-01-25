package com.leetcode.no141;

import com.leetcode.no142.DetectCycle;

/**
 * @Author MaggieCN
 * @Date 2021/11/30
 * @Description
 * 执行会出错，大量数据时，会报nullpointer 的错误
 */
public class CycleLinkedList {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        if(head.next == null){
            if(head.next ==head) return true;
            else return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast != null && slow!=null){
            if(fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }


    public boolean hasCycle1(ListNode head) {
        if(head.next==head){
            return true;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast.next !=null){
            slow = slow.next;
            if(fast.next.next== null) return false;
            else{
                fast = fast.next.next;
            }
            if(fast == slow){
                return true;
            }
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
