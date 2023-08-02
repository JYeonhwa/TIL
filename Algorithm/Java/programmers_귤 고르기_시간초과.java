import java.util.*;

class Solution {
    static int mnv = 100000;
    static boolean[] visit;
    
    public int solution(int k, int[] tangerine) {
        visit = new boolean[tangerine.length];
        List<Integer> basket = new ArrayList<Integer>();
        combi(k, tangerine, basket, 0);
        return mnv;
    }
    
    public void combi(int k, int[] tangerine, List<Integer> basket, int index) {
        if (basket.size() == k) {
            int cnt = check(basket);
            if (mnv > cnt) {
                mnv = cnt;
            }
        } else {
            for (int idx = index; idx < tangerine.length; idx++) {
                if (!visit[idx]) {
                    basket.add(tangerine[idx]);
                    visit[idx] = true;
                    combi(k, tangerine, basket, index+1);
                    visit[idx] = false;
                    basket.remove(basket.size()-1);
                }
            }
        }
    }
    
    public int check (List<Integer> basket) {
        List<Integer> tmp = new ArrayList<Integer>();
        for (Integer el : basket) {
            if (!tmp.contains(el)) {
                tmp.add(el);
            }
        }
        return tmp.size();
    }
}