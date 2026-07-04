class Solution {
    public int lastStoneWeight(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num:nums) pq.offer(num);
        while(pq.size()>1){
            int h1 = pq.poll();
            int h2 = pq.poll();
            int h3 = h1-h2;
            if(h3>0) pq.offer(h3);
        }
        return pq.isEmpty()?0:pq.peek();
    }
}
