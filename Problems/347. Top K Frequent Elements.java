/**
 * 
 * 
 * Heap solution
 * 
 * Time complexity O(klogN)
 * Space Complexity O(N+k)
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        Map<Integer, Integer> freq = new HashMap();
        
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
        }
        
        Node[] nodes = new Node[freq.size()+1];
        int j = 1;
        for(Integer n: freq.keySet()){
            
            Node node = new Node(n, freq.get(n));
            nodes[j++]  = node;
        }
        
        int N = nodes.length;
        build_maxheap(nodes , N-1);
        
        int[] top = new int[k];
        int len = nodes.length-1;
        for(int i = 0 ; i < k; i++){
            System.out.println(i);
            top[i] = nodes[1].num;
            deleteMax(nodes,len);
            len--;
        }
           
        return top;
    }
    
    public void build_maxheap (Node[] Arr, int N){
        for(int i = N/2 ; i >= 1 ; i-- ){
            heapify (Arr, i , N);
        }
    }
    
    public void deleteMax(Node[] arr,int len){
        arr[1] = arr[len];
        heapify(arr, 1 , len-1);
    }
    
    public void heapify(Node[] arr, int i, int N){
        int left = 2*i;                   //left child
        int right = 2*i +1;               //Right child
        int largest = i;
        if(left <= N && arr[left].freq > arr[i].freq  ){
            largest = left;
        }
        if (right <=N && arr[right].freq > arr[largest].freq ){
            largest = right;
        }
        
        if(largest != i){
             Node temp = arr[i]; 
             arr[i] = arr[largest];
             arr[largest] = temp;
             heapify(arr , largest , N);
        }

    }
    
    public class Node{
        int freq,num;
        Node(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
}