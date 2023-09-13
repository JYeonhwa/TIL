import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] opened = new boolean[cards.length];
        ArrayList<Integer> cnts = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            int n = i;
            int cnt = 0;
            if (!opened[n]) {
                while (!opened[n]) {
                    opened[n] = true;
                    n = cards[n]-1;
                    cnt++;
                }
                cnts.add(cnt);
            }
        }
        for (boolean open : opened) {
            if (!open) {
                cnts.add(1);
            }
        }
        Collections.sort(cnts);
        if (cnts.size() > 1) {
            answer = cnts.get(cnts.size()-1) * cnts.get(cnts.size()-2);
        }
        return answer;
    }
}
