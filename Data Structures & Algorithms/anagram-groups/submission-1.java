class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int [] count = new int[26];
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < str.length(); i++) {
               count[str.charAt(i)-'a']++;
            }
            for (int i=0;i<26;i++) {
                sb.append((char)i).append(count[i]);
            }
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList<>());
            }
            map.get(sb.toString()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
