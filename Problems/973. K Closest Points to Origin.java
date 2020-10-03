/**
 * 
 * 
 * Time Complexity O(N+kLogN)
 * Space complexity O(N)
 */
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Integer[]> distance = new PriorityQueue<>( 
                                    (a ,b)-> ( ( (a[0]*a[0])+(a[1]*a[1]) ) 
                                              - ( (b[0]*b[0])+(b[1]*b[1]) ) ) );
        
        for(int[] pt: points){
            distance.add(new Integer[]{pt[0],pt[1]});
        }
        
        int[][] ans = new int[K][2];
        for(int i = 0; i< K; i++){
            Integer[] a = distance.poll();
            int[] b = new int[2];
            b[0] = a[0];
            b[1] = a[1];
            ans[i] = b;
        }
        return ans;
    }
}