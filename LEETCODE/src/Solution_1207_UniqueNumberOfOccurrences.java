import java.util.*;
public class Solution_1207_UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
    	HashMap<Integer, Integer> map = new HashMap<>();
    	HashSet<Integer> set = new HashSet<>();
    	for (int i = 0; i < arr.length; i++) {
    		if (map.containsKey(arr[i])) {
    			map.put(arr[i], map.get(arr[i])+1);
    		} else {
    			map.put(arr[i], 1);
    		}
    	}
    	
    	for (int value : map.values()) {
    		if(set.contains(value)) return false;
    		else set.add(value);
    	}
    	
       
       
       return true;
    }
}
