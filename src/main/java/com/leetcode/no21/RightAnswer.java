package com.leetcode.no21;

/**
 * @Author MaggieCN
 * @Date 2021/11/30
 * @Description
 */
public class RightAnswer {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode tmp = res;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        while (list1 !=null && list2!=null){
            if(list1.val <= list2.val){
                tmp.next = list1;
                list1 = list1.next;
            }else{
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }
        if(list1 !=null){
            tmp.next = list1;
        }
        if(list2!=null){
            tmp.next = list2;
        }
        return res.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
