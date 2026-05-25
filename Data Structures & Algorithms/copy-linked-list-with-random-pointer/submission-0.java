/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node dummy = new Node(0);
        Node l1 = head;
        Node l2 = new Node(l1.val);
        dummy.next=l2;
        l1=l1.next;
        HashMap<Node,Node> nodeDirectory = new HashMap<>();
        nodeDirectory.put(head,l2);
        //copy value and create a single linked list
        while(l1!=null){
            Node newNode = new Node(l1.val);
            l2.next = newNode;
            l2=l2.next;
            nodeDirectory.put(l1,l2);
            l1=l1.next;
        }
        l1 = head;
        l2 = dummy.next;
        while(l1!=null){
            if(l1.random!=null){
                if(nodeDirectory.containsKey(l1.random)){
                    l2.random = nodeDirectory.get(l1.random);
                }
            }
            l1=l1.next;
            l2=l2.next;
        }
        return dummy.next;    
    }
}