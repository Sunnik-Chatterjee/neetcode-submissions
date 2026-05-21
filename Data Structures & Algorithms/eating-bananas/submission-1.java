class Solution {
    boolean canPilesComplete(int[] piles, int h, int rate) {
        int totalHours = 0;
        for (int i : piles) {
            totalHours += (i + rate - 1) / rate;
        }
        return totalHours <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxi = Integer.MIN_VALUE;
        for (int i : piles) {
            if (i > maxi)
                maxi = i;
        }
        int l = 1, r = maxi;
        int minRate = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canPilesComplete(piles, h, mid)) {
                r = mid - 1;
                minRate = mid;
            } else
                l = mid + 1;
        }
        return minRate;
    }
}
