class Solution {
    double pointCalculation(int point[]) {
        int x = point[0];
        int y = point[1];
        return Math.sqrt(x * x + y * y);
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> { return Double.compare(pointCalculation(b), pointCalculation(a)); });
        for(int[] point: points){
            pq.offer(point);
            while(pq.size()>k) pq.poll();
        }
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll();
        }
        return ans;
    }
}
