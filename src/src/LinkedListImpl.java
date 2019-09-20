package src;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedListImpl<E> implements List<E> {
	
	private int size;
	private Node head;
	
	public LinkedListImpl () {
		size = 0;
		head = null;
	}
	
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
		
		@Override
		public String toString() {
			return "Node: " + element.toString();
		}
	}
	
	private Node getNode(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node node = head;
		for (int i = 0; i < size; i++) {
			if (i == index) {
				return node;
			}
			node = node.next;
		}
		return null;
	}

	@Override
	public boolean add(E e) {
		if (size == 0) {
			head = new Node(e);
		} else {
			Node node = head;
			for ( ; node.next != null; node = node.next) {};
			node.next = new Node(e, node.next);
		}
		size++;
		return false;
	}

	@Override
	public void add(int index, E element) {
		Node node = getNode(index-1);
		node.next = new Node(element, node.next);
		size++;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean flag = true;
		for (E e : c) {
			flag &= add(e);
		}
		return flag;
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
		this.head = null;
		this.size = 0;
	}

	@Override
	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		boolean flag = true;
		for (Object item : c) {
			flag &= contains(item);
		}
		return flag;
	}

	@Override
	public E get(int index) {
		return getNode(index).element;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int indexOf(Object o) {
		Node node = head;
		for (int i = 0; i < size; i++) {
			// Control null pointers
			if (getNode(i).element == null) {
				return i;
			}
			else if (getNode(i).element.equals((E) o)) {
				return i;
			}
			node = node.next;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int lastIndexOf(Object o) {
		for (int i = size-1; i >= 0; i--) {
			if (getNode(i).element == null) {
				return i;
			} else if (getNode(i).element.equals((E) o)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
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
		Node node = getNode(index);
		if (index == 0) {
			head = head.next;
		} else {
			getNode(index-1).next = node.next;
		}
		size--;
		return node.element;
	}

	@Override
	public boolean removeAll(Collection c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
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
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

}
