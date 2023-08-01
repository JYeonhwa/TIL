import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> hm = new HashMap<>();
        Arrays.sort(weights);
        for (int i = 0; i < weights.length; i++) {
            double a = weights[i]*1.0;
            double b = (weights[i]*2.0)/3.0;
            double c = (weights[i]*2.0)/4.0;
            double d = (weights[i]*3.0)/4.0;
            if (hm.containsKey(a)) {
                answer += hm.get(a);
            }
            if (hm.containsKey(b)) {
                answer += hm.get(b);
            }
            if (hm.containsKey(c)) {
                answer += hm.get(c);
            }
            if (hm.containsKey(d)) {
                answer += hm.get(d);
            }
            hm.put((weights[i]*1.0), hm.getOrDefault((weights[i]*1.0), 0)+1);
        }
        return answer;
    }
}