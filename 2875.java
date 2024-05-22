import java.util.*;
public class Main7 {
    // 2명 여학생 + 1명 남학생이 팀
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 여학생
        int M = sc.nextInt(); // 남학생
        int K = sc.nextInt(); // 인턴쉽 참여해야하는 인원(빠져야 하는 인원)
        // 팀 만들기
        // 최소 3명이 한팀이므로 3+K가 전체인원을 넘을 수는 없음
        // 팀만들기 위해선 2명 여학생 / 1명 남학생이므로 최소 M,N의 값 나옴
        int count = 0; // 출력해야하는 값
        while(N >= 2 && M >= 1 && M+N >= 3+K) {
            N = N - 2;
            M = M - 1;
            count ++;
        }
        System.out.println(count);
    }
}
