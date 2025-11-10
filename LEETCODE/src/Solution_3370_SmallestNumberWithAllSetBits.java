
public class Solution_3370_SmallestNumberWithAllSetBits {
    public int smallestNumber(int n) {
        int cha = 0;
        
        for (int i = 0; i < 10; i++) {
        	if (n >= Math.pow(2, i)) {
        		cha = i;
        	}
        }
    	
    	
    	return (int)Math.pow(2,cha+1)-1;
    }
}
