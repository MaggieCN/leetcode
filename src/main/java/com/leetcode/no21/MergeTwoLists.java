package com.leetcode.no21;



/**
 * @Author MaggieCN
 * @Date 2021/11/30
 * @Description
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res;
        if(list1 == null && list2 == null) return null;
        if(compareTo(list1.val, list2.val)){
            res = list1;
            res.next = list2;
        }else{
            res = list2;
            res.next = list1;
        }
        while (list1 !=null && list2!=null){
            if(compareTo(list1.val,list2.val)){
                res.next = list1;
                res.next.next = list2;
            }else{
                res.next = list2;
                res.next.next = list1;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        if(list1 !=null){
            res.next = list1;
        }
        if(list2!=null){
            res.next = list2;
        }
        return res;
    }
    public boolean compareTo(int a, int b){
        if(a > b) return false;
        else return true;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
