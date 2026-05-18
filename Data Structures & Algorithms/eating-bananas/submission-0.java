class Solution {
    boolean canCompletePiles(int[] piles, int n, int h){
        int hour = 0;
        for(int i = 0;i<piles.length;i++){
            hour+=(piles[i]+n-1)/n;
        }
        return hour<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxNo = Integer.MIN_VALUE;
        for(int i:piles){
            if(i>maxNo) maxNo = i;
        }
        int l = 1, r = maxNo;
        int minSpeed = Integer.MAX_VALUE;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(canCompletePiles(piles,mid,h)){
                minSpeed = Math.min(minSpeed, mid);
                r=mid-1;
            }else{
                l = mid + 1;
            }
        }
        return minSpeed;
    }
}
