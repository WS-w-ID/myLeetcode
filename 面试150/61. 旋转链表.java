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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode fast=head;
        ListNode low=head;
        int cnt=0;
        while(fast != null){
            fast = fast.next;
            ++cnt;
        }
        if(cnt==0 || cnt==1 || k%cnt==0)
            return head;
        k = k%cnt;
        fast = head;
        while(k != 0){
            fast = fast.next;
            --k;
        }
        while(fast.next != null){
            fast = fast.next;
            low = low.next;
        }
        ListNode ans = low.next;
        low.next = null;
        fast.next = head;
        return ans;
    }
}
