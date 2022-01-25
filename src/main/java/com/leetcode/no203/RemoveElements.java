package com.leetcode.no203;

import com.leetcode.no21.MergeTwoLists;

/**
 * @Author MaggieCN
 * @Date 2021/11/30
 * @Description
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * [1,2,6,4,5,6]
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        ListNode res = cur;
        //这个判断顺序不能换，否则会报空指针错误
        while(cur!=null  && cur.val ==val) {
            cur = cur.next;
            res = cur;
        }
        if(cur == null) return cur;
        while (cur.next!=null){
            if(cur.next.val == val){
                cur.next= cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return res;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
