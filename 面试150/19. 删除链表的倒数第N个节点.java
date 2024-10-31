/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode low=head;
        ListNode fast=head;
        while(n != -1){ // 使得 fast-low=n
            if(fast == null)    // 删除的元素是第一个元素,那么n未结束前,fast就会到null;也可以用dummy.next=head去做
                return head.next;
            fast = fast.next;
            --n;
        }
        while(fast != null){
            low = low.next;
            fast = fast.next;
        }
        low.next = low.next.next;
        return head;
    }
}
