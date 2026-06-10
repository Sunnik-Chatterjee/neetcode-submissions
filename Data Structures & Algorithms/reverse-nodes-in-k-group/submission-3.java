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
    private ListNode getKthNode(ListNode head,int k){
        while(k>0 && head!=null){
            head=head.next;
            k--;
        }
        return head;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        ListNode prevGroup = dummy;
        while(true){
            ListNode kth = getKthNode(prevGroup,k);
            if(kth==null) break;
            ListNode nextGroup = kth.next;
            ListNode prev=nextGroup;
            ListNode curr=prevGroup.next;
            while(curr!=nextGroup){
                ListNode nextNode = curr.next;
                curr.next=prev;
                prev=curr;
                curr=nextNode;
            }
            ListNode lastEle = prevGroup.next;
            prevGroup.next=prev;
            prevGroup=lastEle;
        }
        return dummy.next;
    }
}
