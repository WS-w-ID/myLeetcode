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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int currVal=(l1.val+l2.val)%10, preVal=(l1.val+l2.val)/10, sum=0;
        ListNode tail = new ListNode(currVal, null);
        ListNode head = new ListNode(-1, tail);
        l1 = l1.next;
        l2 = l2.next;
        while(l1!=null && l2!=null){    // 也可以补0，就不用单独判断哪个遍历完了
            sum = l1.val+l2.val+preVal;
            tail.next = new ListNode(sum%10, null);;
            tail = tail.next;
            preVal = sum/10;

            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            sum = l1.val+preVal;
            tail.next = new ListNode(sum%10, null);;
            tail = tail.next;
            preVal = sum/10;

            l1 = l1.next;
        }
        while(l2 != null){
            sum = l2.val+preVal;
            tail.next = new ListNode(sum%10, null);;
            tail = tail.next;
            preVal = sum/10;

            l2 = l2.next;
        }
        if(preVal != 0){
            tail.next = new ListNode(preVal, null);;
        }
        return head.next;
    }
}
