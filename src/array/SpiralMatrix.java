/**
 * 
 */
package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fSociety
 *
 */
public class SpiralMatrix {
	/*
	 * Leetcode 54 In this problem, we will use 4 different methods to get the
	 * spiral path.
	 */
	public int x = 0, y = 0;
	public int[][] copy = null;

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<Integer>();
		copy = matrix;
		int side = 0;

		while (ans.size() != matrix.length * matrix[0].length) {
			populateList(side, copy, ans);
			side++;
		}

		return ans;
	}

	private void populateList(int side, int[][] copy2, List<Integer> ans) {

		if ((side % 4) == 0) {// for right side horizontal movement
			while (((x >= 0 && x < copy.length) && (y >= 0 && y < copy[0].length)) && copy[x][y] != -101) {
				ans.add(copy[x][y]);
				copy[x][y] = -101;
				y++;
			}
			y--;
			x += 1;
		}
		if ((side % 4) == 1) {// for downward vertical

			while (((x >= 0 && x < copy.length) && (y >= 0 && y < copy[0].length)) && copy[x][y] != -101) {
				ans.add(copy[x][y]);
				copy[x][y] = -101;
				x++;

			}
			x--;
			y -= 1;
		}
		if ((side % 4) == 2) {// for left horizontal

			while (((x >= 0 && x < copy.length) && (y >= 0 && y < copy[0].length)) && copy[x][y] != -101) {
				ans.add(copy[x][y]);
				copy[x][y] = -101;
				y--;

			}
			y++;
			x -= 1;
		}
		if ((side % 4) == 3) {// for upwards vertical.

			while (((x >= 0 && x < copy.length) && (y >= 0 && y < copy[0].length)) && copy[x][y] != -101) {
				ans.add(copy[x][y]);
				copy[x][y] = -101;
				x--;

			}
			x++;
			y += 1;
		}

	}
}
