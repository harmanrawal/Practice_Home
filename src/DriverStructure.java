
public class DriverStructure {

	public static void main(String[] args) {
		
		LinkList list = new LinkList();
		list.insertNode(list, 1);
		list.insertNode(list, 2);
		list.insertNode(list, 3);
		list.insertNode(list, 4);
		list.deleteAlternate(list.head);
		list.printList(list);
	}

}
