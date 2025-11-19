import java.util.*;
public class Solution_2154_KMFVBT {
    public int findFinalValue(int[] nums, int original) {
        int ans = original;
    	int tmp = original;
    	HashSet<Integer> set = new HashSet<>();
    	List<Integer> list = new ArrayList<>();
        while (tmp <= 1000) {
        	list.add(tmp);
        	tmp *= 2;
        }
        
        for (int i = 0; i < nums.length; i++) {
        	set.add(nums[i]);
        }
        
        
        for (int i = 0; i < list.size(); i++) {
        	if (set.contains(list.get(i))) {
        		ans *= 2;
        	} else {
        		break;
        	}
        }
        
    	
    	
    	return ans;
    }
}
