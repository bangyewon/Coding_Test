import java.util.Arrays;
class Solution {
    public long solution(long n) {
        
       String[] array = String.valueOf(n).split(""); // 문자열로 변환
        // 오름차순 정렬 : a.compareTo(b)
        Arrays.sort(array, (a, b) -> b.compareTo(a)); // 람다식으로 내림차순 정렬
        
        StringBuilder answer = new StringBuilder();
        for (String digit : array) {
            answer.append(digit);
        }
        
        return Long.parseLong(answer.toString());
    }
}