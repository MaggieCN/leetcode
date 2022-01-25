package com.leetcode.no206;

/**
 * @Author MaggieCN
 * @Date 2021/11/30
 * @Description
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode dumpNode = new ListNode();
        ListNode cur = head;
        ListNode pre = dumpNode;
        while (cur.next!=null){
            ListNode tmp = cur;
            pre.next = tmp;
            cur = cur.next;
        }
        return pre.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
