class MedianFinder {
    /** initialize your data structure here. */
    public PriorityQueue<Integer> minHeap;
    public PriorityQueue<Integer> maxHeap;
    public int minSize;
    public int maxSize;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minSize = 0;
        maxSize = 0;
    }
    
    public void addNum(int num) {
        if(minSize == 0) {
            minHeap.offer(num);
            minSize ++;
            return;
        }
        
        if(num < minHeap.peek()){
            maxHeap.offer(num);
            maxSize ++;
        }else{
            minHeap.offer(num);
            minSize ++;
        }
        
        if(Math.abs(maxSize - minSize) <= 1)
            return;
        if(maxSize > minSize) {
            int temp = maxHeap.poll();
            minHeap.offer(temp);
            maxSize --;
            minSize ++;
        } else {
            int temp = minHeap.poll();
            maxHeap.offer(temp);
            minSize --;
            maxSize ++;
        }
    }
    
    public double findMedian() {
         if(minSize == maxSize)
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        else if(minSize > maxSize)
            return minHeap.peek();
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */