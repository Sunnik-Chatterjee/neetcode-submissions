class ListNode{
    int key;
    int val;
    ListNode next;
    ListNode prev;
    public ListNode(int key,int val){
        this.key=key;
        this.val=val;
        next=null;
        prev=null;
    }
    public ListNode(int key,int val,ListNode next,ListNode prev){
        this.key=key;
        this.val=val;
        this.next=next;
        this.prev=prev;
    }
    int getVal(){
        return this.val;
    }
    int getKey(){
        return this.key;
    }
}
class LRUCache {
    HashMap<Integer,ListNode> map;
    int capacity;
    ListNode left,right;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        this.left = new ListNode(Integer.MIN_VALUE,0);
        this.right = new ListNode(Integer.MAX_VALUE,0);
        left.next = right;
        right.prev=left;
    }
    private void addNode(ListNode node){
        ListNode prev = right.prev;
        prev.next = node;
        node.prev=prev;
        node.next=right;
        right.prev=node;
    }
    private void removeNode(ListNode node){
        ListNode prev = node.prev;
        prev.next=prev.next.next;
        prev.next.prev=prev;
    }
    public int get(int key) {
        int val=-1;
        if(map.containsKey(key)){
            val=map.get(key).getVal();
            removeNode(map.get(key));
            ListNode recent = new ListNode(key,val);
            addNode(recent);
            map.put(key,recent);
        }
        return val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            removeNode(map.get(key));
        }
        ListNode newNode = new ListNode(key,value);
        map.put(key,newNode);
        addNode(newNode);
        if(map.size()>capacity){
            map.remove(left.next.getKey());
            removeNode(left.next);
        }
    }
}
