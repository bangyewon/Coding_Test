import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        StringBuilder answer = new StringBuilder(new String(charArray));
        answer.reverse();
        return answer.toString();
    }
}
