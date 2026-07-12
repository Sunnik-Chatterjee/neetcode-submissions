class MedianFinder {
    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> largeHeap;
    public MedianFinder() {
        smallHeap = new PriorityQueue<>(Collections.reverseOrder());
        largeHeap = new PriorityQueue<>();        
    }
    
    public void addNum(int num) {
        smallHeap.offer(num);
        if(smallHeap.size()-largeHeap.size()>1 || !largeHeap.isEmpty() && smallHeap.peek()>largeHeap.peek())
        largeHeap.offer(smallHeap.poll());
        if(largeHeap.size()-smallHeap.size()>1) smallHeap.offer(largeHeap.poll());
    }
    
    public double findMedian() {
        if(smallHeap.size()==largeHeap.size()) return (smallHeap.peek()+largeHeap.peek())/2.0;
        if(smallHeap.size()>largeHeap.size()) return smallHeap.peek();
        else return largeHeap.peek();
    }
}
