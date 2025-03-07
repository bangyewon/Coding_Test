class Solution {
    // 기본 이용료 : price -> n 번이용시 price x n
    // money - (price x n) : money가 - 가 되는 시점 return 하자
    public long solution(int price, int money, int count) {
        long sum = 0;
        // for문으로 계속 돌린다음 money가 - 되는 시점 break로 나오기
       for (int i = 1; i <= count; i++) {
            sum += (long) price * i;
        }

        long answer = money - sum;
        return answer < 0 ? -answer : 0;
    }
}
