package single_linked_list;


//single_linked_list
public class Ex6_1 {

	public static void main(String[] args) {
		LinkedList L = new LinkedList();
		System.out.println("(1) insert 3 nodes in the empty list");
		L.insertLastNode("mon");
		L.insertLastNode("wed");
		L.insertLastNode("sun");
		L.printList();
		
		System.out.println("(2) insert fri node behind wed");
		ListNode pre = L.searchNode("wed");
		if(pre == null) {
			System.out.println("no data");
		}else {
			L.insertMiddleNode(pre, "fri");
			L.printList();
		}
		
		System.out.println("(3) reverse list");
		L.reverseList();
		L.printList();
		
		System.out.println("(4) delete last node");
		L.deleteLastNode();
		L.printList();
	}
	

}

class LinkedList{
	private ListNode head;
	public LinkedList() {
		head = null;
	}
	
	public void insertMiddleNode(ListNode pre, String data) {
		ListNode newNode = new ListNode(data);
		newNode.link = pre.link;
		pre.link = newNode;
	}
	
	public void insertLastNode(String data) {
		ListNode newNode = new ListNode(data);
		if(head == null) {
			this.head = newNode;
		}else {
			ListNode temp = head;
			while(temp.link != null) temp = temp.link;
			temp.link = newNode;
		}
	}
	
	public void deleteLastNode() {
		ListNode pre, temp;
		if(head == null) return;
		if(head.link == null) {
			head = null;
		}else {
			pre = head;
			temp = head.link;
			while(temp.link != null) {
				pre = temp;
				temp = temp.link;
			}
			pre.link = null;
		}
	}
	
	public ListNode searchNode(String data) {
		ListNode temp = this.head;
		while(temp != null) {
			if(data == temp.getData())
				return temp;
			else temp = temp.link;
		}
		return temp;
	}
	
	public void reverseList() {
		ListNode next = head;
		ListNode current = null;
		ListNode pre = null;
		while(next != null) {
			pre = current;
			current = next;
			next = next.link;
			current.link = pre;
		}
		head = current;
	}
	
	public void printList() {
		ListNode temp = this.head;
		System.out.printf("L = (");
		while(temp != null) {
			System.out.printf(temp.getData());
			temp = temp.link;
			if(temp != null) {
				System.out.printf(", ");
			}
		}
		System.out.println(")");
	}
}


//linkedList and Node class
class ListNode{
	private String data;
	public ListNode link;
	public ListNode() {
		this.data = null;
		this.link = null;
	}
	
	public ListNode(String data) {
		this.data = data;
		this.link = null;
	}
	
	public ListNode(String data, ListNode link) {
		this.data = data;
		this.link = link;
	}
	
	public String getData() {
		return this.data;
	}
}
