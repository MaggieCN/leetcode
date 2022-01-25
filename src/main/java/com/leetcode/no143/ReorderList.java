package com.leetcode.no143;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/21
 * @description:
 */
public class ReorderList {
    public static void reorderList(ListNode head) {
        ListNode whole = new ListNode(0);
        whole = head;
        ListNode pre = null;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode cur = start.next;
        int count = 0;
        while(cur !=null){
            ListNode tmp  = cur;
            cur = cur.next;
            tmp.next = pre;
            pre = tmp;
            count ++;
        }
        ListNode res = new ListNode(0);
        res.next = whole;
        ListNode temp = res;
        for (int i = 0; i < count/2; i++) {
            temp = whole;
            whole = whole.next;
            temp = temp.next;
            temp = pre;
            pre = pre.next;
            temp = temp.next;
        }
        head = res.next;
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


