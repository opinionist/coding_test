import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int l : lost) {
            lostSet.add(l);
        }
        for (int r : reserve) {
            if (lostSet.contains(r)) {
                lostSet.remove(r);
            } else {
                reserveSet.add(r);
            }
        }

        int answer = n - lostSet.size();
        for (int l : lostSet) {
            if (reserveSet.contains(l - 1)) {
                answer++;
                reserveSet.remove(l - 1);
            } else if (reserveSet.contains(l + 1)) {
                answer++;
                reserveSet.remove(l + 1);
            }
        }

        return answer;
    }
}
