// 가운데 글자만 반환
// splite or charAt으로 한글자씩 변환
// 가운데 글자가 안나올땐 2글자 반환
class Solution {
    public String solution(String s) {
        String answer = "";
        int length = s.length();
        
        if (length % 2 == 0) {
            // substring() : start부터 end 이전까지 문자열 반환
            answer = s.substring(length / 2 - 1, length / 2 + 1);
        } else {
            answer = String.valueOf(s.charAt(length / 2));
        }
        
        return answer;
    }
}
