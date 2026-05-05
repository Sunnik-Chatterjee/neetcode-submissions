class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqCount = new HashMap<>();
        for(int i:nums){
            freqCount.put(i,freqCount.getOrDefault(i,0)+1);
        }
        int n = nums.length;
        List<Integer>[] bucket = new ArrayList[n+1];
        for(int key : freqCount.keySet()){
            int freq = freqCount.get(key);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int[] ans = new int[k];
        int index =0;
        for(int i=n;i>=0 && index<k;i--){
            if(bucket[i]!=null){
                for(int j:bucket[i]){
                    ans[index++]=j;
                    if(index == k) break;
                }
            }
        }
        return ans;    
    }
}
