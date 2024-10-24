import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int num = s.length();
        int[] answer = new int[num];
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i< s.length();i++){
            char key = s.charAt(i);
            if(map.get(key) == null){
                answer[i] = -1;
            }
            else{
                answer[i] = i - map.get(key);
            }
            map.put(key,i);
        }
        return answer;
    }
}