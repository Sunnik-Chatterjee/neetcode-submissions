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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode sumPt = dummy;
        ListNode pt1 = l1, pt2 = l2;
        int carry = 0;
        while(l1!=null && l2!=null){
            int sum = l1.val + l2.val + carry;
            carry = sum/10;
            int digit = sum%10;
            ListNode newNode = new ListNode(digit);
            sumPt.next = newNode;
            sumPt = newNode;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int sum = l1.val+carry;
            int digit = sum%10;
            carry=sum/10;
            ListNode newNode = new ListNode(digit);
            sumPt.next = newNode;
            sumPt=newNode;
            l1=l1.next;
        }
        while(l2!=null){
            int sum = l2.val+carry;
            int digit = sum%10;
            carry=sum/10;
            ListNode newNode = new ListNode(digit);
            sumPt.next = newNode;
            sumPt=newNode;
            l2=l2.next;
        }
        if(carry!=0){
            ListNode newNode = new ListNode(carry);
            sumPt.next = newNode;
        }
        return dummy.next;
    }
}
