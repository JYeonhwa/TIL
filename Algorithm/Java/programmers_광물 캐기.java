import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        Map<String, Integer> mineral = new HashMap<>();
        mineral.put("diamond", 0);
        mineral.put("iron", 1);
        mineral.put("stone", 2);
        
        int[][] table = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> start = new ArrayList<>();
        
        start.add(0);
        start.add(0);
        for (int el : picks) {
            start.add(el);
        }
        q.add(start);
        
        int mnv = 1250;
        while (q.size() != 0) {
            List<Integer> sources = q.poll();
            for (int ch = 0; ch < 3; ch++) {
                int sm = sources.get(0);
                int idx = sources.get(1);
                int diamond = sources.get(2);
                int iron = sources.get(3);
                int stone = sources.get(4);
                
                if (sources.get(ch+2) > 0) {
                    
                    if (ch == 0) diamond--;
                    else if (ch == 1) iron--;
                    else stone--;
                    
                    List<Integer> tmp = new ArrayList<>();
                    int ii = 0;
                    for (int i = idx; i < idx+5; i++) {
                        if (minerals.length <= i) {
                            if (mnv > sm) {
                                mnv = sm;
                            }
                            ii = i;
                            break;
                        } 
                        sm += table[ch][mineral.get(minerals[i])];
                    }
                    if (minerals.length <= ii) continue;
                    if (diamond == 0 && iron == 0 && stone == 0) {
                        if (mnv > sm) {
                            mnv = sm;
                        }
                        continue;
                    }
                    tmp.add(sm);
                    tmp.add(idx+5);
                    tmp.add(diamond);
                    tmp.add(iron);
                    tmp.add(stone);
                    q.add(tmp);
                }
            }
        }
        return mnv;
    }
}