class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Stack<Integer> courses = new Stack();
        int[] status = new int[numCourses];
        int[] ans = new int[numCourses];
        Map<Integer, Set<Integer>> adj = new HashMap();
        
        for(int i =0 ; i< prerequisites.length ; i++){
            if(adj.containsKey(prerequisites[i][1])){
                adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }else{
                Set<Integer> adn = new HashSet();
                adn.add(prerequisites[i][0]);
                adj.put(prerequisites[i][1],adn);
            }
        }
        
        for(int i = 0; i < numCourses; i++){
            if(!adj.containsKey(i)){
                Set<Integer> adn = new HashSet();
                adj.put(i,adn);
            }
        }
        
        for(Map.Entry<Integer, Set<Integer>> val: adj.entrySet()){
            if(!DFS(courses , adj , val.getKey(), val.getValue() , status)) return new int[0];
        }
        int j = 0;
        while(!courses.isEmpty()){
            ans[j++] = courses.pop();
        }
        
        return ans;
    }
    
    public boolean DFS(Stack<Integer> courses, 
                    Map<Integer, Set<Integer>> adj,Integer 
                    key , Set<Integer> value,
                    int[] status ){
        if(status[key]==2){
            return true;
        }else if(status[key]==1){
            return false;
        }else{
            status[key] = 1;
        }
        if(value!=null && !value.isEmpty()){
            for(Integer node : value){
                if(!DFS(courses, adj, node, adj.get(node), status )) return false;
            }  
        }
        
        status[key] = 2;
        courses.add(key);
        return true; 
    }
}