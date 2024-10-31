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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = new ListNode(-1, head);
        ListNode p = ans;
        while(p.next!=null && p.next.next!=null){   // p是待删除节点的前一个节点
            if(p.next.val == p.next.next.val){    // 出现连续相等
                int x = p.next.val;
                while(p.next!=null && p.next.val==x){   // 直到出现不等值
                    p.next = p.next.next;
                }
            }
            else
                p = p.next;
        }
        return ans.next;
    }
}
