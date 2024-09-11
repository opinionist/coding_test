import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int hIndex = 0;
        
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                hIndex = h;
                break;
            }
        }
        
        return hIndex;
    }
}
