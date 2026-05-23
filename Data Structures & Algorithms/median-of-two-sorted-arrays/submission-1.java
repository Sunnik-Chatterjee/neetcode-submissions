class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] smaller = nums1.length<nums2.length?nums1:nums2;
        int[] larger = nums1.length<nums2.length?nums2:nums1;
        int totalLength = smaller.length+larger.length;
        int l=0,r=smaller.length;
        while(l<=r){
            int partitionX = l+(r-l)/2;
            int partitionY = (totalLength+1)/2-partitionX;
            int l1 = partitionX==0?Integer.MIN_VALUE:smaller[partitionX-1];
            int l2 = partitionY==0?Integer.MIN_VALUE:larger[partitionY-1];
            int r1 = partitionX==smaller.length?Integer.MAX_VALUE:smaller[partitionX];
            int r2 = partitionY==larger.length?Integer.MAX_VALUE:larger[partitionY];
            if(l1<=r2 && l2<=r1){
                if(totalLength%2==0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }else{
                    return Math.max(l1,l2);
                }
            }else if(l1>r2) r = partitionX-1;
            else l = partitionX+1;    
        }
        return 0.0;
    }
}
