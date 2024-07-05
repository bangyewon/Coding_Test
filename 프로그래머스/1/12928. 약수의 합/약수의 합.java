class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i =1; i <= n; i++) {
            //끝까지 갔을 때
            if(n % i == 0) {
                answer += i;
            }
        }
        return answer;
    }
}