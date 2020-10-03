/**
 * 
 * TIme complexity O(V+E) v - vertices and e - edges 
 * 
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> courses = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            courses.put(i, new HashSet<>());
        }
        
        for(int[] pre: prerequisites){
            courses.get(pre[0]).add(pre[1]);
        }
        
        int[] added = new int[numCourses];
        int[] inProgress = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            boolean ans = dfs(courses, i, added, inProgress);
            if(!ans){
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(Map<Integer, Set<Integer>> map, int start, int[] added, int[] inProgress) {
        if (added[start] == 1) return true;
        inProgress[start] = 1;
        Set<Integer> toTake = map.get(start);
        for (int next : toTake) {
            if (inProgress[next] == 1) return false;
            boolean ans = dfs(map, next, added, inProgress);
            if(!ans){
                return false;
            }
        }
        inProgress[start] = 0;
        added[start] = 1;
        return true;
    }
}