class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int j =0;
        Deque<Integer> q = new LinkedList<>();
        int size = nums.length-k+1;
        int[] ans=new int[size]; 
        for(int i=0;i<nums.length;i++){
            while(!q.isEmpty() && nums[q.getLast()]<nums[i]) q.removeLast();
            q.addLast(i);
            if(i-j+1==k){
                ans[j]=nums[q.getFirst()];
                j++;
                if(j>q.getFirst()) q.removeFirst();
            } 
        }
        return ans;
    }
}
