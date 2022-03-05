/**
 * 
 */
package graph.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author fSociety
 *
 */
public class MostFrequentSubtreeSum {
	/*
	 * Leetcode 508
	 * In This problem, we will use recursion alongwith two levels of HashMap to keep track of frequency and it's max.
	 */
	public int maxFrequencyCount = 0;//max Value
	public HashMap<Integer, Integer> frequencyCountMap = new HashMap<Integer, Integer>();//Keeps count of each sum's frequency.(sum:frequency)
	public HashMap<Integer, List<Integer>> maxFrequencyToCount = new HashMap<Integer, List<Integer>>(); // keeps track of each sum's frequency. (frequency:<list of sum's having same frequency>)
	public int[] findFrequentTreeSum(TreeNode root) {
        recursion(root);
        List<Integer> ansList = maxFrequencyToCount.get(maxFrequencyCount);
        
        int[] ans = new int[ansList.size()];
        for(int i = 0; i < ansList.size(); i++)
        	ans[i] = ansList.get(i);
       
        return ans;
        
    }
	
	//Recursive call
	private int recursion(TreeNode root) {
		int currentNode = root.val;
		if(root.left == null && root.right == null) {
			extracted(currentNode);
			
			return currentNode;
			
		}
		if(root.left != null) {
			currentNode += recursion(root.left);
		}
		
		if(root.right != null) {
			currentNode += recursion(root.right);
		}
		
		extracted(currentNode);
		
		return currentNode;
		
		
	}
	
	//Refactored method. it will first update ((sum:frequency)) hashmap, then it will update ((frequency:<list of sum's having same frequency>)) Hashmap.
	private void extracted(int currentNode) {
		if(!frequencyCountMap.containsKey(currentNode)) {
			frequencyCountMap.put(currentNode, 1);
			if(maxFrequencyCount < 1) {
				maxFrequencyCount = 1;
				
			}
			
			if(!maxFrequencyToCount.containsKey(1)) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(currentNode);
				maxFrequencyToCount.put(1, list);
			}
			else {
				List<Integer> list = maxFrequencyToCount.get(1);
				list.add(currentNode);
				maxFrequencyToCount.put(1, list);
			}
			
		}
		else {
			int freq = frequencyCountMap.get(currentNode);
			frequencyCountMap.put(currentNode, freq + 1);
			freq += 1;
			if(maxFrequencyCount < freq) {
				maxFrequencyCount = freq;
				
			}
			
			if(!maxFrequencyToCount.containsKey(freq)) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(currentNode);
				maxFrequencyToCount.put(freq, list);
			}
			else {
				List<Integer> list = maxFrequencyToCount.get(freq);
				list.add(currentNode);
				maxFrequencyToCount.put(freq, list);
			}
		}
	}
}
