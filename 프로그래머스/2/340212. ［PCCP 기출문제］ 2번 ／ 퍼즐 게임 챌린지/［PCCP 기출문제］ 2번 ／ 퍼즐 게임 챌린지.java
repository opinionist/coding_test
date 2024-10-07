class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 1000000;
        int answer = 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            double time = calculateTime(diffs, times, mid);

            if (time > limit) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        return answer;
    }

    private double calculateTime(int[] diffs, int[] times, int lv) {
        double time = 0;

        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= lv) {
                time += times[i];
            } else {
                if (i == 0) {
                    time += times[i] * (diffs[i] - lv);
                } else {
                    time += (times[i - 1] + times[i]) * (diffs[i] - lv) + times[i];
                }
            }
        }

        return time;
    }
}
