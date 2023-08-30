import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> possible = new HashMap<>();
        for (int j = 0; j < want.length; j++) {
            possible.put(want[j], number[j]);
        }
        for (int i = 0; i < discount.length; i++) {
            if (possible.containsKey(discount[i])) {
                possible.put(discount[i], possible.get(discount[i])-1);
            }
            if (i >= 10) {
                if (possible.containsKey(discount[i-10])) {
                    possible.put(discount[i-10], possible.get(discount[i-10])+1);
                }
            }
            for (String el:want) {
                if (possible.get(el) > 0) {
                    break;
                }
                if (el == want[want.length-1]) {
                    answer++;
                }
            }
        }
        return answer;
    }
}