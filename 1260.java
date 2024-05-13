import java.util.*;
public class Main2 {
    // DFS / BFS 출력하기 -> 각각 함수 만들기
    // N : 정점 개수  M : 간선 개수  V : 시작 정점
    // 고민해야할 점 : M 연결간선을 어떻게 ?
    static int[][] adj;
    static boolean visited[]; // 방문여부 배열

    private static void DFS(int V) {
        visited[V] = true;
        System.out.println(V + " ");
        for(int j = 1; j < adj.length; j++) {
            if(adj[V][j] ==1 && visited[j]!= true) {
                DFS(j); // 재귀호출로
            }
        }
    }
    private static void BFS(int V) { // 큐로 !
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(V); // 시작 정점 넣고
        visited[V] = true; // true로 초기화 
        // 큐 비어있지 않으면 계속 진행
        while(!queue.isEmpty()) {
            int p = queue.poll();
            System.out.println(p + " "); // 큐에서 꺼낸 정점 출력하기
            //노드가 한개로 연결된 노드부터 
            for(int i = 1; i < adj.length; i++) {
                //연결되있는데 방문 X 경우
                if(adj[p][i] == 1 && visited[i] != true) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int V = sc.nextInt();
    
    adj = new int[N+1][N+1];

    for( int i = 0; i < M; i++) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        //노드 연결 ? -> 1로
        adj[a][b] = 1;
        adj[b][a] = 1;
        }
        visited = new boolean[N + 1];
        DFS(V);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(V);
        sc.close();
    }

}
