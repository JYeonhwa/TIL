import java.util.*;

class Solution {
    Queue<int[]> q = new LinkedList<>();
    
    public int solution(int x, int y, int n) {
        int[] data = {y, 0};
        q.add(data);
        while (q.size() != 0) {
            int[] tmp = q.poll();
            int sm = tmp[0];
            int time = tmp[1];
            if (sm == x) {
                return time;
            }
            if (sm%3 == 0) {
                int[] datas = {sm/3, time+1};
                q.add(datas);
            }
            if (sm%2 == 0) {
                int[] datas = {sm/2, time+1};
                q.add(datas);
            }
            if (sm-n >= x) {
                int[] datas = {sm-n, time+1};
                q.add(datas);
            }
        }
        return -1;
    }
}