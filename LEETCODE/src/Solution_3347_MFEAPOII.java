import java.util.*;
public class Solution_3347_MFEAPOII {

    public int maxFrequency(int[] nums, int k, int numOperations) {
        final int n = nums.length;
        Arrays.sort(nums);

        int ans = 1;

        // 1) "배열에 있는 값 v"를 목표로: 각 고유값 블록마다 within을 투포인터로 즉석 계산
        int lWithin = 0, rWithin = 0; // [lWithin, rWithin] == [v-k, v+k]에 들어오는 창
        int i = 0;
        while (i < n) {
            int s = i;
            int v = nums[i];
            // 같은 값 블록의 끝 e 찾기
            while (i + 1 < n && nums[i + 1] == v) i++;
            int e = i;
            int freq = e - s + 1;

            long rightBound = (long) v + (long) k;
            while (rWithin + 1 < n && (long) nums[rWithin + 1] <= rightBound) rWithin++;

            long leftBound = (long) v - (long) k;
            while (lWithin < n && (long) nums[lWithin] < leftBound) lWithin++;

            int within = rWithin - lWithin + 1;           // [v-k, v+k]에 들어오는 전체 개수
            int extra = within - freq; if (extra < 0) extra = 0;
            int used = (extra < numOperations) ? extra : numOperations;

            ans = Math.max(ans, freq + used);
            i++; // 다음 값으로
        }

        // 2) "배열에 없는 값 v"도 허용: maxCover = max window with (max - min ≤ 2k)
        int l = 0, maxCover = 1;
        for (int r = 0; r < n; r++) {
            while ((long) nums[r] - (long) nums[l] > 2L * (long) k) l++;
            int win = r - l + 1;
            if (win > maxCover) maxCover = win;
        }
        ans = Math.max(ans, Math.min(numOperations, maxCover));

        return ans;
    }
}
