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
 * Time complexity O(n)
 * Space Complexity O(1)
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode p1 = head;
        ListNode last = head;
        int length = 0;
        int pos = 0;
        while(p1!=null){
            last = p1;
            p1 = p1.next;
            length++;
        }
        if(k%length==0) return head;
        p1 = head;
        pos = length - (k%length);
        pos = pos -1;
        while(pos>0){
            p1 = p1.next;
            pos--;
        }
        last.next = head;
        head = p1.next;
        p1.next = null;
        return head;
    }
}