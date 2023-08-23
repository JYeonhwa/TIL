import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> cnts1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> cnts2 = new HashMap<Integer, Integer>();
        int[] top1 = new int[topping.length];
        int[] top2 = new int[topping.length];
        int totalcnt1 = 0;
        int totalcnt2 = 0;
        for (int i = 0; i < topping.length; i++) {
            if (!cnts1.containsKey(topping[i])) {
                totalcnt1++;
                cnts1.put(topping[i], 1);
            }
            top1[i] = totalcnt1;
            if (!cnts2.containsKey(topping[topping.length-1-i])) {
                totalcnt2++;
                cnts2.put(topping[topping.length-1-i], 1);
            }
            top2[topping.length-1-i] = totalcnt2;
        }
        for (int i = 0; i < top1.length-1; i++) {
            if (top1[i] < top2[i+1]) {
                continue;
            } else if (top1[i] == top2[i+1]) {
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}