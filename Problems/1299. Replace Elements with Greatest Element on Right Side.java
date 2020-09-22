class Solution {
    /**
     * 
     * Trick is to start from the end 
     * Time complexity O(n)
     */
    public int[] replaceElements(int[] arr) {
        int greatest = -1;
        for(int i=arr.length-1; i>=0 ; i--){
            int num = arr[i];
            arr[i] = greatest;
            if(num> greatest){
                greatest = num;
            }
        }
        return arr;
    }
}