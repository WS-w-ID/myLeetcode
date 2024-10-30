/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        /**前后指针 */
        if(head==null || head.next==null)    // 0个或1
            return false;
        ListNode last=head,pre=head.next;
        while(pre != last){   // 无环
            if(pre.next==null || pre.next.next==null)
                return false;
            pre = pre.next.next;
            last = last.next;
        }
        return true;
    }
}
