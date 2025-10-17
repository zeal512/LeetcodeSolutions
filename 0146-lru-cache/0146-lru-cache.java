class Node{
    int key, value;
    Node next, prev;
    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
    Node(int key, int value, Node next, Node prev){
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
class LRUCache {
    int capacity;
    List<Node> list = new LinkedList<>();
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map.clear();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.isEmpty() && map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            insertNode(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            insertNode(node);
        }
        else{
            if(map.size() == capacity){
                Node temp = tail.prev;
                map.remove(temp.key);
                deleteNode(temp);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertNode(newNode);
        }
    }
    
    public void deleteNode(Node node){
        Node previous = node.prev;
        Node after = node.next;
        previous.next = after;
        after.prev = previous;
    }
    public void insertNode(Node node){
        Node nodeAfterHead = head.next;
        head.next = node;
        node.next = nodeAfterHead;
        node.prev = head;
        nodeAfterHead.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */