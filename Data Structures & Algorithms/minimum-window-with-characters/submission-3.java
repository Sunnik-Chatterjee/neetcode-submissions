class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            count2.put(t.charAt(i), count2.getOrDefault(t.charAt(i), 0) + 1);
        }
        int have = 0, need = count2.size();
        int l = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        for (int r = 0; r < s.length(); r++) {
            count1.put(s.charAt(r), count1.getOrDefault(s.charAt(r), 0) + 1);
            if (count2.containsKey(s.charAt(r))
                && count2.get(s.charAt(r)).equals(count1.get(s.charAt(r))))
                have++;
            while (have == need) {
                if ((r - l) + 1 < minLen) {
                    minLen = r - l + 1;
                    startIndex = l;
                }
                count1.put(s.charAt(l), count1.getOrDefault(s.charAt(l), 0) - 1);
                if (count2.containsKey(s.charAt(l))
                    && count1.get(s.charAt(l)) < count2.get(s.charAt(l)))
                    have--;
                l++;
            }
        }
        if (minLen == Integer.MAX_VALUE)
            return "";
        return s.substring(startIndex, startIndex + minLen);
    }
}
