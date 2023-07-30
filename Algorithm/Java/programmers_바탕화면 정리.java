class Solution {
    public int[] solution(String[] wallpaper) {
        int sizer = wallpaper.length;
        int sizec = wallpaper[0].length();
        int[] answer = {sizer, sizec, 0, 0};
        for (int r = 0; r < sizer; r++) {
            for (int c = 0; c < sizec; c++) {
                if (wallpaper[r].charAt(c) == '#') {
                    if (answer[1] > c) {
                        answer[1] = c;
                    }
                    if (answer[0] > r) {
                        answer[0] = r;
                    }
                    if (answer[3] < c+1) {
                        answer[3] = c+1;
                    }
                    if (answer[2] < r+1) {
                        answer[2] = r+1;
                    }
                }
            }
        }
        return answer;
    }
}