import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        List<Integer> days = new ArrayList<>();
        for(int i = 0;i<7;i++){
            if(startday > 5){
                startday++;
            }
            else{
                startday++;
                days.add(i);
            }
            if(startday > 7){
                startday = 1;
            }
        }
        int[] array = new int[schedules.length];
        
        for(Integer i : days){
            for(int j = 0; j<schedules.length;j++){
                int timelog = timelogs[j][i];
                if(timelog % 100 < 10){
                    timelog = timelog - 100 + 60;
                }
                // System.out.println(timelog);
                if(timelog - schedules[j] > 10){
                    array[j] += 1;
                }
            }
        }
        
        for(int i=0;i<schedules.length;i++){
            if(array[i] == 0){
                answer++;
            }
        }
        
        return answer;
    }
}