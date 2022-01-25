package com.leetcode.no160;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/20
 * @description:
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1 = 0;
        int count2 = 0;
        ListNode list1 = headA;
        ListNode list2 = headB;
        while(list1 !=null){
            count1++;
            list1 = list1.next;
        }
        while(list2 !=null){
            count2++;
            list2 = list2.next;
        }
        list1 = headA;
        list2 = headB;
        for (int i = 0; i < Math.abs(count1-count2); i++) {
            if(count1 > count2){
                list1 = list1.next;
            }else if(count1 < count2){
                list2 = list2.next;
            }
        }
        while(list1 !=null && list2!=null){
            if(list1 == list2)
                return list1;
        }
        return null;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

