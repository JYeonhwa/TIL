import java.util.*;

class Solution {
    
    
    public int solution(int n, int[][] wires) {
        Map<Integer, List<Integer>> nodes = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> tmp = new ArrayList<>();
            nodes.put(i, tmp);
        }
        for (int i = 0; i < wires.length; i++) {
            List<Integer> w1 = nodes.get(wires[i][0]);
            List<Integer> w2 = nodes.get(wires[i][1]);
            w1.add(wires[i][1]);
            w2.add(wires[i][0]);
            nodes.put(wires[i][0], w1);
            nodes.put(wires[i][1], w2);
        }
        int mnv = 99;
        for (int cut = 0; cut < wires.length; cut++) {
            int[] visit = new int[n+1]; 
            Arrays.fill(visit, 0);
            visit[0] = 1;
            
            int start1 = wires[cut][0];
            int start2 = wires[cut][1];
            int cnt1 = 1;
            int cnt2 = 1;
            Queue<Integer> que = new LinkedList<>();
            que.add(start1);
            visit[start1] = 1;
            while (que.size() != 0) {
                int node = que.poll();
                for (Integer nxt : nodes.get(node)) {
                    if (visit[nxt] == 0 && (node != start1 || nxt != start2)) {
                        que.add(nxt);
                        visit[nxt] = 1;
                        cnt1++;
                    }
                }
            }
            Queue<Integer> que2 = new LinkedList<>();
            que2.add(start2);
            visit[start2] = 1;
            while (que2.size() != 0) {
                int node = que2.poll();
                for (Integer nxt : nodes.get(node)) {
                    if (visit[nxt] == 0 && (node != start2 || nxt != start1)) {
                        que2.add(nxt);
                        visit[nxt] = 1;
                        cnt2++;
                    }
                }
            }
            if (cnt1+cnt2 != n) {
                continue;
            } 
            int sm = 0;
            if (cnt1 >= cnt2) {
                sm = cnt1 - cnt2;
            } else {
                sm = cnt2 - cnt1;
            }
            if (mnv > sm) {
                mnv = sm;
            }
        }
        int answer = mnv;
        return answer;
    }
}
