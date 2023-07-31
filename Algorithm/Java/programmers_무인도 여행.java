import java.util.*;

class Solution {
    
    static int sizer, sizec;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();
    static List<Integer> answer = new ArrayList<Integer>();
    
    public List<Integer> solution(String[] maps) {
        sizer = maps.length;
        sizec = maps[0].length();
        visit = new boolean[sizer][sizec];
        for (int r = 0; r < sizer; r++) {
            for (int c = 0; c < sizec; c++) {
                if (visit[r][c] == false && maps[r].charAt(c) != 'X') {
                    visit[r][c] = true;
                    int[] point = {r, c, maps[r].charAt(c) - '0'};
                    q.offer(point);
                    answer.add(bfs(maps));
                }
            }
        }
        if (answer.size() != 0) {
            Collections.sort(answer);
        } else {
            answer.add(-1);
        }
        return answer;
    }
    
    public Integer bfs(String[] maps) {
        int day = 0;
        while (q.size() != 0) {
            int[] v = q.poll();
            int rr = v[0];
            int cc = v[1];
            day += maps[rr].charAt(cc)-'0';
            for (int d = 0; d < 4; d++) {
                int nr = rr + dr[d];
                int nc = cc + dc[d];
                if (0 <= nr && nr < sizer && 0 <= nc && nc < sizec && visit[nr][nc] == false && maps[nr].charAt(nc) != 'X') {
                    visit[nr][nc] = true;
                    int[] point = {nr, nc};
                    q.offer(point);
                }
            }
        }
        System.out.println(day);
        return day;
    }
}
