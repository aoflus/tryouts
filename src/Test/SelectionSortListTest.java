package Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import src.SelectionSortList;

class SelectionSortListTest {

	@Test
	public void testIntegers() {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(8);
		list.add(1);
		list.add(5);
		list.add(6);
		list.add(9);
		list.add(2);
		
		SelectionSortList<Integer> sls = new SelectionSortList<Integer>();
		sls.sort(list);
		
		assert(list.get(0) == 1);
		assert(list.get(1) == 2);
	}
	
	public void testStrings() {
		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("pear");
		list.add("strawberry");
		list.add("orange");
		list.add("banana");
		list.add("coconut");
		list.add("peach");
		
		SelectionSortList<String> sls = new SelectionSortList<String>();
		sls.sort(list);
		
		assert(list.get(0).contentEquals("apple"));
		assert(list.get(1).contentEquals("banana"));
	}

}
