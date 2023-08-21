import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        ArrayList<Integer> store = new ArrayList<>();
        String ss = Integer.toString(storey);
        
        for (int idx = ss.length()-1; idx >= 0; idx--) {
            store.add(ss.charAt(idx) - '0');
        }
        
        for (int idx = 0; idx < ss.length(); idx++) {
            
            int tmp = store.get(idx);
            
            if (tmp > 5) {
                answer += 10-tmp;
                if (idx == ss.length()-1) {
                    answer += 1;
                } else {
                    store.set(idx+1, store.get(idx+1)+1);
                }
                
            } else if (tmp == 5) {
                if (idx != ss.length()-1 && store.get(idx+1) <= 5) {
                    answer += tmp;
                    if (store.get(idx+1) == 5) {
                        store.set(idx+1, store.get(idx+1)+1);
                    }
                } else if (idx != ss.length()-1) {
                    answer += tmp;
                    store.set(idx+1, store.get(idx+1)+1);
                } else {
                    answer += tmp;
                }
                
            } else {
                answer += tmp;
            }
        }
        return answer;
    }
}