/**
 * 
 */
package dp;

import java.util.HashMap;

/**
 * @author fSociety
 *
 */
public class CoinChange2 {
	HashMap<Integer, HashMap<Integer, Integer>> dp = new HashMap<Integer, HashMap<Integer, Integer>>();

	public int change(int amount, int[] coins) {
		return recursion(amount, 1, coins) + recursion(amount - coins[0], 0, coins);
	}

	private int recursion(int amount, int i, int[] coins) {
		if (dp.containsKey(amount) && dp.get(amount).containsKey(i)) {
			return dp.get(amount).get(i);
		}
		if (!dp.containsKey(amount)) {
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			dp.put(amount, map);
		}
		if (amount == 0) {
			HashMap<Integer, Integer> map = dp.get(amount);
			map.put(i, 1);
			dp.put(amount, map);
			return 1;
		}

		if (i > (coins.length - 1) || (amount < 0)) {
			return 0;
		}

		return recursion(amount, i + 1, coins) + recursion(amount - coins[i], i, coins);
	}

}
