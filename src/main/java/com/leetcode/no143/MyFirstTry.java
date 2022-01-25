package com.leetcode.no143;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/22
 * @description:
 */
public class MyFirstTry {
    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next !=null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next =null;
        newHead = reverseList(newHead);

        while(newHead !=null){
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }
    }
    private static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur !=null){
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = pre;
            pre = tmp;
        }
        return pre;
    }
    private static ListNode createLinkedList(int[] arr) {//将输入的数组输入到链表中
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {//过程
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    private static void printLinkedList(ListNode head){//将链表结果打印
        ListNode current =  head;
        while (current!=null){
            System.out.printf("%d -> ",current.val);
            current = current.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        int[] x = {1,2,3,4,5,6};
        ListNode list1 = createLinkedList(x);
        reorderList(list1);
        printLinkedList(list1);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


