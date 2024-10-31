import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> sub = new Stack<>();
        int nextBox = 1;

        for (int i = 0; i < order.length; i++) {
            while (nextBox <= order[i]) {
                sub.push(nextBox);
                nextBox++;
            }

            if (!sub.isEmpty() && sub.peek() == order[i]) {
                answer++;
                sub.pop();
            } else {
                break;
            }
        }

        return answer;
    }
}
