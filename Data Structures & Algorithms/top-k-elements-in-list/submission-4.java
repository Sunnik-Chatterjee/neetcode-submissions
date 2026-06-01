class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i:nums){
            freqMap.put(i,freqMap.getOrDefault(i,0)+1);
        }
        int n = nums.length;
        List<Integer>[] bucket = new List[n+1];
        for(int key : freqMap.keySet()){
            int freq = freqMap.get(key);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int index = 0;
        int[] ans = new int[k];
        for(int i=n;i>=0 && index<k;i--){
            if(bucket[i]!=null){
                for(int j=0;j<bucket[i].size();j++){
                    ans[index++]=bucket[i].get(j);
                    if(index==k) break;
                }
            }
        }
        return ans;
    }
}
