import java.util.Stack;

public class Solution_206_ReveseLinkedList {
	
	
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	 
	
    public ListNode reverseList(ListNode head) {
    	Stack<ListNode> stk = new Stack<>();
    	ListNode pt = head;
    	stk.push(head);
    	while (head != null && pt.next != null) {
    		pt= pt.next;
    		stk.push(pt);
    	}
    	
    	head = stk.pop();
    	pt = head;
    	while (!stk.isEmpty()) {
    		pt.next = stk.pop();
    		pt = pt.next;
    	}
    	pt.next = null;
    	
    	
    	
    	return head; 
    }
    
}
