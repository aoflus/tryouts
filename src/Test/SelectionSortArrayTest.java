package Test;

import org.junit.jupiter.api.Test;

import src.SelectionSortArray;

class SelectionSortArrayTest {

	@Test
	public void testInt() {
		Integer[] numbers = {8,4,1,4,7,5,2,6};
		SelectionSortArray<Integer> ssa = new SelectionSortArray<Integer>();
		ssa.sort(numbers);
		
		assert(numbers[0] == 1);
		assert(numbers[1] == 2);
	}
	
	@Test
	public void testString() {
		String[] strings = {"peach", "coconut", "apple", "strawberry", "banana"};
		SelectionSortArray<String> ssa = new SelectionSortArray<String>();
		ssa.sort(strings);
		
		assert(strings[0].contentEquals("apple"));
		assert(strings[2].contentEquals("coconut"));
	}

}
