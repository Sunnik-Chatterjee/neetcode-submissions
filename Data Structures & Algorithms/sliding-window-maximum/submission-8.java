class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> q = new LinkedList<>();
        int j=0;
        for(int i=0;i<nums.length;i++){
            while(!q.isEmpty() && nums[q.getLast()]<nums[i]) q.removeLast();
            q.addLast(i);
            if(i-j==k-1){
                ans[j++]=nums[q.getFirst()];
                if(j>q.getFirst()) q.removeFirst();
            }
        }
        return ans;
    }
}
