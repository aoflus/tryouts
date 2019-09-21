package src;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CircularLinkedList<E> implements List<E> {
	
	private int size;
	private Node head;
	private Node tail;
	
	private class Node {
		
		public E element;
		public Node next;
		
		public Node(E element) {
			this.element = element;
		}
		
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		return getNode(index).element;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
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
