
public class Solution_3354_MakeArrayElementsEqualToZero {
    public int countValidSelections(int[] nums) {
    	int valid = 0;
        int[][] lrsum = new int[nums.length][2];
        int lsum = 0;
        int rsum = 0;
        for (int i = 0; i < nums.length; i++) {
        	rsum += nums[i];
        }
        
         
        for (int i = 0; i < nums.length; i++) {
        	if (i > 0) {lsum += nums[i-1];}
        	if (i < nums.length-1) {rsum -= nums[i];}
        	lrsum[i][0] = lsum;
        	lrsum[i][1] = rsum;
        }
        
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == 0) {
        		if (lrsum[i][0] == lrsum[i][1]) valid += 2;
        		else if (Math.abs(lrsum[i][0]-lrsum[i][1])==1) valid++;
        	}
        }
    	
    	return valid;
    }
}
