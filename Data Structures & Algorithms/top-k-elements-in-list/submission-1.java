class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int size = nums.length;
        List<Integer>[] bucket = new ArrayList[size+1];
        Map<Integer,Integer> count = new HashMap<>();
        for(int i:nums){
            count.put(i,count.getOrDefault(i,0)+1);
        }
        for(int key:count.keySet()){
            int freq = count.get(key);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int[] ans = new int[k];
        int index = 0;
        for(int i = bucket.length-1;i>=0 && index<k;i--){
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
