/**
 * 
 */
package recursion;

/**
 * @author fSociety
 *
 */
public class mergeSortedList {
	/*
	 * In this problem, we will use recursion using two list to make the one single list.
	 * Leetcode problem 21
	 */
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = recursive(list1, list2);//recursive call
        return ans;
    }

	private ListNode recursive(ListNode list1, ListNode list2) {
		// TODO Auto-generated method stub
		ListNode node = null;
		if(list1 == null) {//boundary condition
			return list2;
		}
		else if(list2 == null) {
			return list1;//boundary condition
		}
		else {
			if(list1.val <= list2.val) {
				node = list1;
				list1 = list1.next;
				node.next = recursive(list1, list2);
			}
			else {
				node = list2;
				list2 = list2.next;
				node.next = recursive(list1, list2);
			}
		}
		return node;
	}
}

class ListNode {
	int val;
	 ListNode next;
	 ListNode() {}
	 ListNode(int val) { this.val = val; }
	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
