import java.util.*;
import java.awt.Point;
public class Main4 {
    // 최단경로 찾기 : BFS 사용이 효과적일 것
    static boolean[][] visited; // 방문 여부
    static int[][] graph; // NxM으로 그래프 구현
    // static int count;
    static int N;
    static int M;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동 : x
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 이동 : y
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 지나야 하는 최소 칸 수 받기
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][M];
        visited = new boolean[N][M];
        // 그래프 구현
        for(int i = 0; i < N; i++) {
            String line = sc.next();
            for(int j = 0; j < M; j++) { // StringIndexOutOfBounds 에러 수정 -> index for문 잘못 참조함
                // 붙어서 입력이 주어진다  : Line으로 받아서 정수로 변환하자
                graph[i][j] = line.charAt(j) - '0';
            }
        }
        // for(int j = 1; j <= N; j++) {
        //     for(int i = 1; i <= M; j++) {
        //         if(!visited[j][i] && graph[j][i] == 1) {
        //             // count = 0;
        //             // BFS(i,j); // 방문 안했으면 해당 정점에서 BFS탐색
        //             // count ++;
        //         }
        //     }
        // }
        BFS(0, 0);   // 시작위치
        System.out.println(graph[N - 1][M - 1]);  // 마지막 칸의 인덱스로 값을 출력
    }
    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y)); // 생각하지 못한 부분 
        visited[x][y] = true;   // 방문여부 초기화

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            // 현재 위치에서 사방위 이동가능여부 판별해주기
            for (int i = 0; i < 4; i++) {
                int nX = current.x + dx[i];
                int nY = current.y + dy[i];
                // BFS 방문조건 판단
                // 범위 안에 있는지 
                if (nX < 0 || nX >= N || nY < 0 || nY >= M)
                    continue;  
                // 0 이면 가지 못함
                if (graph[nX][nY] == 0)
                    continue; 
                // 방문 여부
                if (visited[nX][nY])
                    continue; 
                //방문 안했고, 1로 되있으면 queue 에 삽입해주고 방문처리
                queue.offer(new Point(nX, nY));
                visited[nX][nY] = true;
                // 최소 칸의 수를 구해야됨 :  해당하는 칸에 1씩 누적
                // 도착 칸이면 그 값이 지나야 하는 최소 칸의 수
                graph[nX][nY] = graph[current.x][current.y] + 1;
            }
        }
    }
}
