// 맨 뒷자리 4개 제외 모두 *로 출력
// StringBuilder 사용해 마지막 4자리 이외 모든 숫자 삭제 후 * 삽입
class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder(phone_number);
        
        // 4자리 남기고 앞 부분 삭제
        sb.delete(0, phone_number.length() - 4);
        
        // 앞에 '*' 추가
        for (int i = 0; i < phone_number.length() - 4; i++) {
            sb.insert(0, "*");
        }
        
        String answer = sb.toString();
        return answer;
    }
}
