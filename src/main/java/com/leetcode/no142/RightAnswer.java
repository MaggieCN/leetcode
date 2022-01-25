package com.leetcode.no142;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/16
 * @description:
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
 * 这个题跟141的区别在于，即使判断出fast==slow了，也并不能确定该结点即为相交节点。
 * 第一次相遇后，fast重定到头节点，再走a步就可与slow重合
 */
public class RightAnswer {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
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



