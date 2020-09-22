class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ans = new ArrayList();
        int sum = Integer.MAX_VALUE;
        Map<String,Integer> map = new HashMap<>();
        if(list1.length>list2.length){
            for(int i = 0; i < list2.length ; i++){
                map.put(list2[i],i);
            }
            for(int i = 0; i < list1.length ; i++){
                if(map.containsKey(list1[i]) ){
                    int ind = map.get(list1[i])+i;
                    if(ind <= sum){
                        sum = ind;
                        ans.add(list1[i]);
                    }
                }
            } 
        }else{
           for(int i = 0; i < list1.length ; i++){
                map.put(list1[i],i);
            }
            for(int i = 0; i < list2.length ; i++){
                if(map.containsKey(list2[i]) ){
                    int ind = map.get(list2[i])+i;
                    if(ind <= sum){
                        sum = ind;
                        ans.add(list2[i]);
                    }
                }
            } 
        }
        return ans.toArray(new String[ans.size()]);
    }
}