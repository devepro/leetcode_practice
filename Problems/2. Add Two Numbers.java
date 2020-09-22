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
        ListNode first = l1;
        ListNode second = l2;
        ListNode addition=null;
        ListNode lastNode =null;
        int carry = 0;
        while(null!=first || null!=second){
            int sum = ((first != null) ? first.val : 0)+((second != null) ? second.val : 0)+carry;
            carry = sum /10;
            ListNode current = new ListNode(sum%10);
            if(null==addition){
                addition = current;
                lastNode = current;
            }else{
                lastNode.next = current;
                lastNode = current;
            }            
            if (first != null) first = first.next;
            if (second != null) second = second.next;     
        }
        if(carry>0) lastNode.next = new ListNode(1);
        return addition;
    }
}