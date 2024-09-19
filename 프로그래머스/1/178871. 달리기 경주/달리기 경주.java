import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 초기화
        int n = players.length;
        String[] answer = new String[n];
        Map<String, Integer> playerToIndex = new HashMap<>();
        
        // 플레이어와 그 위치를 Map에 저장
        for (int i = 0; i < n; i++) {
            playerToIndex.put(players[i], i);
        }
        
        // 호출 처리
        for (String call : callings) {
            int currentIndex = playerToIndex.get(call);
            if (currentIndex > 0) {
                String prevPlayer = players[currentIndex - 1];
                players[currentIndex] = prevPlayer;
                players[currentIndex - 1] = call;
                playerToIndex.put(call, currentIndex - 1);
                playerToIndex.put(prevPlayer, currentIndex);
            }
        }
        
        for (int i = 0; i < n; i++) {
            answer[i] = players[i];
        }
        
        return answer;
    }
}
