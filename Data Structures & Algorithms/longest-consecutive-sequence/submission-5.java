class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int longestLen = 0;
        for (int i : nums) {
            set.add(i);
        }
        for (int i : nums) {
            if (!set.contains(i - 1)) {
                int curr = 1;
                int num = i;
                while (set.contains(num + 1)) {
                    curr++;
                    num++;
                }
                longestLen = Math.max(curr, longestLen);
            }
        }
        return longestLen;
    }
}
