class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        // String으로 형변환
        String str =String.valueOf(x);
        // char배열로 형변환
        char[] cArray = str.toCharArray();
        for(char ch : cArray) {
            sum += ch - '0';
        }
        if(x % sum == 0) {
            answer = true;
        }
        else {
            answer = false;
        }
        return answer;
    }
}