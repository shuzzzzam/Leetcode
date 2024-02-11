package dp.memoization;

import java.util.HashMap;

public class IntegerReplacement {
	HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>();

	public int integerReplacement(int n) {
		if (dp.containsKey(n))
			return dp.get(n);
		if (n == 1) {
			dp.put(1, 0);
			return 0;
		}

		if (n % 2 == 0) {
			dp.put(n, 1 + integerReplacement(n / 2));
			return dp.get(n);
		} else {
			dp.put(n, 1 + Math.min(integerReplacement(n - 1), integerReplacement(n + 1)));
			return dp.get(n);
		}
	}
}
