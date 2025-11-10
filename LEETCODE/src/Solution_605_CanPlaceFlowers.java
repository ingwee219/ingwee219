
public class Solution_605_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean result = false;
        int[] arr = flowerbed;
        int cnt = 0;
        if (arr.length>1&&arr[0]==0 && arr[1]==0) {arr[0] = 1; cnt++;}
        
        for (int i = 1 ; i < arr.length-1; i++) {
        	if (arr[i-1] == 0 && arr[i] == 0 && arr[i+1] == 0) {arr[i] = 1; cnt ++;}
        	if (cnt >= n) {result = true; break;}
        }
        
        if (arr.length>1&&arr[arr.length-1] == 0 && arr[arr.length-2] == 0) {cnt++;}
        
        if (flowerbed.length == 1 && flowerbed[0] == 0) cnt = 1;
        if (cnt >= n) {result = true;}
    	
    	return result;
    }
}
