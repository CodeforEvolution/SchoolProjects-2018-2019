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
		if (index == 0)
		{
			addFirst(mag);
			return;
		}

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
		else
		{
			current = list;
			while (current.getNext() != null)
				current = current.getNext();
			current.setNext(temp);
		}

		count++;
	}

	public void addFirst(Object mag)
	{
		ListNode toAdd = new ListNode(mag, null);

		if (list == null)
			list = toAdd;
		else
		{
			toAdd.setNext(list);
			list = toAdd;
		}

		count++;
	}

	public Object remove(int index)
	{
		if (index < 0 || index >= count)
			throw new NoSuchElementException();

		if (index == 0)
			return removeFirst();

		if (index == count - 1)
			return removeLast();

		if (list == null)
			throw new NoSuchElementException();

		ListNode current = list;
		for (int i = 0; i < index - 1; i++)
			current = current.getNext();

		Object lostValue = current.getNext().getValue();

		current.setNext(current.getNext().getNext());

		count--;

		return lostValue;
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

	public Object removeLast()
	{
		if (list == null)
			throw new NoSuchElementException();

		ListNode keep = list;
		for (int c = 0; c < count - 2; c++)
		{
			keep = keep.getNext();
		}

		Object lostData = keep.getNext().getValue();
		keep.setNext(null);
		count--;

		return lostData;
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
