/**
 * 
 */
package array;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author fSociety
 *
 */
public class MergeKSortedLists {
	/*
	 * Leetcode 23
	 * In this example, we will use Min Heap to create Min heap of Nodes and then take top element from heap.
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pq=
                new PriorityQueue<ListNode>(5,(a,b) -> a.val - b.val);
		
		for(int i = 0; i < lists.length; i++) {
			ListNode head = lists[i];
			while(head != null) {
				ListNode tmp = head;
				head = head.next;
				tmp.next = null;
				pq.add(tmp);
			}
		}
		
		ListNode ans = null;
		ListNode tmp = ans;
		while(!pq.isEmpty()) {
			if(ans == null) {
				ans = pq.poll();
				tmp = ans;
				
			}
			else {
				tmp.next = pq.poll();
				tmp = tmp.next;
			}
			tmp.next = null;
		}
		
		return ans;
    }
	
	
	/*
	 * Below , we will use recursion to create sorted list because we make use information of sorted singular lists.
	 */
	public ListNode mergeKLisBestSolutionRecursion(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeKLists(ListNode[] lists, int start, int end){
        if(start > end) return null;
        
        if(start == end) return lists[start];
        
        if(end == start + 1){
            return mergeTwoLists(lists[start], lists[end]);
        }
        
        int mid = start + (end - start) / 2;
        
        ListNode l = mergeKLists(lists, start, mid);
        ListNode r = mergeKLists(lists, mid + 1, end);
        
        return mergeTwoLists(l, r);
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
