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
    public ListNode swapPairs(ListNode head) {
        if(head==null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        while(prev.next!=null){
            ListNode one = prev.next;
            ListNode two = prev.next.next;
            if(two==null) break;
            prev.next = two;
            prev = prev.next;
            ListNode next = prev.next;
            prev.next = one;
            prev = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }
}