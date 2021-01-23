/**
 * 
 * Time complexity get -> O(1) put -> O(1)
 * Space complexity Ok)
 */
class LRUCache {
    class Node {
        Node prev;
        Node next;
        int value;
        int key;
        
        void Node(Node prev, Node next, int key, int value){
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }
    
    
    private HashMap<Integer, Node> map;
    private int len;
    private int capacity;
    private Node rear;
    private Node front;
    
    public LRUCache(int capacity) {
        this.len = 0;
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            if(curr==front){
                //printget(key);
               return curr.value;
            }
            if(curr==rear){
               rear = rear.next;
               curr.next=null;
               curr.prev = front;
               front.next = curr;
               front = curr;
                 //printget(key);
               return curr.value;
            }
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            curr.prev = front;
            front.next = curr;
            curr.next = null;
            front = curr;
             //printget(key);
            return curr.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node present = map.get(key);
            
            if(present==rear && present==front){
                rear =null;
                front=null;
            }else{
               if(present==rear){
                    rear = rear.next;
                    rear.prev = null;
                    present.next =null;
                }else if(present == front){
                    front = front.prev;
                    front.next = null;
                    present.prev = null;
                }else{
                    present.prev.next = present.next;
                    present.next.prev = present.prev;
                    present.next= null;
                    present.prev= null;
                } 
            }
            
            map.remove(key);
            len--;
        }
        if(len < capacity){
            Node node = new Node();
            node.key = key;
            node.value = value;
            if(front==null && rear ==null){
                front = node;
                rear = node;
            }else{
                node.prev = front;
                front.next = node;
                front = node;
            }
            map.put(key, node);
            len++;
            //print(key);
        }else{
            map.remove(rear.key);
            Node node = new Node();
            node.key = key;
            node.value = value;
            node.prev = front;
            front.next = node;
            front = node;
            rear = rear.next;
            rear.prev = null;
            map.put(key, node);
            //print(key);
        }
    }
    
    public void print(int key){
        Node temp = rear;
        while(temp!=null){
            System.out.println("put "+key+" "+temp.key);
            temp = temp.next;
        }
    }
    
    public void printget(int key){
        Node temp = rear;
        while(temp!=null){
            System.out.println("get "+key+" "+temp.key);
            temp = temp.next;
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */