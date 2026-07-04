class KthLargest {
    private int k;
    private PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.pq = new PriorityQueue<>();
        for(int i : nums) pq.offer(i);
        while(pq.size()>k) pq.poll();
    }
    
    public int add(int val) {
        this.pq.offer(val);
        while(pq.size()>k) pq.poll();
        return pq.peek();
    }
}
