
public class Solution_1437_CIA1ALLKPA {
    public boolean kLengthApart(int[] nums, int k) {
        int d = 0;
        boolean first = true;
    	for (int i = 0; i < nums.length ; i++) {
    		if (nums[i] == 1) {
    			if (first) {d=0; first = false; continue;}
    			if (d<k) return false;
    			
    			d = 0;
    		} else {
    			d++;
    		}
    	}
    	
    	return true;
    }
}