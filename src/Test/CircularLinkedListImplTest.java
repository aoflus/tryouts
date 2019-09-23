package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.CircularLinkedListImpl;

class CircularLinkedListImplTest {

	public List<Integer> list;
	
	@BeforeEach
	public void setUp() {
		list = new CircularLinkedListImpl<Integer>();
		list.add(new Integer(4));
		list.add(new Integer(7));
		list.add(new Integer(1));
	}
	
	@Test
	public void testAdd() {
		list.add(new Integer(4));
		assertTrue(list.size() == 4);
	}
	
	@Test
	public void testAddWithIndex() {
		list.add(1, new Integer(4));
		assertTrue(list.get(1).equals(new Integer(4)));
		
		list.add(-1, new Integer(20));
		assertTrue(list.get(-1).equals(20));
	}

}
