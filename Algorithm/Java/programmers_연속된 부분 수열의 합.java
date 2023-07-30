import java.util.Arrays;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        if (sequence[0] == k) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
        int[] pointer = new int[2];
        answer[0] = 0;
        answer[1] = sequence.length-1;
        pointer[0] = 0;
        pointer[1] = 1;
        int sm = sequence[0];
        while (pointer[1] < sequence.length) {
            sm += sequence[pointer[1]];
            if (sm > k) {
                while (true) {
                    sm -= sequence[pointer[0]];
                    pointer[0]++;
                    if (sm <= k) {
                        break;
                    }
                }
            } 
            if (sm == k) {
                if (answer[1] - answer[0] > pointer[1] - pointer[0]) {
                    answer[0] = pointer[0];
                    answer[1] = pointer[1];
                }
            }
            pointer[1]++;
        }
        return answer;
    }
}