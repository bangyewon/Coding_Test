import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        // 정수열 -> 문자열로 
        String str = String.valueOf(n);
        
        for(int i = 0; i < str.length(); i++) {
            answer += Character.getNumericValue(str.charAt(i));
        }
    
        return answer;
    }
}
