import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> asdf = new ArrayList<>();
        for(int i = 0;i<score.length;i++){
            asdf.add(score[i]);
            if(asdf.size() > k){
                Collections.sort(asdf);
                asdf.remove(0);
            }
            answer[i] = Collections.min(asdf);
        }
        return answer;
    }
}