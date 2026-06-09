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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        return divide(lists,0,lists.length-1);
    }
    private ListNode divide(ListNode[] lists, int start,int end){
        if(start>end) return null;
        if(start==end) return lists[start];
        int mid = start+(end-start)/2;
        ListNode left = divide(lists,start,mid);
        ListNode right = divide(lists,mid+1,end);
        return conqur(left,right);

    }
    private ListNode conqur(ListNode list1, ListNode list2){
        ListNode dummy=new ListNode(0);
        ListNode curr = dummy;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                curr.next= list1;
                list1=list1.next;
            }else{
                curr.next=list2;
                list2=list2.next;
            }
            curr=curr.next;
        }
        curr.next=list1!=null?list1:list2;
        return dummy.next;
    }
}
