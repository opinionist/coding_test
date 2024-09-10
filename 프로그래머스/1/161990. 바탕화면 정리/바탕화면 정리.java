class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        int xmin = 100;
        int ymin = 100;
        int xmax =0;
        int ymax =0;
        int frist = 0;
        for(int i = 0; i < wallpaper.length;i++){
            for(int n = 0; n < wallpaper[i].length();n++){
                if(wallpaper[i].substring(n,n+1).equals("#")){
                    if(xmax <= n){
                        xmax = n;
                    }
                    if(ymax <= i){
                        ymax = i;
                    }
                    if(xmin >= n){
                        xmin = n;
                    }
                    if(ymin >= i){
                        ymin = i;
                    }
                }
            }
        }
        answer[0] = ymin;
        answer[1] = xmin;
        answer[2] = ymax+1;
        answer[3] = xmax+1;
        
        return answer;
    }
}