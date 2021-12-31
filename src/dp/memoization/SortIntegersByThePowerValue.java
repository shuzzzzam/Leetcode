/**
 * 
 */
package dp.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author fSociety
 *
 */
public class SortIntegersByThePowerValue {

	//leetcode 1387
	/*
	 * In These problem, we will use the memoization as explained in "https://www.youtube.com/watch?v=fJbIuhs24zQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=4&ab_channel=AdityaVerma"
	 */
	public int getKth(int lo, int hi, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();//contains answer in (value, power) arrangement
        
        HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>(); // For memoization
        for(int i = lo; i <= hi; i++) {
        	int power = recursion(i, 0, dp);//start from zero power
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	list.add(i);
        	list.add(power);
        	ans.add(list);
        }
        
        //Sorting answer in List based on Power and Value.
        ans.sort((List<Integer> a, List<Integer> b) -> {
        	if(a.get(1) == b.get(1)) {
        		return Integer.compare(a.get(0), b.get(0));
        	}
        	else {
        		return Integer.compare(a.get(1), b.get(1));
        	}
        });
        
        return ans.get(k - 1).get(0);
    }

	private int recursion(int value, int power, HashMap<Integer, Integer> dp) {
		if(value == 1)
			return power;
		if((value % 2) == 0) {
			if(dp.containsKey(value)) {
				return power + dp.get(value);
			}
			else {
				int getPowerValue = recursion(value/2, power + 1, dp);
				dp.put(value, getPowerValue - power);
				return getPowerValue;
			}
			 
		}
		else {
			if(dp.containsKey(value)) {
				return power + dp.get(value);
			}
			else {
				int getPowerValue = recursion(((3 * value) + 1), power + 1, dp);
				dp.put(value, getPowerValue - power);
				return getPowerValue;
			}
		}
	}	
}
