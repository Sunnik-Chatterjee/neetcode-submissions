class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0, j = 0;
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        for (i = 0; i < n; i++) {
            if(!q.isEmpty() && q.getFirst()<j) q.removeFirst(); 
            while (!q.isEmpty() && nums[q.getLast()] < nums[i]) q.removeLast();
            q.addLast(i);
            if (i - j + 1 == k) {
                ans[j] = nums[q.getFirst()];
                j++;
            }
        }
        return ans;
    }
}
