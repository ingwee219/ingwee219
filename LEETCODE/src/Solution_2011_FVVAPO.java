import java.util.*;
public class Solution_2011_FVVAPO {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;
    	
        for (int i = 0; i< operations.length; i++) {
        	switch (operations[i]) {
        	case "++X" :
        		X++;
        		break;
        	case "X++" :
        		X++;
        		break;
        	case "--X" :
        		X--;
        		break;
        	case "X--" :
        		X--;
        		break;
        		default:
        			break;
        	}
        }
    	
    	
    	
    	return X;
    }
}
