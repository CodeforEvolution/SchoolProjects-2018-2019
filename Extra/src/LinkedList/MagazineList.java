package LinkedList;

// a collection of Magazine objects
import java.util.NoSuchElementException;

public class MagazineList {
	private ListNode list;
	private int count;

	public MagazineList() // empty list of magazines.
	{
		list = null;
		count = 0;
	}

	public void add(Object mag, int index) // create node, insert magazine at index
	{
		ListNode temp = new ListNode(mag, null);
		ListNode current = list;

		for (int i = 1; i < index && current.getNext() != null; i++)
			current = current.getNext();
		temp.setNext(current.getNext());
		current.setNext(temp);
		count++;
	}

	public void add(Object mag) // create node and add to end of list
	{
		ListNode temp = new ListNode(mag, null);
		ListNode current = list;

		if (list == null)
			list = temp;
		else {
			current = list;
			while (current.getNext() != null)
				current = current.getNext();
			current.setNext(temp);
		}
		count++;
	}

	public void remove(Object mag, int index)
	{
		ListNode current = list;

		for (int i = 1; i < index && current.getNext() != null; i++)
			current = current.getNext();

		current.setNext(null);
		count--;
	}

	public Object removeFirst() // remove the node at beginning of list
	{
		if (list == null)
			throw new NoSuchElementException();
		Object lostNode = list.getValue();
		list = list.getNext();
		count--;
		return lostNode;
	}

	public int size() // return length of linked list
	{
		return count;
	}

	public String toString() // return list of magazines as String
	{
		String result = "";
		ListNode current = list;
		while (current != null) {
			result += current.getValue().toString() + "\n";
			current = current.getNext();
		}

		return result;
	}
}
