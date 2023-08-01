import java.util.*;

class Solution {
    static int[][] arr = {{2, 3}, {2, 4}, {3, 4}};
    
    public long solution(int[] weights) {
        long answer = 0;
        double[] seesaw = {1, 2.0/3.0, 1.0/2.0, 3.0/4.0};
        Arrays.sort(weights);
        for (int i = 0; i < weights.length; i++) {
            for (int j = i+1; j < weights.length; j++) {
                if (weights[i] != weights[j]) {
                    for (int[] e : arr) {
                        if (weights[j]*e[0] == weights[i]*e[1]) {
                            answer++;
                            break;
                        } else if (weights[i]*e[0] == weights[j]*e[1]) {
                            answer++;
                            break;
                        }
                    }
                } else {
                    answer++;
                }

            }
        }
        return answer;
    }
}