/**
 * 
 */
package array;

/**
 * @author fSociety
 *
 */
public class SpiralMatrix2 {
	/*
	 * Leetcode 59
	 * Similar approach for leetcode 54.
	 */
	public int[][] copy = null;
	public int[][] ans = null;
	public int x = 0, y = 0;
	public int pathCount = 1;
	public int[][] generateMatrix(int n) {
        ans = new int[n][n];
        copy = new int[n][n];
        int side = 0;
        while(pathCount <= (n * n)) {
        	populateMatrix(side);
			side++;
        }
        return ans;
    }
	private void populateMatrix(int side) {
		// TODO Auto-generated method stub
		if ((side % 4) == 0) {// for right side horizontal movement
			while (((x >= 0 && x < copy.length) && (y >= 0 && y < copy[0].length)) && copy[x][y] != -101) {
				ans[x][y] = pathCount;
				pathCount++;
				copy[x][y] = -101;
				y++;
			}
			y--;
			x += 1;
		}
		if ((side % 4) == 1) {// for downward vertical

			while (((x >= 0 && x < copy.length) && (y >= 0 && y < copy[0].length)) && copy[x][y] != -101) {
				ans[x][y] = pathCount;
				pathCount++;
				copy[x][y] = -101;
				x++;

			}
			x--;
			y -= 1;
		}
		if ((side % 4) == 2) {// for left horizontal

			while (((x >= 0 && x < copy.length) && (y >= 0 && y < copy[0].length)) && copy[x][y] != -101) {
				ans[x][y] = pathCount;
				pathCount++;
				copy[x][y] = -101;
				y--;

			}
			y++;
			x -= 1;
		}
		if ((side % 4) == 3) {// for upwards vertical.

			while (((x >= 0 && x < copy.length) && (y >= 0 && y < copy[0].length)) && copy[x][y] != -101) {
				ans[x][y] = pathCount;
				pathCount++;
				copy[x][y] = -101;
				x--;

			}
			x++;
			y += 1;
		}
	}
}
