package com.leetcode.no83;


import java.util.HashMap;

/**
 * @Author MaggieCN
 * @Date 2021/11/1
 * @Description
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        while(cur.next!=null){
            hashMap.put(count, cur.val);
            count ++;
            for (int i = 0; i < count -1; i++) {
                if(head.val == hashMap.get(i)){
                    pre.next = cur;
                    cur = cur.next;
                }
            }
            ListNode tmp = cur;
            cur = tmp.next;
            pre = tmp;
        }
        return cur;
    }
     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
