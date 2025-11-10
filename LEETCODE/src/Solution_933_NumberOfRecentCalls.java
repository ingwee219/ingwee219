import java.util.*;
public class Solution_933_NumberOfRecentCalls {
	static Queue<Long> q;
    public Solution_933_NumberOfRecentCalls() {
        q = new LinkedList<>();
    }
    
    public long ping(int t) {
        q.add((long)t);
    	
        
        while (q.peek() < t-3000) {
        	q.poll();
        }
    	
    	return q.size();
    }
    
}
