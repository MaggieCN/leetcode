package com.leetcode.no24;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/21
 * @description:
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/bi-jiao-zhi-jie-gao-xiao-de-zuo-fa-han-tu-jie-by-w/
 */
public class RightAnswer {
    public ListNode swapPairs(ListNode head) {
        ListNode thread = new ListNode(0);
        thread.next = head;
        ListNode temp = thread;
        while( temp.next!=null && temp.next.next!=null){
            ListNode A = temp.next;
            ListNode B = temp.next.next;
            temp.next = B;
            A.next = B.next;
            B.next = A;
            temp = temp.next.next;
        }
        return thread.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
