import java.util.*;

class Solution {
    public List<Integer> solution(int[] fees, String[] records) {
        Map<String, int[]> cartime = new HashMap<String, int[]>();
        Map<String, Integer> carminute = new HashMap<String, Integer>();
        for (int i = 0; i<records.length; i++) {
            String[] tmp = records[i].split(" ");
            if (!cartime.containsKey(tmp[1]) || cartime.get(tmp[1])[0] == -1) {
                //만약 이 차가 처음 보는 차거나 아까 나간 차면 입차 기록 찍기
                String[] timetmp = tmp[0].split(":");
                int hour = Integer.parseInt(timetmp[0]);
                int minute = Integer.parseInt(timetmp[1]);
                int[] time = {hour, minute};
                cartime.put(tmp[1], time);
            } else {
                // 둘 다 아니면 출차 기록이니까 정산 후 시간 기록 리셋
                int[] arrival = cartime.get(tmp[1]);
                String[] timetmp = tmp[0].split(":");
                int departhour = Integer.parseInt(timetmp[0]);
                int departminute = Integer.parseInt(timetmp[1]);
                
                // 분 단위로 환산
                int arrivalmin = arrival[0] * 60 + arrival[1];
                int departmin = departhour * 60 + departminute;
                int min = departmin - arrivalmin;
                
                
                if (carminute.containsKey(tmp[1])) {
                    carminute.put(tmp[1], carminute.get(tmp[1])+min);
                } else {
                    carminute.put(tmp[1], min);
                }
                
                // 리셋
                int[] tt = {-1};
                cartime.put(tmp[1], tt);
            }
        }
        
        Set<Map.Entry<String, int[]>> cartimedata = cartime.entrySet();
        
        // 23:59까지 안 뺀 차 23:59 == 23 * 60 + 59
        Set<String> cars = cartime.keySet();
        for (String el: cars) {
            if (cartime.get(el)[0] != -1) {
                int[] arrival = cartime.get(el);
                // 분 단위로 환산
                int arrivalmin = arrival[0] * 60 + arrival[1];
                int departmin = 23 * 60 + 59;
                int min = departmin - arrivalmin;
                
                carminute.put(el, carminute.getOrDefault(el, 0)+min);
            }
        }
        
        List<String> carminutedata = new ArrayList(carminute.keySet());
        Collections.sort(carminutedata);
        
        
        List<Integer> answer = new ArrayList<Integer>();
        
        for (String el: carminutedata) {
            int min = carminute.get(el);
            // 정산
            int money = 0;
            if (min <= fees[0]) {
                money = fees[1];
            } else {
                int plus = (int) Math.ceil((double) (min - fees[0])/fees[2]);
                money = fees[1] + plus * fees[3];
            }
            answer.add(money);
        }
        
        
        return answer;
    }
}