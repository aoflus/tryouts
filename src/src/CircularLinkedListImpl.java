package src;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CircularLinkedListImpl<E> implements List<E> {
	
	private int size;
	private Node head;
	private Node tail;
	
	private class Node {
		
		public E element;
		public Node next;
		
		public Node(E element, Node next) {
			this.element = element;
			this.next = next;
		}
		
		public String toString() {
			return "Node : " + element.toString();
		}
	}
	
	private Node getNode(int index) {
		/* Check for indexes that loop the circular list */
		index = checkForLoops(index);
		
		/* Get the node after the check */
		if (index == 0) { // get node at 0 with O(1) complexity
			return head;
		} else {
			Node node = head;
			for (int i = 0; i < size; i++) {
				if  (i == index) {
					return node;
				}
				node = node.next;
			}
		}
		return null;
	}
	
	private int checkForLoops(int index) {
		if (index < 0) {
			if (Math.abs(index) > size) { // The negative index traverses the circular list more than once
				int val = Math.abs(index) % size;
				index = index-val;
			} else {
				index = size - Math.abs(index);
			}
		} else if (index >= size) {
			index = index % size;
		}
		return index;
	}

	@Override
	public boolean add(E e) {
		if (size == 0) {
			head = new Node(e, head);
			tail = head;
		} else {
			tail.next = new Node(e, head);
			tail = tail.next;
		}
		size++;
		return true;
	}

	@Override
	public void add(int index, E element) {
		Node prev = null;
		if (index < 0) { // Adding new nodes with negative index
			prev = getNode(index);
		} else {  // Adding new nodes with positive index
			prev = getNode(index-1);
		}
		prev.next = new Node(element, prev.next);	
		if (prev.next.next.equals(head)) { // Check if the new element is the new tail
			tail = prev.next;
		}
		size++;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean done = true;
		for (E e : c) {
			done = add(e);
		}
		return done;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		int i = index;
		for (E e : c) {
			add(i, e);
			i++;
		}
		return true;
	}

	@Override
	public void clear() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object o) {
		Node node = head;
		while (!node.next.equals(head)) {
			if (node.element.equals((E) o)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o: c) {
			if (!contains(o)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public E get(int index) {
		return getNode(index).element;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int indexOf(Object o) {
		int i = 0;
		Node node = head;
		while (!node.next.equals(head)) {
			if (node.element.equals((E) o)) {
				return i;
			}
			i++;
			node = node.next;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int lastIndexOf(Object o) {
		for (int i = size; i > 0; i--) {
			if (getNode(i).element.equals((E) o)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		if (index == -1) {
			return false;
		}
		remove(index);
		return true;
	}

	@Override
	public E remove(int index) {
		Node node = getNode(index-1);
		Node removed = node.next;
		if (index == 0) {
			head = removed.next;
		} else if (index == size-1) {
			tail = node;
		}
		node.next= removed.next;
		size--;
		return removed.element;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean removeAll(Collection<?> c) {
		for (Object o : c) {
			while (contains((E) o)) {
				remove(o);
			}
		}
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		for (int i = 0; i < size; i++) {
			if (!c.contains(getNode(i).element)) {
				remove(i);
			}
		}
		
		return true;
	}

	@Override
	public E set(int index, E element) {
		Node node = getNode(index);
		E old = node.element;
		node.element = element;
		return old;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
