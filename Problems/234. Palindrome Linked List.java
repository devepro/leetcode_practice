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
    public boolean isPalindrome(ListNode head) {
        
        if( head!=null && head.next == null){
            return true;
        }
        if(head ==null) return true;
        if( head!=null && head.next != null && head.next.next==null) { 
            if(head.val == head.next.val){
                return true;
            }else{
                return false;
            }
        }
        ListNode p1 = head;
        ListNode p2 = head;
       
       //find the mid 
        while (p2.next !=null && p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        ListNode list1 = p1.next;
        
        //Reverse The first half
        ListNode curr = head;
        ListNode prev = null;
        p1.next = null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        ListNode list2 = null;
        if(p2.next==null){
            list2 = prev.next;
        }else{
            list2 = prev; 
        }

        //Compare the two lists
        while(list1!=null && list2!=null){
            if(list1.val!=list2.val){
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        
        return true;
    }
}