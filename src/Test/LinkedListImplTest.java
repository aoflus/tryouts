package Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.LinkedListImpl;

class LinkedListImplTest {
	
	public List<Integer> list;
	
	@BeforeEach
	public void setUpList() {
		list = new LinkedListImpl<Integer>();
		list.add(new Integer(4));
		list.add(new Integer(1));
		list.add(new Integer(6));
	}
	
	@Test
	public void testAddElement() {	
		assertTrue(list.size() == 3);
		assertTrue(list.get(0) == 4);
	}
	
	@Test
	public void testAddElementPos() {
		list.add(1, new Integer(9));
		list.add(4, new Integer(2));
		
		assertTrue(list.size() == 5);
		assertTrue(list.get(1) == 9);
		assertTrue(list.get(4) == 2);
	}
	
	@Test
	public void testAddAll() {
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(11);
		list2.add(12);
		list.addAll(list2);
		
		assertTrue(list.size() == 6);
		assertTrue(list.get(3) == 10);
		assertTrue(list.get(5) == 12);
	}
	
	@Test
	public void testAddAllPos() {
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(11);
		list2.add(12);
		list.addAll(1, list2);
		
		assertTrue(list.size() == 6);
		assertTrue(list.get(1) == 10);
		assertTrue(list.get(3) == 12);
		assertTrue(list.get(5) == 6);
	}
	
	@Test
	public void testClear() {
		list.clear();
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(1);
		});
		assertTrue(list.size() == 0);
	}
	
	@Test
	public void testContains() {
		assertTrue(list.contains(new Integer(4)));
		assertFalse(list.contains(new Integer(55)));
	}
	
	@Test
	public void testContainsAll() {
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(new Integer(10));
		list2.add(new Integer(11));
		list2.add(new Integer(12));
		list.addAll(1, list2);
		
		assertTrue(list.containsAll(list2));
		list2.add(new Integer(25));
		assertFalse(list.containsAll(list2));
	}
	
	@Test
	public void testGet() {
		assertTrue(list.get(0) == 4);
		assertFalse(list.get(0) == 7);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(7);
		});
	}
	
	@Test
	public void testIndexOf() {
		assertTrue(list.indexOf(4) == 0);
		assertTrue(list.indexOf(55) == -1);
		assertTrue(list.indexOf(null) == -1);
		
		list.add(new Integer(4));
		assertTrue(list.indexOf(4) == 0);
		
		list.add(null);
		assertTrue(list.indexOf(null) == list.size() -1);
	}
	
	@Test
	public void testIsEmpty() {
		List<Integer> linkedList = new LinkedListImpl<Integer>();
		assertTrue(linkedList.isEmpty());
	}
	
	@Test
	public void testLastIndexOf() {
		assertTrue(list.lastIndexOf(4) == 0);
		assertTrue(list.lastIndexOf(55) == -1);
		assertTrue(list.lastIndexOf(null) == -1);
		
		list.add(new Integer(4));
		assertTrue(list.lastIndexOf(4) == list.size()-1);
		list.add(null);
		assertTrue(list.lastIndexOf(null) == list.size() -1);
	}
	
	@Test
	public void testRemove() {
		assertTrue(list.remove(new Integer(4)));
		assertTrue(list.size() == 2);
		assertFalse(list.remove(new Integer(567)));
		assertTrue(list.size() == 2);
	}
	
	@Test
	public void testRemoveIndex() {
		assertTrue(list.remove(0).equals(new Integer(4)));
		assertTrue(list.size() == 2);
		assertTrue(list.get(0).equals(new Integer(1)));
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(44);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(-1);
		});
	}
	
	@Test
	public void testSet() {
		list.set(0, new Integer(67));
		assertTrue(list.get(0).equals(new Integer(67)));
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.set(-1, new Integer(67));
		});
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.set(8, new Integer(67));
		});
	}

}
