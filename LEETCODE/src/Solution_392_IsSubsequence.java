
public class Solution_392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
    	if (s.length() > t.length()) return false;
        boolean is = true;
    	int pt = 0;
        for ( int i = 0; i < s.length(); i++) {
        	
        	
        	while (pt < t.length() && s.charAt(i) != t.charAt(pt)) {
        		pt++;
        	}
        	
        	if (pt == t.length()) {is = false; break;}
        	
        	
        	
        	pt++;
        }
    	
    	
        
        return is;
    }
}
