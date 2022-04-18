package sort;

import java.util.*;
import java.util.Map.Entry;

class comparator implements Comparator<Map.Entry<Integer, Integer>> {
	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
		if (o1.getValue() > o2.getValue())
			return -1;
		else if (o1.getValue() == o2.getValue()) {
			if (o2.getKey() < o1.getKey())
				return 1;
			else
				return -1;

		} else if (o1.getValue() < o2.getValue())
			return 1;

		return Integer.MIN_VALUE;
	}
}

class Solution {
	static ArrayList<Integer> sortByFreq(int arr[], int n) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int num = arr[i];

			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 0);
			}
		}

		// copying the elements and their count from map to list.
		List<Map.Entry<Integer, Integer>> set = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

		// sorting the list according to frequency.
		Collections.sort(set, new comparator());
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < map.size(); i++) {
			int count = set.get(i).getValue();
			// storing elements as many times as their count in output list.
			while (count >= 0) {
				ans.add(set.get(i).getKey());
				count--;
			}
		}
		// returning the output.
		return ans;
	}
}