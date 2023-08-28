import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        ArrayList<Integer[]> book_times = new ArrayList<Integer[]>();
        for (String[] el: book_time) {
            Integer number1 = Integer.valueOf(el[0].split(":")[0]);
            Integer number2 = Integer.valueOf(el[0].split(":")[1]);
            Integer number3 = Integer.valueOf(el[1].split(":")[0]);
            Integer number4 = Integer.valueOf(el[1].split(":")[1]);
            Integer[] tmp = {number1*100+number2, number3*100+number4};
            book_times.add(tmp);
        }
        Collections.sort(book_times, (a, b) -> a[0] - b[0]);
        int[] rooms = new int[book_times.size()];
        for (Integer[] el: book_times) {
            for (int i = 0; i < rooms.length; i++) {
                if (rooms[i] <= el[0] || rooms[i] == 0) {
                    int endtime = el[1];
                    int hour = el[1]/100;
                    int minute = (el[1]+10)%100;
                    if (minute >= 60) {
                        endtime = (endtime/100 + 1) * 100 + minute - 60;
                    } else {
                        endtime = endtime+10;
                    }
                    rooms[i] = endtime;
                    // System.out.println(Arrays.toString(rooms));
                    break;
                }
            }
        }
        int answer = 0;
        for (int el: rooms) {
            if (el != 0) {
                answer++;
            }
        }
        return answer;
    }
}