/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 
 * Time Complexity O(n)
 * Space Complexity O(1)
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        while(p1!=null && p2!=null){
            if(p1.val > p2.val){
                ListNode temp = p2.next;
                p2.next = null;
                dummy.next = p2;
                dummy = dummy.next;
                p2 = temp;
            }else{
                ListNode temp = p1.next;
                p1.next = null;
                dummy.next = p1;
                dummy = dummy.next;
                p1 = temp;
            }
        }
        
        if(p1!=null){
            dummy.next = p1;
        }
        if(p2!=null){
            dummy.next = p2;
        }
        return head.next;
    }
}