import java.util.*;

public class LinkList {
	Node head;

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
		}
	}

	LinkList insertNode(LinkList list, int num) {
		Node a = new Node(num);
		a.next = null;
		if (list.head == null) {
			list.head = a;

		} else {
			Node start = head;
			while (start.next != null) {
				start = start.next;
			}
			start.next = a;
		}
		return list;
	}

	void deleteNode(LinkList list, int num) {
		if (list.head.data == num) {
			list.head = list.head.next;
		} else {
			Node start = list.head;
			while (start != null) {
				if (start.next.data == num) {
					start.next = start.next.next;
					break;
				}
				start = start.next;
			}
		}
	}

	public static boolean detectLoop(Node head) {
		ArrayList<Node> a = new ArrayList<Node>();
		a.add(head);
		Node start = head.next;
		while (start != null) {
			if (a.contains(start)) {
				return true;
			} else {
				a.add(start);
			}
			start = start.next;
		}
		return false;
	}

	public static void removeLoop(Node head) {
		HashSet<Node> a = new HashSet<Node>();
		a.add(head);
		Node start = head;
		while (start != null) {
			if (a.contains(start.next)) {
				start.next = null;
				break;
			} else {
				a.add(start.next);
			}
			start = start.next;
		}
	}

	int getMiddle(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	Node reverseList(Node head) {
		Node start = head;
		Node next = null;
		Node prev = null;
		if (start == null || start.next == null)
			return head;
		while (start != null) {
			next = start.next;
			start.next = prev;
			prev = start;
			start = next;
		}

		return prev;
	}

	int getNthFromLast(Node head, int n) {
		Node slow = head;
		Node fast = head;
		int k = 0;
		while (k < n) {
			if (fast == null)
				return -1;

			fast = fast.next;
			k++;

		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow.data;
	}

	boolean isPalindrome(Node head) {
		if (head == null)
			return false;
		if (head.next == null)
			return true;
		Node fast_pointer = head;
		Node slow_pointer = head;
		Stack<Integer> half_stack = new Stack<Integer>();
		while (fast_pointer != null) {
			half_stack.push(fast_pointer.data);
			fast_pointer = fast_pointer.next;
		}
		while (slow_pointer != null) {
			if (slow_pointer.data != half_stack.pop())
				return false;
			slow_pointer = slow_pointer.next;
		}

		return true;

	}

	int intersectPoint(Node head1, Node head2) {
		HashSet<Node> sample = new HashSet<Node>();
		if (head1 == null || head2 == null)
			return -1;
		while (head1 != null) {
			sample.add(head1);
			head1 = head1.next;
		}
		while (head2 != null) {
			if (sample.contains(head2)) {
				return head2.data;
			}
		}

		return -1;
	}

	void deleteNodeWithoutHead(Node node) /* Function to delete without head pointer. creates duplicate next nodes */
	{
		node.data = node.next.data;
		node.next = node.next.next;
	}

	public Node rotate(Node head, int k) {

		if (head == null || head.next == null || k == 0)
			return head;
		Node new_start = null, new_end = null;
		Node old_head = head;
		int length = getLength(head);
		k = k % length; /* if count is greater than the length */

		if (k == 0)
			return head;
		int count = 1;
		while (count < k && head != null) {
			count++;
			head = head.next;
		}
		if (head == null || head.next == null)
			return old_head;

		new_end = head;
		new_start = head.next;
		while (head.next != null) {
			head = head.next;
		}
		head.next = old_head;
		new_end.next = null;
		return new_start;
	}

	public int getLength(Node head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}

	int isLengthEvenorOdd(Node head1) {
		if (getLength(head1) % 2 == 0)
			return 1;
		else
			return 0;
	}

	// Adding two lists represented as Numbers
	/*
	 * 1 -> 2 -> 3 1st list 4 -> 5 -> 7 2nd list On reversing 3 -> 2 -> 1 7 -> 5 ->
	 * 4 Adding 0 -> 8 -> 5 On reversing 5 -> 8 -> 0
	 */
	Node addLists(Node first, Node second) {
		if (first == null)
			return second;
		if (second == null)
			return first;
		first = reverseList(first);
		second = reverseList(second);
		Node sum = null;
		int carry = 0;
		while (first != null && second != null) {
			int sum_data = first.data + second.data + carry;
			carry = sum_data / 10;
			sum_data = sum_data % 10;
			sum.data = sum_data;
			Node next = null;
			sum.next = next;
			sum = sum.next;
			carry = 0;
		}
		return reverseList(sum);
	}

	Node addOne(Node head) {
		head = reverseList(head);
		int value = head.data;
		head.data = (value+1)%10;
		int carry = (value+1)/10;
		head.next.data = head.next.data+carry;
		head = reverseList(head);
		return head;
	}

	void printList(LinkList list) {
		Node start = head;
		while (start != null) {
			System.out.println(start.data);
			start = start.next;
		}
		System.out.println();
	}
	
	void printList(Node start) {
		while (start != null) {
			System.out.println(start.data);
			start = start.next;
		}
		System.out.println();
	}
	
	
	// Your task is to complete the function
	// function should return the modular Node
	// if no such node is present then return -1
	public  int moduarNode(Node head, int k)
    {
		int index=0, data=-1;
		while(head != null)
		{
			index++;
			if(index%k == 0)
			{
				data = head.data;
			}
			head = head.next;
		}
		return data;
    }
	
	public void deleteAlternate (Node head)
	{
        while(head != null && head.next != null)
        {
        	if(head.next.next == null)
        		head.next = null;
        	else
        		head.next = head.next.next;
        	head = head.next;
        }
    }

}
