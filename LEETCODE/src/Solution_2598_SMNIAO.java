
public class Solution_2598_SMNIAO {
    public int findSmallestInteger(int[] nums, int value) {
        int[] howmany = new int[value];
        int curr = 0;
        boolean done = false;
        
        for (int i = 0; i < nums.length; i++) {
        	if ( nums[i] < 0) nums[i] = nums[i] % value;
        	while (nums[i] < 0) {
        		nums[i] += value;
        	}
        	
        	
        	howmany[nums[i] % value]++;
        }
        
        while (!done) {
        	
        	if (howmany[curr%value] > 0) {
        		howmany[curr%value]--;
        		curr++;
        	} else {
        		done = true;
        	}
        	
        }
        
    	
    	
    	return curr;
    }
}
