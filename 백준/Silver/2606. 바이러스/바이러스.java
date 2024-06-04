import java.util.*;
public class Main {
    // 1 ->2536 / 4,7은 연결 x
    static int[][] adj; // 인접행렬로 가자
    static boolean visited[]; // 방문배열
    static int count = 0; // 출력값
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt(); // 컴퓨터의 수
        int N = sc.nextInt(); // 연결된 쌍의 수
        // 입력받은 컴퓨터들로 인접행렬 공간 만들기
        adj = new int[S+1][S+1]; 
        visited = new boolean[S+1];
        //연결된 컴퓨터 쌍 입력받아 행렬에 채우기
        for(int i = 0; i < N; i++) {
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        adj[c1][c2] = 1; // 연결되있기에 1로
        adj[c2][c1] = 1;
        // 그래프 구현 완
        }
        // 인접 행렬 갖고 BFS 실행
        
        System.out.println(BFS(1));
    }
    public static int BFS(int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        visited[k] = true;
        while(!queue.isEmpty()) {
            int p = queue.poll(); // 현재위치 저장
            for(int i = 1; i < adj.length; i++) {
                if(adj[p][i] == 1 && visited[i] != true) {
                    queue.offer(i);
                    visited[i] = true;
                    count ++;
                }
            }
        }
        return count;
    }
}