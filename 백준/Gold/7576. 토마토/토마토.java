import java.util.*;

public class Main{
    // 토마토 문제 
    static int[][] box;
    static boolean[][] visited;
    // 네 방향으로 영향 줌
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int m;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt(); // 가로
        n = sc.nextInt(); // 세로
        box = new int[n][m];
        visited = new boolean[n][m];
        // 박스 채우기 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = sc.nextInt(); // 인덱스 수정
                // 방문 못하는 위치 : 토마토 없을 때 -1
                // 이미 방문했다고 치고 넘어감
                if (box[i][j] == -1) {
                    visited[i][j] = true;
                }
            }
        }
        // 박스 구현 완
        System.out.println(BFS());
    }

    public static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        int day = 0; // 출력값 초기화
        // 익은 토마토들 추가
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 해당 위치 토마토가 익었다면?
                if (box[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean newTomatoRipened = false;

            for (int i = 0; i < size; i++) {
                // 현재 위치 배열 만들어서 x, y 따로 저장
                int[] c = queue.poll(); // 현재 위치 저장
                int x = c[0];
                int y = c[1];
                // 움직임
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (box[nx][ny] == 0 && !visited[nx][ny]) {
                            queue.offer(new int[] { nx, ny });
                            visited[nx][ny] = true;
                            box[nx][ny] = 1; // 토마토 익음!
                        }
                    }
                }
            }
            if (!queue.isEmpty()) {
                day++;
            }
        }
        // 익지 않은 토마토가 있는지 반드시 확인해야 함
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 0이면 익지 않은 토마토가 위치한 곳
                if (box[i][j] == 0) {
                    return -1; // BFS 수행 후에도 익지 않은 토마토가 남아있다면 이는 모든 토마토를 익힐 수 없다고 판단 -1로 반환
                }
            }
        }
        return day;
    }
}
