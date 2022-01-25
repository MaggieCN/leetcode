package com.leetcode.no82;

import com.leetcode.no2.ListNodeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: gaomeiqi
 * @Date: 2021/12/20
 * @description:
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head ==null || head.next == null) return head;
        ListNode listNode = head;
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        while(listNode!=null){
            map.put(listNode.val, map.containsKey(listNode.val)? 1:0);
            listNode = listNode.next;
            count++;
        }
        listNode = head;
        ListNode resNode = new ListNode(-1);
        ListNode temp = resNode;
        for (int i = 0; i < count; i++) {
            if(map.get(listNode.val) == 0){
                temp.next = new ListNode(listNode.val);
                temp = temp.next;
            }
            listNode = listNode.next;
        }
        return resNode.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

