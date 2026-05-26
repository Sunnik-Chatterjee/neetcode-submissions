class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }
        List<Integer>[] arr = new ArrayList[nums.length+1];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (arr[freq] == null) {
                arr[freq] = new ArrayList<>();
            }
            arr[freq].add(key);
        }
        int index = 0;
        for (int i = nums.length; i >= 0 && index<k; i--) {
            if (arr[i] != null) {
                for (int j : arr[i]) {
                    ans[index++]=j;
                    if(index==k) break;
                }
            }
        }
        return ans;
    }
}
