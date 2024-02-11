/**
 * 
 */
package queue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author fSociety
 *
 */
public class DiagonalTraverse2 {

	public int[] findDiagonalOrder(List<List<Integer>> nums) {
		int x = 0, y = 0;
		Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
		List<Integer> ans = new ArrayList<Integer>();
		List<Integer> start = new ArrayList<Integer>();
		start.add(x);
		start.add(y);
		start.add(nums.get(x).get(y));
		HashSet<String> visited = new HashSet<String>();

	}

}
