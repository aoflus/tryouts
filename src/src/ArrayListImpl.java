package src;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListImpl<T> implements List<T>{
	
	int size;
	T[] array;
	
	@SuppressWarnings("unchecked")
	public ArrayListImpl(){
		size = 0;
		array = (T[]) new Object[10];
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(T arg0) {
		if (size >= array.length) {
			T[] a = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length *1,5);
			System.arraycopy(array, 0, a, 0, array.length);
			array = a;
		}
		array[size-1] = arg0;
		size++;
		return false;
	}

	@Override
	public void add(int arg0, T arg1) {
		if (arg0 < 0 || arg0 >= size) {
			throw new IndexOutOfBoundsException();
		}
		// Add for resizing
		add(arg1);
		
		// Shift the array
		for(int i = size-1; i < arg0; i--) {
			array[i] = array[i-1];
		}
		
		// Add the element
		array[arg0] = arg1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		if (arg0.size() + size >= array.length) {
			T[] a = (T[]) Array.newInstance(array.getClass().getComponentType(), arg0.size() *2);
			System.arraycopy(array, 0, a, 0, array.length);
			array = a;
		}
		Iterator<T> itr = (Iterator<T>) arg0.iterator();
		while (itr.hasNext()) {
			array[size-1] = itr.next();
			size++;
		}
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends T> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T set(int arg0, T arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<T> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
