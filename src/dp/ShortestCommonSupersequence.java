/**
 * 
 */
package dp;

/**
 * @author fSociety
 *
 */
public class ShortestCommonSupersequence {
	/*
	 * Leetcode 1092
	 * In this problem , we will use method similar to LCS(str1, str2) with a slight change.
	 * We will keep track of 2d string array to keep track record of shortest supersequence string. 
	 */
	public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dpCount = new int[str1.length() + 1][str2.length() + 1];//To keep track record of count of shortest supersequence.
        String[][] dpString = new String[str1.length() + 1][str2.length() + 1];//To keep track record of shortest supersequence string.
        
        dpString[0][0] = "";
        for(int i = 0; i < str2.length(); i++) {
        	dpCount[0][i] = i;
        	if(i > 0)
        		dpString[0][i] = str2.substring(0, i);
        }
        
        for(int i = 0; i < str1.length(); i++) {
        	dpCount[i][0] = i;
        	if(i > 0)
        		dpString[i][0] = str1.substring(0, i);
        }
        
        for(int i = 1; i <= str1.length(); i++) {
        	for(int j = 1; j <= str2.length(); j++) {
        		if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
        			dpCount[i][j] = 1 + dpCount[i - 1][j - 1];
        			dpString[i][j] =  dpString[i - 1][j - 1] + str1.substring(i - 1, i);
        		}
        		else {
        			if(dpCount[i - 1][j] < dpCount[i][j - 1]) {
        				dpCount[i][j] = 1 + dpCount[i - 1][j];
        				dpString[i][j] = dpString[i - 1][j] + str1.substring(i - 1, i);
        			}
        			else {
        				dpCount[i][j] = 1 + dpCount[i][j - 1];
        				dpString[i][j] = dpString[i][j - 1] + str2.substring(j - 1, j);
        			}
        		}
        	}
        }
       
        return dpString[str1.length()][str2.length()];
    }
}
