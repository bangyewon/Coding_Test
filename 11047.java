import java.util.*;
public class Main6 {
    // N종류의 동전 -> 가치의 합 K로 만들기 필요 동전 최솟값
    // 동전 개수 구하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[N] = sc.nextInt();
        }

        int count = 0; // 동전 개수
        // 동전 종류에서 거꾸로 for문돌기
        for(int i = N-1; i >= 0; i--) {
            // 해당 값이 K가 되면 count에 누적
            if(A[i] <= K ) {
                count += (K / A[i]);
                K = K % A[i];
            }
        }
        System.out.println(count);
    }
}