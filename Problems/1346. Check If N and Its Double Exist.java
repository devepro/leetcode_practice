class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> a = new HashSet<>();
        for(int num : arr){
            if( a.contains(num*2) || (num%2 ==0 && a.contains(num/2) ) ){
                return true;
            }else{
                a.add(num);
            }
        }
        return false;     
    }
}