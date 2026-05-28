class Node {
    int key;
    int value;
    Node next;
    Node prev;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
    int getValue() {
        return this.value;
    }
    int getKey() {
        return this.key;
    }
}
class LRUCache {
    HashMap<Integer, Node> map;
    int capacity;
    Node left;
    Node right;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    private void addNode(Node node) {
        Node prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }
    private void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        deleteNode(node);
        addNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key))
            deleteNode(map.get(key));
        Node node = new Node(key, value);
        map.put(key, node);
        addNode(node);
        if (map.size() > capacity) {
            Node lru = left.next;
            map.remove(lru.key);
            deleteNode(lru);
        }
    }
}
