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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /**还可以优化空间,tail直接用原list的 */
        ListNode head = new ListNode(-1, null);
        ListNode tail = head;
        while(list1!=null && list2!=null){  // 与2.链表两数相加不同的是,那里由于进位必须运算,而这里可以直接把剩的复制过去
            tail.next = new ListNode(Math.min(list1.val, list2.val));
            tail = tail.next;
            if(list1.val<=list2.val)
                list1 = list1.next;
            else
                list2 = list2.next;
        }
        if(list1 != null)   
            tail.next = list1;
        if(list2 != null)
            tail.next = list2;
        return head.next;
    }
}
