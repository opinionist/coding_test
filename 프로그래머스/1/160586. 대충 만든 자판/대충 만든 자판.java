import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> best = new HashMap<>();
        
        for (int i = 0; i < keymap.length; i++) {
            for (int n = 0; n < keymap[i].length(); n++) {
                char key = keymap[i].charAt(n);
                best.put(key, Math.min(best.getOrDefault(key, Integer.MAX_VALUE), n + 1));
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int totalPresses = 0;
            boolean canMake = true;

            for (int n = 0; n < targets[i].length(); n++) {
                char value = targets[i].charAt(n);
                
                if (!best.containsKey(value)) {
                    canMake = false;
                    break;
                }
                totalPresses += best.get(value);
            }

            if (!canMake) {
                answer[i] = -1;
            } else {
                answer[i] = totalPresses;
            }
        }
        return answer;
    }
}
