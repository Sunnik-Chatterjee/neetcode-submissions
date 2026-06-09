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
        HashMap<Node,Node> map = new HashMap<>();
        Node list1 = head;
        Node dummy = new Node(0);
        Node curr = dummy;
        while(list1!=null){
            Node newNode = new Node(list1.val);
            map.put(list1,newNode);
            curr.next=newNode;
            curr=curr.next;
            list1=list1.next;
        }
        list1=head;
        curr=dummy.next;
        while(list1!=null){
            curr.random = map.get(list1.random);
            curr=curr.next;
            list1=list1.next;
        }
        return dummy.next;
    }
}
