class Solution {
    public String solution(int[] food) {
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        
        // 음식 양을 절반으로 나누어 left와 right에 추가
        for (int i = 1; i < food.length; i++) {
            int half = food[i] / 2;
            for (int j = 0; j < half; j++) {
                left.append(i);
            }
        }
        
        // right는 left의 역순으로
        right.append(left).reverse();
        
        String answer = left.toString() + "0" + right.toString();
        return answer;
    }
}
