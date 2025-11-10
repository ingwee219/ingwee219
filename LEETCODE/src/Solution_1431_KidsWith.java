import java.util.*;

public class Solution_1431_KidsWith {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    	
    	int n = candies.length;
    	List<Boolean> result = new ArrayList<>();
    	int x = extraCandies;
    	int gn = 0;
    	for (int i = 0; i < n; i++) {
    		if(candies[i] > gn) gn = candies[i];
    	}
    	
    	for (int i = 0; i < n; i++) {
    		if (candies[i]+x >= gn) {
    			result.add(true);
    		} else result.add(false);
    	}
    	
    	
    	
    	return result;
    }
}