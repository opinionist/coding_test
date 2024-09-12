class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int atcount = 0;
        int success = 0;
        int time = 0;
        int HP = health;
        for(int i = 0; i<attacks[attacks.length-1][0]+1;i++){
            if(HP > 0){
                if(i == attacks[atcount][0]){
                    HP -= attacks[atcount][1];
                    success = 0;
                    atcount++;
                }
                if(success > 0){
                    if(success == bandage[0]){
                        HP += bandage[1] + bandage[2];
                        success = 0;
                    }
                    else{
                        HP += bandage[1];
                        success++;
                    }
                }
                if(success == 0){
                    success++;
                }
                if(HP > health){
                    HP = health;
                }
                if(HP < 1){
                    HP = -1;
                }
            }
            else{
                HP = -1;
            }
        }
        return HP;
    }
}