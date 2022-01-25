package com.leetcode.no2;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/16
 * @description:
 */
public class ListNodeTest {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        StringBuffer buffer1 = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        while (cur1 != null || cur2 != null) {
            int m1 = cur1 == null ? 0 : cur1.val;
            int m2 = cur2 == null ? 0 : cur2.val;
            if(cur1 == null){
                cur2 = cur2.next;
            } else if(cur2 == null){
                cur1 = cur1.next;
            }else{
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            buffer1.append(m1);
            buffer2.append(m2);
        }
        char[] c1 = buffer1.reverse().toString().toCharArray();
        char[] c2 = buffer2.reverse().toString().toCharArray();
        int add = 0;
        int index = c1.length -1;
        StringBuffer resultBuffer = new StringBuffer();
        while(index >=0 || add!=0){
            int a = index >=0 ? c1[index] - '0' : 0;
            int b = index >=0 ? c2[index] - '0' : 0;
            int result = a+b + add;
            resultBuffer.append(result % 10);
            add = result / 10;
            index --;
        }
        char[] result_char = resultBuffer.toString().toCharArray();
        ListNode resultNode = new ListNode(result_char[0] - '0');
        ListNode temp = resultNode;
        for (int i = 1; i < result_char.length; i++) {
            temp.next = new ListNode(result_char[i] - '0');
            temp = temp.next;
        }
        return resultNode;
    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }//Leetcode中链表的定义
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
        int[] x = {9,9,9,9,9,9,9};
        int[] y = {9,9,9,9};
        ListNode list1 = createLinkedList(x);
        ListNode list2 = createLinkedList(y);
        ListNode res = addTwoNumbers(list1, list2);
        printLinkedList(res);
    }
}
