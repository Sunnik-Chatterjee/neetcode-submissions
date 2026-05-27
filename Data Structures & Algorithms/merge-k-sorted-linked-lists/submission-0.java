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
    public ListNode mergeKLists(ListNode[] list) {
        if(list==null || list.length==0) return null;
        return divideAlgo(list,0,list.length-1);
    }
    private ListNode divideAlgo(ListNode[] list, int start, int end){
        if(start==end){
            return list[start];
        }
        if(start+1==end){
            return conquor(list[start],list[end]);
        }
        int mid = start + (end-start)/2;
        ListNode left = divideAlgo(list,start,mid);
        ListNode right = divideAlgo(list,mid+1,end);
        return conquor(left,right);
    }
    private ListNode conquor(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr.next = l1;
                l1=l1.next;
            }else{
                curr.next = l2;
                l2=l2.next;
            }
            curr=curr.next;
        }
        curr.next=(l1==null)?l2:l1;
        return dummy.next;
    } 
}
