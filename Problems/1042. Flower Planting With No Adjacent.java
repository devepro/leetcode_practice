/**
 * 
 * Time Complexity O(E+N)
 */
class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer,List<Integer>> adj = new HashMap();
        int[] ans = new int[N]; 
        for(int i = 0; i<paths.length ; i++){
            if(adj.containsKey(paths[i][0])){
                adj.get(paths[i][0]).add(paths[i][1]);
            }else{
                List<Integer> adjNodes = new ArrayList();
                adjNodes.add(paths[i][1]);
                adj.put(paths[i][0],adjNodes);
            }
            
            if(adj.containsKey(paths[i][1])){
                adj.get(paths[i][1]).add(paths[i][0]);
            }else{
                List<Integer> adjNodes = new ArrayList();
                adjNodes.add(paths[i][0]);
                adj.put(paths[i][1],adjNodes);
            }
        }
        
        for(int i = 1; i<= N;i++ ){
            Set<Integer> color = new HashSet();
            List<Integer> adjNodes = adj.get(i)!=null?adj.get(i):new ArrayList<Integer>();
            for(Integer node: adjNodes ){
                if(ans[node-1]!=0){
                    color.add(ans[node-1]);
                }
            }
            ans[i-1] = chooseColor(color);
        }
        
        return ans;
    }
    
    public int chooseColor(Set<Integer> color){
        for(int i=1;i<=4; i++){
            if(!color.contains(i)){
                return i;
            }
        }
        return 1;
    }
}