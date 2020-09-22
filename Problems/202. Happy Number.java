class Solution {
    public boolean isHappy(int n) {
     
        Set<Integer> sums = new HashSet<>();
        while(n>1){
            int sum = 0;
            while(n>0){
                int a = n%10;
                n = n/10;
                sum = sum + a*a;
            }
            if(sums.contains(sum)){
                return false;
            }
            sums.add(sum);
            n = sum;
        }
        
        return true;
    }
    
}