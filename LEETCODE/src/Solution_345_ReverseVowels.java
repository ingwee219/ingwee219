import java.util.*;
public class Solution_345_ReverseVowels {
     public String reverseVowels(String s) {
        
    	LinkedList<Character> list = new LinkedList<>(); 
    	LinkedList<Integer> index = new LinkedList<>(); 
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || 
        			s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || 
        			s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U') {
        		list.add(s.charAt(i));
        		index.add(i);
        	}
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (int i = 0; i < list.size(); i++) {
        	sb.deleteCharAt(index.get(i));
        	
        	sb.insert(index.get(i), String.valueOf(list.get(list.size()-1-i)));
        	
        }
        
        
        String result = sb.toString();
        
    	return result;
    }
}
