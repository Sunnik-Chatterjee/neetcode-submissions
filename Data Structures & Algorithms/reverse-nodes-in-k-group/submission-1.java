/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        ListNode prevGroup=dummy;
        while(true){
            ListNode kth = getKthElement(prevGroup,k);
            if(kth == null) break;
            ListNode nextGroup = kth.next;
            ListNode prev = kth.next;
            ListNode curr = prevGroup.next;
            while(curr!=nextGroup){
                ListNode nextNode = curr.next;
                curr.next=prev;
                prev = curr;
                curr = nextNode;
            }
            ListNode temp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = temp;
        }
        return dummy.next;
    }
    private ListNode getKthElement(ListNode curr,int k){
        while(k>0){
            k--;
            curr=curr.next;
            if(curr==null) break;
        }
        return curr;
    }
}
