package array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] ans = new int[nums.length];
		int nonZeroProd = 1;
		int Zeroes = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				Zeroes++;
			else {
				nonZeroProd *= nums[i];
			}
		}

		if (Zeroes > 1) {
			Arrays.fill(ans, 0);
			return ans;
		}

		for (int i = 0; i < ans.length; i++) {
			if (Zeroes == 1) {
				if (nums[i] == 0)
					ans[i] = nonZeroProd;
				else {
					ans[i] = 0;
				}
			} else {
				ans[i] = (nonZeroProd / nums[i]);
			}
		}

		return ans;
	}

}
