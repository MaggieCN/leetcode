package com.leetcode.no203;

/**
 * @Author MaggieCN
 * @Date 2021/11/30
 * @Description
 */
public class RightAnswer {
    // 方法一：虚拟头节点
    public ListNode removeElements1(ListNode head, int val) {
        ListNode dumpNode = new ListNode(-1);
        dumpNode.next = head;
        ListNode tmpNode = dumpNode;
        while(tmpNode.next!=null){
            if(tmpNode.next.val == val){
                tmpNode.next = tmpNode.next.next;
            }else {
                tmpNode = tmpNode.next;
            }
        }
        return dumpNode.next;
    }
    //方法二：双指针
    public ListNode removeElements(ListNode head, int val) {
        ListNode dumpNode = new ListNode(-1);
        dumpNode.next = head;
        ListNode cur = head;
        ListNode pre = dumpNode;
        while (cur!=null){
            if(cur.val == val){
                pre.next = cur.next;
                cur = cur.next;
            }else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dumpNode.next;
    }
    // 方法三：特判头节点
    public ListNode removeElements3(ListNode head, int val) {
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
