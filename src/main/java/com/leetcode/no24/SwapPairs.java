package com.leetcode.no24;

import com.leetcode.no2.ListNodeTest;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/21
 * @description:
 */
public class SwapPairs {
    //[1,2,3,4]
    //[2,1,4,3]
    public static ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        ListNode pre = new ListNode(-1);
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        int count = 1;
        while(temp !=null){
            if(count % 2 == 1){
                pre = new ListNode(temp.val);
                if(temp.next == null){
                    cur.next = pre;
                }
            }
            else{
                cur.next = new ListNode(temp.val);
                cur = cur.next;
                cur.next = pre;
                cur = cur.next;
            }
            temp = temp.next;
            count++;
        }
        return res.next;
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
        int[] x = {12,3,5};
        ListNode list1 = createLinkedList(x);
        ListNode res = swapPairs(list1);
        printLinkedList(res);
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
