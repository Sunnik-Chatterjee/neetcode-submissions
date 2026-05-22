class TimeMap {
    Map<String,List<Pair<Integer,String>>> keyValue;
    public TimeMap() {
        keyValue = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyValue.computeIfAbsent(key,k->new ArrayList<>()).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!keyValue.containsKey(key)) return "";
        List<Pair<Integer,String>> timeStampedValues = keyValue.get(key);
        int l = 0,r=timeStampedValues.size()-1;
        String ans = "";
        while(l<=r){
            int mid = l+(r-l)/2;
            if(timeStampedValues.get(mid).getKey()<=timestamp){
                l = mid + 1;
                ans = timeStampedValues.get(mid).getValue();
            }else r= mid-1;
        }
        return ans;
    }
    private static class Pair<K,V>{
        private final K key;
        private final V value;
        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
    }
}
