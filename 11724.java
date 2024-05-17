import java.util.*;
public class Main {
    // for문으로 무방향 그래프 구현 후 DFS or BFS 적용 
    // 그래프 구현 ->u,v 받아서 구성
    // 간선을 어떻게 연결시킬 것인지 고민
    static int[][] graph;
    static boolean[] visited;
    static int count; // 연결 요소를 출력해야함 ! -> DFS 실행마다 count 올라가게 : 최종출력값
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 정점 개수
        int M = sc.nextInt(); // 간선 개수
        count = 0;
        graph = new int[N+1][N+1]; // 그래프 객체 생성
        visited = new boolean[N+1]; // 방문여부 객체 생성 
        for (int i = 1; i <= M; i++) { // 간선만큼 입력받은 정점에 연결시키기
            // 무방향 그래프 인지하기 !
            int u = sc.nextInt(); // 정점 1
            int v = sc.nextInt(); // 정점 2
            // 입력받은 정점들 연결 -> 무방향 이어서 바꿔서도 연결되있어야함
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        // 입력받은 정점들 방문 여부 판단 -> N 만큼 돌면서 방문 안한 곳 있나 체크
        for(int j = 1; j <= N; j++) {
            if(!visited[j]) {
                DFS(j); // 방문 안했으면 해당 정점에서 DFS 탐색
                count ++;
            }
        }
        System.out.println(count);
    }
    static void DFS(int v) {
        visited[v] = true; // 현재 있는 정점은 방문했다고 설정
        // 돌면서 방문안 한곳 있는지 판단 후 DFS 탐색
        for(int i = 1; i < graph.length; i++) {
            // 방문하지 않았는데 연결되있음
            if(visited[i] == false && graph[v][i] == 1) {
                DFS(i);
            }
        }

    }
}