package com.leetcode.no2;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/16
 * @description:
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        StringBuffer buffer1 = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        while (cur1.next != null || cur2.next != null) {
            int m1 = cur1 == null ? 0 : cur1.val;
            int m2 = cur2 == null ? 0 : cur2.val;
            cur1 = cur1.next;
            cur2 = cur2.next;
            buffer1.append(m1);
            buffer2.append(m2);
        }
        char[] c1 = buffer1.reverse().toString().toCharArray();
        char[] c2 = buffer2.reverse().toString().toCharArray();
        int add = 0;
        StringBuffer resultBuffer = new StringBuffer();
        for (int i = c1.length -1; i >=0 ; i++) {
            int result = c1[i] + c2[i] + add;
            resultBuffer.append(result%10);
            add = result/10;
        }
        char[] result_char = resultBuffer.toString().toCharArray();
        ListNode resultNode = new ListNode(-1);
        ListNode temp = resultNode;
        for (int i = 0; i < result_char.length; i++) {
            temp.val = Integer.valueOf(result_char[i]);
            temp = temp.next;
        }
        temp.next = null;
        return resultNode;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
