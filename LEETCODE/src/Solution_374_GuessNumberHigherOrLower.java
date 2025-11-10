
public class Solution_374_GuessNumberHigherOrLower {
    public int guessNumber(int n) {
    	int ans = 0;
    	long mid = n/2;
    	long high = n;
    	long low = 1;
    	boolean done = false;
    	
    	while(!done) {
    		long tmp = 1;//guess((int)mid);
    		
    		if (tmp == -1) {
    			high = mid-1;
    			mid = (high+low)/2;
    		} else if (tmp == 1) {
    			low = mid+1;
    			mid = (high+low)/2;
    		} else {
    			ans = (int)mid;
    			done = true;
    		}
    		
    	}
    	
    	
        
        return ans;
    }
}
