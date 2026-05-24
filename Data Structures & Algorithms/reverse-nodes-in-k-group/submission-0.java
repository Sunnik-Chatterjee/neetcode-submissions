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
        ListNode prevGroup = dummy;
        while(true){
            ListNode kth = getKthNode(prevGroup,k);
            if(kth==null) break;
            ListNode nextGroup = kth.next;
            ListNode prev = kth.next;
            ListNode curr = prevGroup.next;
            while(curr!=nextGroup){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            ListNode temp = prevGroup.next;
            prevGroup.next=kth;
            prevGroup = temp;//always making sure prevgroup pointer pointer at the edge of the prevous group
        }
        return dummy.next;
    }
    private ListNode getKthNode(ListNode curr, int k){
        while(k>0 && curr!=null){
            k--;
            curr=curr.next;
        }
        return curr;
    }
}
