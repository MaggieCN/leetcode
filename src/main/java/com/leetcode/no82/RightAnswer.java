package com.leetcode.no82;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/20
 * @description:
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/javadi-gui-0ms-by-maplestore/
 */
public class RightAnswer {
    public ListNode deleteDuplicates(ListNode head) {
        //1.递归终止条件
        if (head == null || head.next == null) return head;
        int tempVal = head.val;//2.缓存当前这层的节点的元素,用来进行等值判断
        if (tempVal == head.next.val) {//3.如果当前节点与下一个节点元素相等,说明这是个重复元素,就开始进行删除操作
            while (head != null && tempVal == head.val) {//4.从当前节点开始删除, 即, 使当前节点等于下一个节点
                head = head.next;
            }
            return deleteDuplicates(head);
        } else {//5.如果当前节点与下一个节点元素不等,则对下一个节点之后的节点进行判断
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
    //https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/java-ya-jie-dian-fei-di-gui-rong-yi-li-jie-yong-sh/

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next;
                while (temp != null && temp.next != null && temp.val == temp.next.val ) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            }
            else
                cur = cur.next;
        }
        return dummy.next;
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

