class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i : nums){
            freqMap.put(i,freqMap.getOrDefault(i,0)+1);
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for(int i : freqMap.keySet()){
            int freq = freqMap.get(i);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(i);
        }
        int[] ans = new int[k];
        int index = 0;
        for(int i = nums.length;i>0 && index<k;i--){
            if(bucket[i]!=null){
                for(int j : bucket[i]){
                    ans[index++]=j;
                    if(index==k) break;
                }
            }
        }
        return ans; 
    }
}
