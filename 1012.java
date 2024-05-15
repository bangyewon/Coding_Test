import java.util.*;
// 수정 필요 
// 인접해있는 배추들 알기
public class Main {
    static int dx[] = {-1, 1, 0, 0}; // 좌우 움직이기 배열
    static int dy[] = {0, 0, -1, 1}; // 상하 움직이기 배열
    static boolean[][] visited; // 방문 체크배열
    static int[][] ground; // 땅
    static int count; // 체크
    static int[] sizes; // count 배열로 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스
// 테스트 케이스에 따라 N,M 주어짐 -> ground 너비 달라짐
// 모든 건 테스트 케이스에 개수 따라 달라지므로 
        for(int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            ground = new int[M][N]; //N,M너비로 땅 객체 생성
            // 배추 줄의 위치 주어짐(K)으로 X,Y도 받기
            for(int j = 0; j < K; j++) {
                int X = sc.nextInt(); // 배추가 심어져 있는 곳 X
                int Y = sc.nextInt(); // 배추가 심어져 있는 곳 Y
                ground[X][Y] = 1; // 배추가 있는 위치
            }
            int count = 0;
            visited = new boolean[M][N]; // 방문한 위치
            // 방문 조건 생각하기 (M,N 돌면서 !)
            for(int s = 0; s < M; s++) {
                for(int c = 0; c < N; c++) {
                    // 해당 지점에 배추가 존재(1)and 방문한적 없어야 함
                    if(ground[s][c] == 1 && visited[s][c] == false) {
                        DFS(s,c,M,N);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static void DFS(int x, int y, int M, int N) {
        visited[x][y] = true; // 방문 체크
        for (int i = 0; i < 4; i++) {
            int X = dx[i] + x;
            int Y = dy[i] + y;
            if (X >= 0 && X < M && Y >= 0 && Y < N && ground[X][Y] == 1 && visited[X][Y] == false) {
                DFS(X, Y, M, N);
            }
        }
    }    
    
}
