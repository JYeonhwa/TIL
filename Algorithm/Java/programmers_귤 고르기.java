import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (Integer el: tangerine) {
            mp.put(el, mp.getOrDefault(el, 0)+1);
        }
        List<Integer> mpvalues = new ArrayList<>(mp.values());
        Collections.sort(mpvalues, Collections.reverseOrder());
        int sm = 0;
        int answer = 0;
        for (int el : mpvalues) {
            sm += el;
            answer++;
            if (sm >= k) {
                break;
            }
        }
        return answer;
    }
}