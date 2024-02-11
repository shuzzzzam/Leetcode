package binarySearch;

import java.util.ArrayList;
import java.util.List;

public class IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
		List<Integer> sortedList = new ArrayList<>();
		sortedList.add(nums[0]);

		for (int i = 1; i < nums.length; i++) {

			adjustValue(sortedList, nums[i]);

			if (sortedList.size() >= 3) {
				return true;
			}
		}

		return false;
	}

	private void adjustValue(List<Integer> sortedList, int num) {
		if (sortedList.size() == 1) {
			if (sortedList.get(0) == num)
				return;
			else if (sortedList.get(0) > num) {
				sortedList.add(0, num);
			} else {
				sortedList.add(num);
			}
		} else {
			int start = 0, end = sortedList.size() - 1;
			while (start < end) {
				if (end - start == 1) {
					if (sortedList.get(start) == num || sortedList.get(end) == num)
						return;
					else {
						if (sortedList.get(start) > num)
							sortedList.add(start, num);
						else if (sortedList.get(end) < num) {
							if (end == sortedList.size() - 1)
								sortedList.add(num);
							else {
								sortedList.add(end + 1, num);
							}
						} else {
							sortedList.set(end, num);
						}
					}
					return;
				} else {
					int mid = start + (end - start) / 2;

					if (sortedList.get(mid) == num)
						return;

					if (num > sortedList.get(mid)) {
						start = mid;
					} else {
						end = mid;
					}
				}
			}
		}
	}
}
