package src;

public class SelectionSortArray<T extends Comparable<T>> {
	
	public T[] sort(T[] array) {
		for (int i = 0; i < array.length; i++) {
			int j = getLowest(array, i);
			swapElements(array, i, j);
		}
		return array;
	}

	/*
	 * Run over the array from the point given by the start 
	 * point and fetch the position of the lowest element
	 */
	private int getLowest (T[] array, int start) {
		int lowest = start;
		for (int i = start; i < array.length; i++) {
			if (array[i].compareTo(array[lowest]) < 0) {
				lowest = i;
			}
		}
		return lowest;
	}
	
	/*
	 * Swap the elements to sort the position
	 */
	private void swapElements(T[] array, int a, int b) {
		T temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
