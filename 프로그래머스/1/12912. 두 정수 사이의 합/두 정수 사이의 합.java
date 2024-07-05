class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        // 배열 만들어서 a ~ b 까지 수 증가하게 ?
        if(b > a) {
          int[] array = new int[b - a + 1];         
        // 배열에 a부터 b까지의 정수 저장
        for (int i = 0; i < array.length; i++) {
            array[i] = a + i;
            }
            for(int n:array) {
                answer += n;
            }
        } else if(a == b) {
            answer = a;
        } else {
            int[] array = new int[a - b + 1];
            for(int i = 0; i < array.length; i++) {
                array[i] = b + i;
            }
            for(int n:array) {
                answer += n;
            }
        }
        return answer;
    }
}