public class Solution_3461_CIDAEISAOI_2 {
	
    public boolean hasSameDigits(String s) {
    	int n = s.length();
    	for (int i = 0; i<n-2 ;i++) {
    		StringBuilder sb = new StringBuilder();
    		
    		for (int j = 0; j < s.length()-1; j++) {
    			sb.append( ((int)s.charAt(j)+(int)s.charAt(j+1)) % 10) ;
    		}
    		
    		s = sb.toString();
    	}
    	
    	if (s.charAt(0) == s.charAt(1)) return true;
    	return false;
    		
    }
    
    
    
}
