import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        int sLength = s.length();
        int skLength = skip.length();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < skLength; i++) {
            map.put(skip.charAt(i), i);
        }
        
        for (int i = 0; i < sLength; i++) {
            char an = s.charAt(i);
            int limit = index;
            
            for (int j = 0; j < limit; j++) {
                an++;
                
                if (an > 'z') {
                    an -= 26;
                }
                
                if (map.containsKey(an)) {
                    limit++;
                }
            }
            
            answer += an;
        }
        
        return answer;
    }
}
