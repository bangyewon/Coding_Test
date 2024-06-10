import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    static int N;
    static StringBuilder sb = new StringBuilder(); // 결과 저장할 스트링 빌더

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 정점개수 받기
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N];

        //인접행렬로 주어짐 -> 그래프 구성하기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 읽어들인 문자열 분리가능
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken()); // 문자열 공백 기준으로 분리 후 정수로 변환해 배열에 저장
            }
        }

        // 그래프 완성
        // bfs 탐색으로 연결여부 확인
        for (int i = 0; i < N; i++) {
            bfs(i);
        }
        System.out.println(sb);
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v); // 시작점
        visited = new boolean[N]; // 방문 여부 초기화

        while (!queue.isEmpty()) {
            int c = queue.poll();
            for (int i = 0; i < N; i++) {
                if (graph[c][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }

        // 방문한 정점에 대한 정보를 StringBuilder에 추가
        for (int i = 0; i < N; i++) {
            sb.append(visited[i] ? "1" : "0"); // 방문한 정점이면 1, 아니면 0
            sb.append(" "); // 공백을 추가하여 구분
        }
        sb.append("\n"); // 한 줄의 정보를 저장한 후 줄 바꿈 문자 추가
    }
}
