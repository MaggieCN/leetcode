package com.leetcode.offer24;


/**
 * @Author MaggieCN
 * @Date 2021/10/21
 * @Description
 * 1->2->3->4->5->null
 * null->5->4->3->2->1
 */
public class ReverseListNode {
    public static void main(String[] args) {

    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur.next!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = tmp;
            cur = pre;
        }
        return cur;
    }
}
