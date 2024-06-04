import java.util.*;

public class Main{
    // 지도에서 섬의 개수를 세는 프로그램
    static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 }; // x축 이동
    static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 }; // y축 이동
    static int[][] ground;
    static boolean[][] visited;
    static int w;
    static int h;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) { // h,w가 0일때 종료하기전까지 계속돌자
            w = sc.nextInt(); // 너비
            h = sc.nextInt(); // 높이
            if (w == 0 && h == 0) break; // 종료 조건

            ground = new int[h][w];
            visited = new boolean[h][w];

            // 그리드 채우기
            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    ground[j][k] = sc.nextInt();
                }
            }

            int count = 0; // 섬 개수 초기화

            // 섬 세기
            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    if (ground[j][k] == 1 && !visited[j][k]) {
                        DFS(j, k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

        sc.close();
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if (ground[nx][ny] == 1 && !visited[nx][ny]) {
                    DFS(nx, ny);
                }
            }
        }
    }
}
