import java.util.*;

public class Solution_345_ReverseVowels_2 {
	static char[] arr;
	static public void swap(int a, int b) {
		char tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
		
	}
	
	
	static public String reverseVowels(String s) {
		int start = 0;
		int end = s.length()-1;
		arr = new char[s.length()];
		for(int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(i);
		}
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		
		while(start < end) {
			while (start < end &&arr[start] != 'a' && arr[start] != 'e' && arr[start] != 'i' && arr[start] != 'o' && 
					arr[start] != 'u' && arr[start] != 'A' && arr[start] != 'E' && 
					arr[start] != 'I' && arr[start] != 'O' && arr[start] != 'U') {
				start++;
			}
			q1.add(start);
			start++;
			while (start <= end &&arr[end] != 'a' && arr[end] != 'e' && arr[end] != 'i' && arr[end] != 'o' && 
					arr[end] != 'u' && arr[end] != 'A' && arr[end] != 'E' && 
					arr[end] != 'I' && arr[end] != 'O' && arr[end] != 'U') {
				end--;
			}
			q2.add(end);
			end--;
		}
		
		while(!q1.isEmpty() && !q2.isEmpty()) {
			swap(q1.poll(), q2.poll());
		}
		
		String result = new String(arr);
		
		return result;
	}//reverse
}
