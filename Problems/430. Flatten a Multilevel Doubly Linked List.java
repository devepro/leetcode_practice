/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

Time Complexity O(n) --> need to discuss and verify
Space Complexity O(n) --> height of linked list as function called in recursion
*/

class Solution {
    public Node flatten(Node head) {
        Node p1 = head;
        if(head==null) {return null;}
        checkChild(head);
        return p1; 
    }
    
    public void checkChild(Node n){
        if(n.child!=null){
            Node temp = n.next;
            if(temp!=null){
               temp.prev = null;  
            }           
            n.child.prev = n;
            n.next = n.child;
            Node lastOfChild = lastNode(n.child);
            
            lastOfChild.next = temp;
            if(temp!=null){
              temp.prev = lastOfChild;
            }
            
            n.child = null;
            if(n.next!=null){
                checkChild(n.next);
            }       
        }else{
            if(n.next!=null){
                checkChild(n.next);
            }
        }    
    }
    public void joiner(Node lastNode, Node nextNode){  
        lastNode.next = nextNode;
    }
    
    public Node lastNode(Node n){
        Node last = n;
        while(last.next!=null){
            last = last.next;
        }
        return last;
    }
}