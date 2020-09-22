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
 * Way to determine if there is a circular connection: we need to use slow and fast 
 * pointer and then it is used to increment and it equal 
 * then we know it is cyclic. Good logic
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slowNode = head;
        ListNode fastNode = head;
        
        while(fastNode!=null && fastNode.next!=null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            
            if (slowNode == fastNode){
                slowNode = head;
                while (slowNode != fastNode) {
                    slowNode = slowNode.next;
                    fastNode = fastNode.next;
                }
                return slowNode;
            }
        }
        return null;
    }
}