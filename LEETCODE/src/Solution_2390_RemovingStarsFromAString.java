import java.util.*;
public class Solution_2390_RemovingStarsFromAString {
    public String removeStars(String s) {
    	int n = s.length();
    	boolean[] visited = new boolean[n];
    	StringBuilder sb = new StringBuilder();
    	sb.append(s);
    	LinkedList<Integer> list = new LinkedList<>();
    	
    	for (int i = n-1 ; i >= 0 ; i--) {
    		if (s.charAt(i) == '*') {
    			list.add(i);
    			visited[i] = true;
    			boolean done = false;
    			int idx = i-1;
    			while (!done) {
    				if (!visited[idx] && s.charAt(idx) != '*') {
    					visited[idx] = true;
    					list.add(idx);
    					done = true;
    				}
    				idx--;
    			}
    			
    			
    		}
    	}
    	
    	
    	int[] arr = new int[list.size()];
    	for (int i = 0; i < list.size(); i++) {
    		arr[i] = list.get(i);
    	}
    	Arrays.sort(arr);
    	
    	for (int i = arr.length-1; i >=0; i--) {
    		sb.deleteCharAt(i);
    	}
    	
    	
    	
    	
    	
    	return sb.toString();
    }
}
