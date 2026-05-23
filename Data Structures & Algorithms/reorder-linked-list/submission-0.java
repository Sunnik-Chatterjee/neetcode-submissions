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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //find the half using slow and fast pointer
        ListNode l2 = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(l2!=null){
            ListNode nextNode = l2.next;
            l2.next = prev;
            prev = l2;
            l2=nextNode;
        }
        l2=prev;
        ListNode l1 = head;
        while(l1!=null && l2!=null){
            ListNode nextL1 = l1.next;
            ListNode nextL2 = l2.next;
            l1.next = l2;
            l1=nextL1;
            l2.next=l1;
            l2=nextL2;
        }
    }
}
