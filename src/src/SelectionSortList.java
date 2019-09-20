package src;
import java.util.Collections;
import java.util.List;

public class SelectionSortList<T extends Comparable<T>> {
	
	public List<T> sort(List<T> list) {
		
		/* Start the sorting */
		for (T t : list) {
			T lowest = t;
			
			/* Iterate the list to find the lowest candidate */
			for (int i = list.indexOf(t); i < list.size(); i++) {
				if (lowest.compareTo(list.get(i)) > 0) {
					lowest = list.get(i);
				}
			}
			Collections.swap(list, list.indexOf(t), list.indexOf(lowest));
		}
		return list;
	}

}
