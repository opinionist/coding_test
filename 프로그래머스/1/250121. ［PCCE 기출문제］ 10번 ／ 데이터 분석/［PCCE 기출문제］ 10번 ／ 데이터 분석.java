import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] extArray = {"code", "date", "maximum", "remain"};
        int num = 0;
        while(!extArray[num].equals(ext)){
            num++;
        }
        int sort = 0;
        while(!extArray[sort].equals(sort_by)){
            sort++;
        }
        Map<Integer,int[]> answerkey = new HashMap<>();
        for(int i = 0; i < data.length;i++){
            if(data[i][num] < val_ext){
                answerkey.put(data[i][sort], data[i]);
            }
        }
        int size = answerkey.size();
        int[][] answer = new int[size][4];
        for(int i = 0; i< size;i++){
            int[] last = answerkey.get(Collections.min(answerkey.keySet()));
            answer[i][0] = last[0];
            answer[i][1] = last[1];
            answer[i][2] = last[2];
            answer[i][3] = last[3];
            answerkey.remove(Collections.min(answerkey.keySet()));
        }
        return answer;
    }
}