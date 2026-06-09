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
    private ListNode reverseList(ListNode head){
        if(head==null) return null;
        ListNode prev=null, curr=head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode dummy1=new ListNode(0,head);
        ListNode slow = dummy1, fast = dummy1;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next=null;
        head2=reverseList(head2);
        ListNode dummy=new ListNode(0);
        ListNode curr = dummy;
        boolean straight = true;
        while(head!=null && head2!=null){
            if(straight){
                curr.next = head;
                head=head.next;
                straight=false;
            }else{
                curr.next=head2;
                head2=head2.next;
                straight=true;
            }
            curr=curr.next;
        }
        curr.next=head!=null?head:head2;
    }
}
