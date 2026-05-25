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
        Node l1 = head;
        while (l1 != null) {
            Node newNode = new Node(l1.val);
            newNode.next = l1.next;
            l1.next = newNode;
            l1=newNode.next;
        }
        l1 = head;
        while(l1!=null){
            if(l1.random!=null){
                l1.next.random = l1.random.next;
            }
            l1=l1.next.next;
        }
        l1 = head;
        Node l2 = l1.next;
        Node dummy = new Node(0);
        dummy.next = l2;
        while(l1!=null){
            if(l2.next == null){
                l1.next = null;
                break;
            }
            l1.next = l2.next;
            l1=l1.next;
            l2.next = l1.next;
            l2=l2.next;
        }
        return dummy.next;
    }
}
