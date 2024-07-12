class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        for (int num : arr) {
            boolean found = false;
            for (int number : numbers) {
                if (num == number) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                answer += num;
            }
        }
        
        return answer;
    }
}
