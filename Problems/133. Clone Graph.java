/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        Map<Node,Node> visited = new HashMap();
        
        Node ans = new Node(node.val);
        Queue<Node> queue = new LinkedList(); 
        queue.add(node);
        visited.put(node, ans);
    
        while(!queue.isEmpty()){
            for(int i = 0; i< queue.size();i++){
                Node curr1 = queue.poll();
                ArrayList<Node> newNeighbors = new ArrayList();
                if(curr1.neighbors!=null && !curr1.neighbors.isEmpty()){
                   
                   for(Node nod : curr1.neighbors){
                        
                       if(!visited.containsKey(nod)){
                            Node n = new Node(nod.val);
                            newNeighbors.add(n);
                            queue.add(nod);
                            visited.put(nod, n);
                       }else{
                           newNeighbors.add(visited.get(nod));
                       }
                    } 
                  
                }
                visited.get(curr1).neighbors = newNeighbors;
            }
        }
        
        return visited.get(node);
    }
}