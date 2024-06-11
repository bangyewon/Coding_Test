import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 수빈 : N 위치 -> X+1, X-1, 2*X / 동생 : K 위치
    // 가장 빠른 시간 찾기 : BFS
    static boolean[] visited = new boolean[100001];
    static int[] max = new int[100001]; // 도달까지 걸리는 시간(1초부터 시작 -)
    static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 문자열 공백 기준으로 구분
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 위치 같을 때
        if (n == k) {
            System.out.println(0); // 찾을 시간 필요 없음 0초
        } else {
            bfs(n); // 탐색
            System.out.println(max[k]); // 동생 위치까지의 최소 시간 출력
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        max[start] = 0; // 시작 위치의 시간은 0초

        while (!queue.isEmpty()) {
            int c = queue.poll();
            
            int[] nextMove = {c - 1, c + 1, c * 2}; // 가능한 다음 위치들
            
            for (int next : nextMove) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    max[next] = max[c] + 1;
                    
                    if (next == k) {
                        return; // 동생 위치에 도달하면 종료
                    }
                }
            }
        }
    }
}
