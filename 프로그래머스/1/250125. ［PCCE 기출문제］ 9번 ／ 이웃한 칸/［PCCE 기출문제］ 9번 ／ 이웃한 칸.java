class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int[] dh = {0,1,-1,0};
        int[] dw = {1,0,0,-1};
        for(int i = 0; i<4;i++){
            int h_ch = h+dh[i];
            int w_ch = w+dw[i];
            if((h_ch >= 0 && h_ch < n) && (w_ch >= 0 && w_ch < n)){
                if(board[h][w].equals(board[h_ch][w_ch])){
                    answer++;
                }
            }
        }
        return answer;
    }
}