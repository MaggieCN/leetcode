package com.leetcode.no206;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/22
 * @description:
 */
public class SecondSolution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur !=null){
            ListNode tmp  = cur;
            cur = cur.next;
            tmp.next = pre;
            pre = tmp;
        }
        return pre;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}



