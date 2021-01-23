/**
 * 
 * Time complexity O(K LogN)
 * Space Complexity O(N)
 */
class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word, map.getOrDefault(word ,0 )+1);
        }
        
        PriorityQueue<String> queue = new PriorityQueue<>((s1,s2) -> 
                                                          map.get(s1)==map.get(s2) ?
                                                          s1.compareTo(s2) :
                                                          map.get(s2) - map.get(s1)) ;
        for(String word : map.keySet()){
            queue.offer(word);
        }
        
        List<String> ans = new ArrayList();
        
        for(int i = 0; i <k ; i++){
            ans.add(queue.poll());
        }
        
        return ans;
    }
}