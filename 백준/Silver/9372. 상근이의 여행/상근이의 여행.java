import java.io.*;
import java.util.*;

public class Main {
    // 가장 적은 종류의 비행기 타기
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 개수

        // 테스트 케이스 돌면서 N-1 출력
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); // 국가 수
            int M = Integer.parseInt(st.nextToken()); // 비행기 종류
            // M개의 줄에 a와 b 쌍 입력 -> 연결됨 의미 (트리 간선)
            for(int m = 0; m < M; m++) {
                br.readLine(); // 각 줄의 입력을 단순히 읽기만 함
            }
            System.out.println(N - 1);
        }
    }
}
