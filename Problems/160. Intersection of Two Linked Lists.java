/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * The intersection comes when both the pointers are equal and if no intersection then last node is null.
 * Good approach
 * 
 * Time complexity O(m+n)
 * Space complexity O(1)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1!=p2){
            p1 = p1!=null?p1.next: headB;
            p2 = p2!=null?p2.next: headA;
        }
        return p1;
    }
}