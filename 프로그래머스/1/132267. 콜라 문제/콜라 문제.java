class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a){
            int cola = n / a * b;
            n = cola + (n % a);
            answer += cola; 
        }
        return answer;
    }
}