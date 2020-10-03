/**
 * Using priority queue
 * max heap is created
 * Time complexity O(klogn)
 * 
 * min heap is created
 * Time complexity O(nlogk)
 * 
 * Using Quick Select algo
 * O(n) average case O(n^2) in worst case
 * 
 * 
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b - a)) ;
        
        for(int number : nums ){
            maxHeap.add(number);
        }
        
        while(k>1){
            maxHeap.poll();
            k--;
        }
        
        return maxHeap.poll();
    }
}
/**
 * 
 * QuickSelect solution
 * 
 * class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSelect(0, nums.length-1 , k-1 , nums );
        return nums[k-1];
    }
    
    public void quickSelect(int left, int right, int k , int[] arr){
        if(left==right) return;
        
        Random random = new Random();
        int pivot = left + random.nextInt(right-left);
        
        pivot = partition(left, right, pivot, arr);
        
        if(pivot==k){
            return;
        }else if(pivot > k){
            // go left
            quickSelect(left, pivot-1, k, arr);
        }else if(pivot < k){
            //go right
            quickSelect(pivot+1, right, k, arr);
        }
    }
    
    public int partition(int left, int right, int pivot, int[] arr){
        swap(arr , right, pivot);
        
        int store_index = left;
            
        while(left<=right){
            if(arr[left] >= arr[right]){
                swap(arr, store_index, left);
                store_index++;
            }
            left++;
        }
        store_index--;
        return store_index;
    }
    
    public void swap(int[] arr, int index1 , int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
 */