class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length; j++) {
                if (park[i][j].equals("-1")) {
                    int num = checkmat(mats, park, i, j);
                    if (num >= answer) {
                        answer = num;
                    }
                }
            }
        }
        return answer;
    }

int checkmat(int[] mats, String[][] park, int startW, int startL) {
    int answer = -1;
    int height = park.length;
    int width = park[0].length;

    for (int mat : mats) {
        if (startW + mat > height || startL + mat > width) {
            continue;
        }

        boolean valid = true;

        for (int i = 0; i < mat; i++) {
            for (int j = 0; j < mat; j++) {
                if (!park[startW + i][startL + j].equals("-1")) {
                    valid = false;
                    break;
                }
            }
            if (!valid) break;
        }

        if (valid) {
            if(answer < mat){
                answer = mat;
            }
        }
    }
    return answer;
}

}
